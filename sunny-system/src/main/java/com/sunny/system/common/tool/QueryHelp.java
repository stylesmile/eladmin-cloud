package com.sunny.system.common.tool;

import com.sunny.system.common.aop.annotation.JpaQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author chenye
 * @date 2020-0315
 */
@Slf4j
public class QueryHelp {

    @SuppressWarnings("unchecked")
    public static <R, Q> Predicate getPredicate(Root<R> root, Q query, CriteriaBuilder cb) {
        List<Predicate> list = new ArrayList<>();

        if (query == null) {
            return cb.and(list.toArray(new Predicate[list.size()]));
        }
        try {
            List<Field> fields = getAllFields(query.getClass(), new ArrayList<>());
            for (Field field : fields) {
                boolean accessible = field.isAccessible();
                field.setAccessible(true);
                JpaQuery q = field.getAnnotation(JpaQuery.class);
                if (q != null) {
                    String propName = q.propName();
                    String joinName = q.joinName();
                    String attributeName = isBlank(propName) ? field.getName() : propName;
                    Class<?> fieldType = field.getType();
                    Object val = field.get(query);
                    if (Objects.isNull(val)) {
                        continue;
                    }
                    Join join = null;
                    if (!StringUtils.isEmpty(joinName)) {
                        switch (q.join()) {
                            case LEFT:
                                join = root.join(joinName, JoinType.LEFT);
                                break;
                            case RIGHT:
                                join = root.join(joinName, JoinType.RIGHT);
                                break;
                        }
                    }
                    switch (q.type()) {
                        case EQUAL:
                            list.add(cb.equal(getExpression(attributeName, join, root)
                                    .as((Class<? extends Comparable>) fieldType), val));
                            break;
                        case GREATER_THAN:
                            list.add(cb.greaterThanOrEqualTo(getExpression(attributeName, join, root)
                                    .as((Class<? extends Comparable>) fieldType), (Comparable) val));
                            break;
                        case LESS_THAN:
                            list.add(cb.lessThanOrEqualTo(getExpression(attributeName, join, root)
                                    .as((Class<? extends Comparable>) fieldType), (Comparable) val));
                            break;
                        case LESS_THAN_NQ:
                            list.add(cb.lessThan(getExpression(attributeName, join, root)
                                    .as((Class<? extends Comparable>) fieldType), (Comparable) val));
                            break;
                        case INNER_LIKE:
                            list.add(cb.like(getExpression(attributeName, join, root)
                                    .as(String.class), "%" + val.toString() + "%"));
                            break;
                        case LEFT_LIKE:
                            list.add(cb.like(getExpression(attributeName, join, root)
                                    .as(String.class), "%" + val.toString()));
                            break;
                        case RIGHT_LIKE:
                            list.add(cb.like(getExpression(attributeName, join, root)
                                    .as(String.class), val.toString() + "%"));
                        case IN:
                            if (!CollectionUtils.isEmpty((Collection<Long>) val)) {
                                list.add(getExpression(attributeName, join, root).in((Collection<Long>) val));
                            }
                            break;
                    }
                }
                field.setAccessible(accessible);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return cb.and(list.toArray(new Predicate[list.size()]));
    }

    @SuppressWarnings("unchecked")
    private static <T, R> Expression<T> getExpression(String attributeName, Join join, Root<R> root) {
        if (!ObjectUtils.isEmpty(join)) {
            return join.get(attributeName);
        } else {
            return root.get(attributeName);
        }
    }

    @SuppressWarnings("unchecked")
    public static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    private static List<Field> getAllFields(Class clazz, List<Field> fields) {
        if (clazz != null) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            getAllFields(clazz.getSuperclass(), fields);
        }
        return fields;
    }
}
