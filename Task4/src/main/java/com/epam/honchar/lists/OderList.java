package com.epam.honchar.lists;

import com.epam.honchar.entity.Car;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class OderList {

    private Map<Date, List<Car>> oder;
    private BasketList basket;

    public OderList(Map<Date, List<Car>> oder, BasketList basket) {
        this.oder = oder;
        this.basket = basket;
    }

    public boolean addToOder(String date) throws ParseException {
        if (basket.isEmpty()) {
            return false;
        }
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date nDate = dateFormat.parse(date);
        ArrayList<Car> list = new ArrayList<>(basket.values());
        oder.put(nDate, list);
        basket.clear();
        return true;
    }

    public String getAllPrice() {
        double price = 0;
        for (Map.Entry<Date, List<Car>> entry : oder.entrySet()) {
            List<Car> value = entry.getValue();
            for (Car car : value) {
                price += (car.getPrice() * car.getAmount());
            }
        }
        return "Total order price: " + price + "$";
    }

    public List<Car> orderNearestDate(String date) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date nDate = dateFormat.parse(date);
        List<Date> dates = new ArrayList<>(oder.keySet());
        return oder.get(getNearestDate(dates, nDate));
    }

    public Date getNearestDate(List<Date> dates, Date currentDate) {
        long minDiff = -1, currentTime = currentDate.getTime();
        Date minDate = null;
        for (Date date : dates) {
            long diff = Math.abs(currentTime - date.getTime());
            if ((minDiff == -1) || (diff < minDiff)) {
                minDiff = diff;
                minDate = date;
            }
        }
        return minDate;
    }

    public String orderInSpecifiedRange(String date1, String date2) throws ParseException {
        String oderIn = "";
        List<Date> listDate = new ArrayList<>(oder.keySet());
        List<Date> dates = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date startDate = dateFormat.parse(date1);
        Date endDate = dateFormat.parse(date2);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        Date dt = startDate;
        do {
            dates.add(dt);
            calendar.add(Calendar.DATE, 1);
            dt = calendar.getTime();
        } while (endDate.getTime() > dt.getTime());

        dates.retainAll(listDate);
        for (Map.Entry<Date, List<Car>> entry : oder.entrySet()) {
            Date dat = entry.getKey();
            if (dates.contains(dat)) {
                oderIn = oder.get(dat).toString();
                return oderIn;
            }
        }
        return oderIn;
    }

    public String oderToString() {
        return oder.toString() + "\n" + getAllPrice();
    }

}
