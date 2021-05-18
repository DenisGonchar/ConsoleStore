package com.epam.honchar.services;

import com.epam.honchar.entity.Car;


public interface BasketService {
    boolean addToBasket(Car product);

    boolean removeFromBasket(Car product);

    String basketToString();

    Car getByName(String name);
}
