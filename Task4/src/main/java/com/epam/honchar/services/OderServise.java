package com.epam.honchar.services;

import com.epam.honchar.entity.Car;

import java.text.ParseException;
import java.util.List;

public interface OderServise {
    boolean addToOder(String date) throws ParseException;

    List<Car> orderNearestDate(String date) throws ParseException;

    String orderInSpecifiedRange(String date1, String date2) throws ParseException;

    String oderToString();
}
