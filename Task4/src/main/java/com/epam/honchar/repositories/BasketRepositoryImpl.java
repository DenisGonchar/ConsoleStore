package com.epam.honchar.repositories;

import com.epam.honchar.entity.Car;
import com.epam.honchar.lists.BasketList;


public class BasketRepositoryImpl implements BasketRepository {
    private BasketList basketList;

    public BasketRepositoryImpl(BasketList basketList) {
        this.basketList = basketList;
    }

    @Override
    public boolean addToBasket(Car product) {
        if (product != null) {
            return basketList.add(product);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public boolean removeFromBasket(Car product) {
        if (basketList.contains(product)) {
            return basketList.remove(product);
        }
        return false;
    }

    @Override
    public Car getByName(String name) {
        return basketList.getByName(name);
    }

    @Override
    public String basketToString() {
        return basketList.basketToString();
    }
}
