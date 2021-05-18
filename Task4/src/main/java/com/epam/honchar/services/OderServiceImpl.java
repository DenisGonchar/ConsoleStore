package com.epam.honchar.services;

import com.epam.honchar.entity.Car;
import com.epam.honchar.repositories.OderRepository;

import java.text.ParseException;
import java.util.List;

public class OderServiceImpl implements OderServise {

    private OderRepository oderRepository;

    public OderServiceImpl(OderRepository oderRepository) {
        this.oderRepository = oderRepository;
    }

    @Override
    public boolean addToOder(String date) throws ParseException {
        return oderRepository.addToOder(date);
    }

    @Override
    public List<Car> orderNearestDate(String date) throws ParseException {
        return oderRepository.orderNearestDate(date);
    }

    @Override
    public String orderInSpecifiedRange(String date1, String date2) throws ParseException {
        return oderRepository.orderInSpecifiedRange(date1, date2);
    }

    @Override
    public String oderToString() {
        return oderRepository.oderToString();
    }
}
