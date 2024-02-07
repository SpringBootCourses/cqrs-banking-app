package com.example.cqrsbankingapp.service;

public interface CommandService<T> {

    void create(T object);

}
