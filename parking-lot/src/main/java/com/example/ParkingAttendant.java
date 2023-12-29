package com.example;

public class ParkingAttendant {
    private ParkingLot parkingLot;

    public ParkingAttendant(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket parkCar(Car car) {
        // Park the car
        return parkingLot.parkCar(car);
    }
}

