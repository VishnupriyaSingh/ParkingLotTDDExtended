package com.example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ParkingLot {
    private int capacity;
    private Map<Car, Ticket> parkedCars;
    private boolean isFullSignDisplayed = false;
    private List<SecurityObserver> securityObservers = new ArrayList<>();

    public void registerSecurityObserver(SecurityObserver observer) {
        securityObservers.add(observer);
    }

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

    public boolean isFullSignDisplayed() {
        return isFullSignDisplayed;
    }

    public void updateFullSign() {
        if (isFull() && !isFullSignDisplayed) {
            displayFullSign();
            isFullSignDisplayed = true;
        } else if (!isFull() && isFullSignDisplayed) {
            removeFullSign();
            isFullSignDisplayed = false;
        }
        notifySecurityObservers();
    }

    private void notifySecurityObservers() {
        for (SecurityObserver observer : securityObservers) {
            observer.notify(isFull());
        }
    }

    private void displayFullSign() {
        // Simulate displaying the "Full" sign
        System.out.println("Parking Lot is Full. Full sign displayed.");
    }

    private void removeFullSign() {
        // Simulate removing the "Full" sign
        System.out.println("Parking Lot is not full anymore. Full sign removed.");
    }

}

interface SecurityObserver {
    void notify(boolean isFull);
}