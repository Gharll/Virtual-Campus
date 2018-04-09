package com.example.virtual_campus.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface ICrud <T> {

    List <T> getAll();
    T create(T t);
    T getById(Long id);
    T update(Long id, T t);
    ResponseEntity<?> delete(Long id);

}
