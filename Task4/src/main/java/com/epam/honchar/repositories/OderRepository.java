package com.epam.honchar.repositories;

import com.epam.honchar.entity.Car;

import java.text.ParseException;
import java.util.List;

public interface OderRepository {
    boolean addToOder(String date) throws ParseException;

    List<Car> orderNearestDate(String date) throws ParseException;

    String orderInSpecifiedRange(String date1, String date2) throws ParseException;

    String oderToString();
}
