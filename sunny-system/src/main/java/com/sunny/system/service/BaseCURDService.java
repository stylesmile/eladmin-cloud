package com.sunny.system.service;

import com.sunny.system.common.tool.QueryHelp;
import com.sunny.system.repository.BaseJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.validation.ValidationException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Service层基类
 *
 * @author chenye
 * @data 2020-0315
 */

public class BaseCURDService<M, E, ID extends Serializable> {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    protected BaseJpaRepository<E, ID> repository;

    @Transactional
    public Boolean save(E entity) {
        logger.debug("create object: {}", entity.toString());
        this.beforeCreate(entity);
        entity = this.repository.save(entity);
        this.afterCreate(entity);
        return true;
    }

    @Transactional
    public Boolean delete(ID id) {
        this.beforeDelete(id);
        E e = this.getById(id);
        if (e != null) {
            this.beforeDelete(id);
            this.repository.deleteById(id);
            this.afterDelete(e);
            return true;
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

    public E getById(ID id) {
        E e = this.repository.getOne(id);
        return e;
    }


    public long count(M e) {
        return this.repository.count(toFilter(e));
    }


    public boolean exists(ID id) {
        return this.repository.existsById(id);
    }


    public List<M> list(E e, Sort sort) {
        //List<E> entitys = this.repository.findAll(e, sort);
        return null;
    }


    public <T> Page search(T m, Pageable pageable) {
        Page<E> entitys = this.repository.findAll(this.toFilter(m), pageable);
        return entitys;
    }

    protected List<M> toModels(Iterable<E> entities) {
        List<M> views = new ArrayList<M>();
        if (entities != null) {
            for (E e : entities) {
                M v = this.toView(e);
                views.add(v);
            }
        }
        this.afterList(views);
        return views;
    }

    protected M toView(E entity) {
        return null;
    }

    ;;

    protected ID getID(M model) {
        return null;
    }

    ;

    protected <T> Specification<E> toFilter(T filter) {
        return (root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, filter, criteriaBuilder);
    }

    ;

    protected void beforeCreate(E entity) {
    }

    protected void afterCreate(E entity) {
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

    protected void afterDelete(E e) {
    }

    protected void afterList(List<M> views) {
    }

    protected void copyTo(Object source, Object target, String... ignoreProperties) {
        BeanUtils.copyProperties(source, target, ignoreProperties);
    }

    protected E getOne(ID entityId) {
        return this.repository.getOne(entityId);
    }

}
