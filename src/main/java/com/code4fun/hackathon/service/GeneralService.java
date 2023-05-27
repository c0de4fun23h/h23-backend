package com.code4fun.hackathon.service;

import java.util.List;

public interface GeneralService<T, ID> {
    List<T> findAll();

    T findById(ID id);

    T create(T entity);

    T update(ID id, T entity);

    void delete(ID id);

}
