package com.codegym.service.impl;

import com.codegym.model.Country;

public interface CountryService {
    Country findById(Long id);
    Iterable<Country> findAll();
}
