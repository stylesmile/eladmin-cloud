package com.sunny.service.testcommonservice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.List;

/**
 * @author carfield
 */
public interface SimpleCRUDService<M, F, ID extends Serializable> {

    public M create(M target);

    public Long delete(ID id);

    public M modify(M target);

    public M detail(ID id);

    public long count(F filter);

    public boolean exists(ID id);

    public List<M> list(F filter, Sort sort);

    public Page<M> search(F filter, Pageable pageable);
}
