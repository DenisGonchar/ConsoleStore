package com.epam.honchar.repositories;

import com.epam.honchar.entity.Car;

public interface BasketRepository {

    boolean addToBasket(Car product);

    boolean removeFromBasket(Car product);

    Car getByName(String name);

    String basketToString();
}
