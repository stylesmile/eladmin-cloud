package com.sunny.system.service;

import com.sunny.system.repository.BaseJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired(required = false)
    protected BaseJpaRepository<E, ID> repository;

    @Transactional
    public Boolean save(M model) {
        logger.debug("create object: {}", model.toString());
        E entity = this.toEntity(model);
        this.beforeCreate(model, entity);
        entity = this.repository.save(entity);
        this.afterCreate(model, entity);
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
//        if (e != null) {
//            M v = this.toView(e);
//            return v;
//        }
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


    public Page<M> search(M m, Pageable pageable) {
        Page<E> entitys = this.repository.findAll(this.toFilter(m), pageable);
        List<M> content = this.toModels(entitys);
        Page<M> views = new PageImpl<M>(content, pageable, entitys.getTotalElements());
        return views;
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

    protected E toEntity(M model) {
        E e = null;
        BeanUtils.copyProperties(model, e);
        return e;
    }

    ;

    protected M toView(E entity) {
        return null;
    }

    ;;

    protected ID getID(M model) {
        return null;
    }

    ;

    protected Specification<E> toFilter(M filter) {
        return null;
    }

    ;

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
