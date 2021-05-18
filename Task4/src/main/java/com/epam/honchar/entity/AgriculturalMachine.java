package com.epam.honchar.entity;

/**
 * Class AgriculturalMachine with fields <b>enginePower</b> and <b>wheelRadius</b>.
 *
 * @version 1.8
 * @autor Denys Honchar
 */
public class AgriculturalMachine extends Car {
    private double enginePower;
    private double weight;

    public AgriculturalMachine() {
    }

    public AgriculturalMachine(double price, int guaranteePeriod, int amount, String name, int personPlaces, double maxSpeed, double clearance, double enginePower, double weight) {
        super(price, guaranteePeriod, amount, name, personPlaces, maxSpeed, clearance);
        this.enginePower = enginePower;
        this.weight = weight;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        AgriculturalMachine that = (AgriculturalMachine) object;
        return Double.compare(that.enginePower, enginePower) == 0 && Double.compare(that.weight, weight) == 0;
    }

    @Override
    public String toString() {
        return "AgriculturalMachine:" +
                ", enginePower=" + enginePower +
                ", weight=" + weight +
                ". " + super.toString();
    }
}
