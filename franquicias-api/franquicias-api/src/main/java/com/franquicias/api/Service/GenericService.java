package com.franquicias.api.Service;

import java.util.List;

public interface GenericService<T, ID> {

    T create(T enity);
    T update(ID id, T entity);
    void delete(ID id);
    T getById(ID id);
    List<T> getAll();
}
