package com.example.demo_ajax_2class.conmon;

import java.util.List;
import java.util.Optional;

public interface ICRUDService<E> {
    List<E> findAll();
    E save(E e);
    void delete(Long id);
    Optional<E> findById(Long id);

}
