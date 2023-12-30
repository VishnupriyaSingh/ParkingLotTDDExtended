package com.example;
import java.util.List;
import java.util.Comparator;

public class ParkingAttendant {
    private List<ParkingLot> parkingLots;

    public ParkingAttendant(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket parkCar(Car car, boolean isHandicap, boolean isLarge) {
        ParkingLot selectedLot;

        if (isHandicap) {
            selectedLot = findLotWithNearestFreeSpace();
        } else if (isLarge) {
            selectedLot = findLotWithMostFreeSpaces();
        } else {
            selectedLot = findLotWithLeastCars();
        }

        if (selectedLot != null) {
            return selectedLot.parkCar(car);
        }
        return null;
    }

    private ParkingLot findLotWithLeastCars() {
        return parkingLots.stream()
                          .min(Comparator.comparing(ParkingLot::getNumberOfParkedCars))
                          .orElse(null);
    }

    private ParkingLot findLotWithNearestFreeSpace() {
        return parkingLots.stream()
                          .filter(ParkingLot::hasNearestFreeSpace)
                          .findFirst()
                          .orElse(null);
    }

    private ParkingLot findLotWithMostFreeSpaces() {
        return parkingLots.stream()
                          .max(Comparator.comparing(ParkingLot::getNumberOfFreeSpaces))
                          .orElse(null);
    }
}


