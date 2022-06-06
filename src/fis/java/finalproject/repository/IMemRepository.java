package fis.java.finalproject.repository;

import fis.java.finalproject.model.Detective;

import java.util.List;

public interface IMemRepository<T>{
    T insertOrUpdate(T t);
    T findById(Long id);
    List<T> findAll();
    void deleteById(Long id);
}
