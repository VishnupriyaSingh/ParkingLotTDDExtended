package com.example;
public class Car {
    private String licensePlate;
    private String color;
    private String make;
    private String model;

    public Car(String licensePlate, String color, String make, String model) {
        this.licensePlate = licensePlate;
        this.color = color;
        this.make = make;
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getColor() {
        return color;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }
}
