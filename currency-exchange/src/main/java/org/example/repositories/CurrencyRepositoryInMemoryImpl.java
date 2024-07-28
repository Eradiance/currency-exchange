package org.example.repositories;

import org.example.models.Currency;

import java.util.ArrayList;
import java.util.List;

public class CurrencyRepositoryInMemoryImpl implements CurrencyRepository {
    private List<Currency> currencies;

    public CurrencyRepositoryInMemoryImpl() {
        currencies = new ArrayList<Currency>();

        Currency currency = new Currency(1, "USD", "Dollar", "$");
        Currency currency1 = new Currency(2, "RUB", "Ruble", "R");
        Currency currency2 = new Currency(3, "EUR", "Euro", "E");

        currencies.add(currency);
        currencies.add(currency1);
        currencies.add(currency2);
    }

    @Override
    public List<Currency> findAll() {
        return currencies;
    }

    @Override
    public void save(Currency currency) {
        currencies.add(currency);
    }
}
