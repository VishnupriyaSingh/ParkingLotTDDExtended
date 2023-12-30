package com.example;
import java.time.LocalDateTime;

public class Ticket {
    private String ticketId;
    private String parkingSpot;
    private LocalDateTime parkedAt;
    private String attendantName;

    // Constructor
    public Ticket(String ticketId, String parkingSpot, LocalDateTime parkedAt, String attendantName) {
        this.ticketId = ticketId;
        this.parkingSpot = parkingSpot;
        this.parkedAt = parkedAt;
        this.attendantName = attendantName;
    }

    // Getters
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

    // Setters (if modification of fields is required after object creation)
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public void setParkingSpot(String parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public void setParkedAt(LocalDateTime parkedAt) {
        this.parkedAt = parkedAt;
    }

    public void setAttendantName(String attendantName) {
        this.attendantName = attendantName;
    }
}
