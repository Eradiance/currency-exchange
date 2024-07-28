package org.example.repositories;

import org.example.models.Currency;

import java.util.List;

public interface CurrencyRepository {
    List<Currency> findAll();
    void save(Currency currency);
}
