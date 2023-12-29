package com.example;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ParkingLot {
    private int capacity;
    private Map<Car, Ticket> parkedCars;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkedCars = new HashMap<>();
    }

    public Ticket parkCar(Car car) {
        if (car == null) {
            throw new IllegalArgumentException("Car cannot be null");
        }

        if (isFull()) {
            //parking lot is full or not
            return null;
        }

        Ticket ticket = new Ticket(UUID.randomUUID().toString()); //random ticket generation 
        parkedCars.put(car, ticket);
        return ticket;
    }

    public Car unparkCar(Ticket ticket) {
        if (ticket == null || !parkedCars.containsValue(ticket)) {
            return null;
        }

        Car carToUnpark = parkedCars.entrySet().stream()
            .filter(entry -> ticket.equals(entry.getValue()))
            .map(Map.Entry::getKey)
            .findFirst()
            .orElse(null);

        if (carToUnpark != null) {
            parkedCars.remove(carToUnpark);
        }

        return carToUnpark;
    }

    public boolean isFull() {
        return parkedCars.size() >= capacity;
    }
}
