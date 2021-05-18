package com.epam.honchar.entity;

import java.util.ArrayList;
import java.util.List;

public class ListProducts {
    private List<Car> cars = new ArrayList<>();

    public void init() {
        Car audiq8 = new RacingCar(30000, 24, 2, "Audi Q8", 5, 280.5, 0.2, 3.5, 3.8);
        Car bmwx6 = new RacingCar(28000, 24, 3, "BMW X6", 5, 260, 0.25, 3.0, 5.5);
        Car bulatT25 = new AgriculturalMachine(2500, 24, 4, "Bulat T-25", 2, 40, 1.2, 20.0, 800);
        Car guardian = new AgriculturalMachine(215000, 48, 1, "GUARDIAN SP310F", 2, 56, 1.93, 382.5, 800);
        cars.add(audiq8);
        cars.add(bmwx6);
        cars.add(bulatT25);
        cars.add(guardian);
    }

    public String getAllCars() {
        cars.clear();
        init();
        return cars.toString();
    }

    public Car getCarByName(String name) {
        cars.clear();
        init();
        if (!name.isEmpty() && cars.toString().contains(name)) {
            for (Car car : cars) {
                if (car.getName().equals(name)) {
                    return car;
                }
            }
        }
        throw new UnsupportedOperationException();
    }
}
