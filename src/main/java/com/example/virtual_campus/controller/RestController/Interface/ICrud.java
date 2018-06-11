package com.example.virtual_campus.controller.RestController.Interface;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICrud <T> {

    List <T> getAll();
    T create(T t);
    T getById(Long id);
    T update(Long id, T t);
    ResponseEntity<?> delete(Long id);

}
