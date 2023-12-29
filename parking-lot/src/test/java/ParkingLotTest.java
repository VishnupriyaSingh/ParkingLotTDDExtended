import org.junit.jupiter.api.Test;
import com.example.Car;
import com.example.ParkingLot;
import com.example.Ticket;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    // Helper method to fill the parking lot
    private void fillParkingLot(ParkingLot parkingLot, int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            parkingLot.parkCar(new Car("CAR" + i));
        }
    }

    @Test
    void testParkingAvailability() {
        ParkingLot parkingLot = new ParkingLot(100);
        Car car = new Car("ABC123");
        assertNotNull(parkingLot.parkCar(car), "Parking should be successful, but ticket was null.");
    }

    @Test
    void testParkingLotFull() {
        ParkingLot parkingLot = new ParkingLot(100);
        fillParkingLot(parkingLot, 100);
        Car newCar = new Car("XYZ789");
        assertNull(parkingLot.parkCar(newCar), "Parking should fail, but a ticket was issued.");
    }

    @Test
    void testSuccessfulParking() {
        ParkingLot parkingLot = new ParkingLot(100);
        Car car = new Car("DEF456");
        assertNotNull(parkingLot.parkCar(car), "Expected a valid ticket, but got null.");
    }

    @Test
    void testInvalidCar() {
        ParkingLot parkingLot = new ParkingLot(100);
        assertThrows(IllegalArgumentException.class, () -> parkingLot.parkCar(null));
    }

    @Test
    void testUnparkCar() {
        ParkingLot parkingLot = new ParkingLot(100);
        Car car = new Car("GHI789");
        Ticket ticket = parkingLot.parkCar(car);
        assertNotNull(ticket, "Car should have been parked successfully.");

        Car unparkedCar = parkingLot.unparkCar(ticket);
        assertEquals(car, unparkedCar, "Unparked car should match the parked car.");
    }

    @Test
    void testUnparkCarWithInvalidTicket() {
        ParkingLot parkingLot = new ParkingLot(100);
        Ticket invalidTicket = new Ticket("Invalid123");
        assertNull(parkingLot.unparkCar(invalidTicket), "Unparking should fail for an invalid ticket.");
    }

    @Test
    void testUnparkCarWithNullTicket() {
        ParkingLot parkingLot = new ParkingLot(100);
        assertNull(parkingLot.unparkCar(null), "Unparking should fail for a null ticket.");
    }

    @Test
    void testFullSignDisplayedWhenFull() {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.parkCar(new Car("JKL012"));
        parkingLot.updateFullSign();
        assertTrue(parkingLot.isFullSignDisplayed(), "Full sign should be displayed when lot is full.");
    }

    @Test
    void testFullSignRemovedWhenSpaceAvailable() {
        ParkingLot parkingLot = new ParkingLot(1);
        Ticket ticket = parkingLot.parkCar(new Car("MNO345"));
        parkingLot.updateFullSign();
        parkingLot.unparkCar(ticket);
        parkingLot.updateFullSign();
        assertFalse(parkingLot.isFullSignDisplayed(), "Full sign should be removed when space is available.");
    }



}
