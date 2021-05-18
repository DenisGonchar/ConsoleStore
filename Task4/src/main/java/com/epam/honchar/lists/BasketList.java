package com.epam.honchar.lists;

import com.epam.honchar.entity.Car;

import java.util.Collection;
import java.util.Map;

public class BasketList {

    private Map<String, Car> products;

    public BasketList(Map<String, Car> products) {
        this.products = products;
    }

    public boolean add(Car product) {
        if (products.containsKey(product.getName())) {
            Car old = products.get(product.getName());
            old.setAmount(old.getAmount() + 1);
            products.replace(product.getName(), old);
        } else {
            products.put(product.getName(), product);
            Car old = products.get(product.getName());
            old.setAmount(1);
            products.replace(product.getName(), old);
        }
        return true;
    }

    public void clear() {
        products.clear();
    }

    public Collection<Car> values() {
        return products.values();
    }

    public boolean remove(Car product) {
        if (product.isEmpty()) {
            return false;
        }
        if (products.containsKey(product.getName())) {
            Car old = products.get(product.getName());
            int diff = old.getAmount() - product.getAmount();
            old.setAmount(Math.max(diff, 0));
            if (old.getAmount() != 0) {
                products.replace(product.getName(), old);
            } else {
                products.remove(product.getName());
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean contains(Car product) {
        return products.containsValue(product);
    }

    public Car getByName(String name) {
        if (!name.isEmpty()) {
            for (Map.Entry<String, Car> entry : products.entrySet()) {
                if (entry.getValue().toString().contains(name)) {
                    return entry.getValue();
                }
            }
        }
        throw new UnsupportedOperationException("Name is Empty");
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public String basketToString() {
        StringBuilder sb = new StringBuilder("\n");
        if (!products.isEmpty()) {
            int i = 1;
            for (Map.Entry<String, Car> entry : products.entrySet()) {
                Car value = entry.getValue();
                sb.append(i).append(". ")
                        .append("Name: ")
                        .append(value.getName())
                        .append(", Amount: ")
                        .append(value.getAmount())
                        .append(" About product: ")
                        .append(" Price- ").append(value.getPrice()).append("$")
                        .append(" GuaranteePeriod- ").append(value.getGuaranteePeriod()).append("months.")
                        .append("\n");
                i++;
            }
        } else {
            sb = new StringBuilder("basket is empty!");
        }
        return sb.toString();
    }
}
