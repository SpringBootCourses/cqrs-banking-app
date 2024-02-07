package com.example.cqrsbankingapp.service;

import java.util.UUID;

public interface QueryService<T> {

    T getById(UUID id);

}
