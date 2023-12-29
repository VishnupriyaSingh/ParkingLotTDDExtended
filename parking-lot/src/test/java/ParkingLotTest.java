import org.junit.jupiter.api.Test;
import com.example.Car;
import com.example.ParkingLot;
import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

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

    // Helper method to fill the parking lot
    private void fillParkingLot(ParkingLot parkingLot, int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            parkingLot.parkCar(new Car("CAR" + i));
        }
    }
}
