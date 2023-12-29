package com.example;
import java.time.LocalDateTime;

public class Ticket {
    private String ticketId;
    private String parkingSpot;
    private LocalDateTime parkedAt;

    public Ticket(String ticketId, String parkingSpot, LocalDateTime parkedAt) {
        this.ticketId = ticketId;
        this.parkingSpot = parkingSpot;
        this.parkedAt = parkedAt != null ? parkedAt : LocalDateTime.now();
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
}
