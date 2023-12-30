import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import com.example.Car;
import com.example.ParkingAttendant;
import com.example.ParkingLot;
import com.example.Ticket;

class ParkingAttendantTest {
    @Test
void testParkingAttendantParksCar() {
    List<ParkingLot> parkingLots = Collections.singletonList(new ParkingLot(10));
    ParkingAttendant attendant = new ParkingAttendant(parkingLots);
    Car car = new Car("YZA456");

    Ticket ticket = attendant.parkCar(car);
    assertNotNull(ticket, "Parking attendant should successfully park the car and return a ticket.");
}


     @Test
    void testEvenDistributionOfCars() {
        List<ParkingLot> parkingLots = Arrays.asList(new ParkingLot(10), new ParkingLot(10));
        ParkingAttendant attendant = new ParkingAttendant(parkingLots);

        attendant.parkCar(new Car("CAR1"));
        attendant.parkCar(new Car("CAR2"));

        assertEquals(1, parkingLots.get(0).getNumberOfParkedCars(), "First lot should have 1 car.");
        assertEquals(1, parkingLots.get(1).getNumberOfParkedCars(), "Second lot should have 1 car.");
    }
}
