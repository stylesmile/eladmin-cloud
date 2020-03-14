package com.sunny.service;

import com.sunny.repository.BaseJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.validation.ValidationException;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Service层基类
 *
 * @author carfield
 */
@Service
public class BaseCURDService<M, E, F, ID extends Serializable> {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    protected BaseJpaRepository<E, ID> repository;

    @Transactional
    public M create(M model) {
        logger.debug("create object: {}", model.toString());
        E entity = this.toEntity(model);
        this.beforeCreate(model, entity);
        entity = this.repository.save(entity);
        this.afterCreate(model, entity);
        return this.toView(entity);
    }

    @Transactional
    public Long delete(ID id) {
        this.beforeDelete(id);
        M model = this.detail(id);
        if (model != null) {
            this.beforeDelete(model);
            this.repository.deleteById(id);
            this.afterDelete(model);
            return 1L;
        }
        throw new ValidationException("数据异常或指定id不存在");
    }

    @Transactional
    public M modify(M target) {
        ID id = this.getID(target);
        if (id == null) {
            throw new ValidationException("id不能为空！");
        }
        logger.debug("id: {}", id);
        E entity = this.repository.getOne(id);
        if (entity != null) {
            this.beforeModify(target, entity);
            entity = this.repository.save(entity);
            this.afterModify(target, entity);
            return this.toView(entity);
        }
        throw new ValidationException("数据异常或指定id不存在");
    }

    /**
     * 如果有缓存实现 ，则先从缓存中获取
     */

    public M detail(ID id) {

        E e = this.repository.getOne(id);
        if (e != null) {
            M v = this.toView(e);
            return v;
        }
        return null;
    }


    public long count(F filter) {
        return this.repository.count(this.toFilter(filter));
    }


    public boolean exists(ID id) {
        return this.repository.existsById(id);
    }


    public List<M> list(F filter, Sort sort) {
        List<E> entitys = this.repository.findAll(this.toFilter(filter), sort);
        List<M> views = this.toModels(entitys);
        return views;
    }


    public Page<M> search(F filter, Pageable pageable) {
        Page<E> entitys = this.repository.findAll(this.toFilter(filter), pageable);
        List<M> content = this.toModels(entitys);
        Page<M> views = new PageImpl<M>(content, pageable, entitys.getTotalElements());
        return views;
    }

    protected List<M> toModels(Iterable<E> entities) {
        List<M> views = new ArrayList<M>();
        if (entities != null) {
            for (E e : entities) {
                M v = this.toView(e);
//                if (cache != null) {
//                    cache.put(v);
//                }
                views.add(v);
            }
        }
        this.afterList(views);
        return views;
    }

    protected E toEntity(M model){
        E e = null;
        BeanUtils.copyProperties(model,e);
        return e;
    };

    protected M toView(E entity){
        return null;
    };;

    protected ID getID(M model){
        return null;
    };

    protected Specification<E> toFilter(F filter){
        return null;
    };

    protected void beforeCreate(M model, E entity) {
    }

    protected void afterCreate(M model, E entity) {
    }

    /**
     * 注意：override此方法时，
     * 如果将model转entity时，忽略某些字段，须去掉super.beforeModify(model,entity);,并手动实现转化
     * 如果将model转entity时，不忽略字段，super.beforeModify(model,entity);须放在首行
     *
     * @param model
     * @param entity
     */
    protected void beforeModify(M model, E entity) {
        this.copyTo(model, entity);
    }

    protected void afterModify(M model, E entity) {
    }

    protected void beforeDelete(ID id) {

    }

    protected void beforeDelete(M model) {

    }

    protected void afterDelete(M model) {
    }

    protected void afterList(List<M> views) {
    }

    protected void copyTo(Object source, Object target, String... ignoreProperties) {
        BeanUtils.copyProperties(source, target, ignoreProperties);
    }

    /**
     * 获取当前登录用户
     *
     * @return
     */
//    protected UserInfo getCurrentUser() {
//        Object principal = SecurityUtils.getSubject().getPrincipal();
//        if (principal == null) {
//            throw new AuthenticationException("未登录");
//        }
//        UserInfo user = (UserInfo) principal;
//        return user;
//    }


//    @Transactional
//    protected E update(E entity){
//        // 获取ID
//        ID entityId = (ID) this.entityInformation.getId(entity);
//        E managedEntity;
//        E mergedEntity;
//        if (entityId == null) {
//            em.persist(entity);
//            mergedEntity = entity;
//        } else {
//            managedEntity = this.getOne(entityId);
//            if (managedEntity == null) {
//                em.persist(entity);
//                mergedEntity = entity;
//            } else {
//                BeanUtils.copyProperties(entity, managedEntity, getNullProperties(entity));
//                em.merge(managedEntity);
//                mergedEntity = managedEntity;
//            }
//        }
//        return entity;
//    }

    protected  E getOne(ID entityId){
        return this.repository.getOne(entityId);
    }
    /** 获取对象的空属性 */
    private static String[] getNullProperties(Object src) {
        // 1.获取Bean
        BeanWrapper srcBean = new BeanWrapperImpl(src);
        // 2.获取Bean的属性描述
        PropertyDescriptor[] pds = srcBean.getPropertyDescriptors();
        // 3.获取Bean的空属性
        Set<String> properties = new HashSet<>();
        for (PropertyDescriptor propertyDescriptor : pds) {
            String propertyName = propertyDescriptor.getName();
            Object propertyValue = srcBean.getPropertyValue(propertyName);
            if (StringUtils.isEmpty(propertyValue)) {
                srcBean.setPropertyValue(propertyName, null);
                properties.add(propertyName);
            }
        }
        return properties.toArray(new String[0]);
    }
}
