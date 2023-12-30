package com.example;
import java.util.List;
import java.util.Comparator;

public class ParkingAttendant {
    private List<ParkingLot> parkingLots;

    public ParkingAttendant(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket parkCar(Car car) {
        ParkingLot selectedLot = findLotWithLeastCars();
        if (selectedLot != null) {
            return selectedLot.parkCar(car);
        }
        return null; // Or handle this case as per the requirement
    }

    private ParkingLot findLotWithLeastCars() {
        return parkingLots.stream()
                          .min(Comparator.comparing(ParkingLot::getNumberOfParkedCars))
                          .orElse(null);
    }
}


