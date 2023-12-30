package com.example;
import java.time.LocalDateTime;

public class Ticket {
    private String ticketId;
    private String parkingSpot;
    private LocalDateTime parkedAt;
    private String attendantName;

    public Ticket(String ticketId, String parkingSpot, LocalDateTime parkedAt, String attendantName) {
        this.ticketId = ticketId;
        this.parkingSpot = parkingSpot;
        this.parkedAt = parkedAt;
        this.attendantName = attendantName;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getParkingSpot() {
        return parkingSpot;
    }

    public LocalDateTime getParkedAt() {
        return parkedAt;
    }

    public String getAttendantName() {
        return attendantName;
    }
}
