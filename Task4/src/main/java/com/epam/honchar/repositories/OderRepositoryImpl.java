package com.epam.honchar.repositories;

import com.epam.honchar.entity.Car;
import com.epam.honchar.lists.OderList;

import java.text.ParseException;
import java.util.List;

public class OderRepositoryImpl implements OderRepository {
    private OderList oderList;

    public OderRepositoryImpl(OderList oderList) {
        this.oderList = oderList;
    }

    @Override
    public boolean addToOder(String date) throws ParseException {
        return oderList.addToOder(date);
    }

    @Override
    public List<Car> orderNearestDate(String date) throws ParseException {
        return oderList.orderNearestDate(date);
    }

    @Override
    public String orderInSpecifiedRange(String date1, String date2) throws ParseException {
        return oderList.orderInSpecifiedRange(date1, date2);
    }

    @Override
    public String oderToString() {
        return oderList.toString();
    }


}
