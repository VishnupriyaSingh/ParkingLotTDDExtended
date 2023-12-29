import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import com.example.Car;
import com.example.ParkingAttendant;
import com.example.ParkingLot;
import com.example.Ticket;

class ParkingAttendantTest {
    @Test
    void testParkingAttendantParksCar() {
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingAttendant attendant = new ParkingAttendant(parkingLot);
        Car car = new Car("YZA456");

        Ticket ticket = attendant.parkCar(car);
        assertNotNull(ticket, "Parking attendant should successfully park the car and return a ticket.");
    }
}
