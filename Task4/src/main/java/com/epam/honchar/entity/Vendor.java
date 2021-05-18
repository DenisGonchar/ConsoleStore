package com.epam.honchar.entity;

/**
 * Class Vendor with fields <b>price</b> and <b>guaranteePeriod</b>.
 *
 * @version 1.8
 * @autor Denys Honchar
 */
public class Vendor {
    private double price;
    private int guaranteePeriod;
    private int amount;

    public Vendor() {
    }

    public Vendor(double price, int guaranteePeriod, int amount) {
        this.price = price;
        this.guaranteePeriod = guaranteePeriod;
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getGuaranteePeriod() {
        return guaranteePeriod;
    }

    public void setGuaranteePeriod(int guaranteePeriod) {
        this.guaranteePeriod = guaranteePeriod;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Vendor vendor = (Vendor) object;
        return Double.compare(vendor.price, price) == 0 && guaranteePeriod == vendor.guaranteePeriod;
    }

    @Override
    public String toString() {
        return "Vendor: " +
                "price=" + price +
                ", guaranteePeriod=" + guaranteePeriod +
                ", amount=" + amount +
                ". ";
    }
}
