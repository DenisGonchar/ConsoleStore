package com.epam.honchar.services;

import com.epam.honchar.entity.Car;
import com.epam.honchar.repositories.BasketRepository;

public class BasketServiceImpl implements BasketService {
    private BasketRepository basketRepository;

    public BasketServiceImpl(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    @Override
    public boolean addToBasket(Car product) {
        return basketRepository.addToBasket(product);
    }

    @Override
    public boolean removeFromBasket(Car product) {
        return basketRepository.removeFromBasket(product);
    }

    @Override
    public Car getByName(String name) {
        return basketRepository.getByName(name);
    }

    @Override
    public String basketToString() {
        return basketRepository.basketToString();
    }

}
