package com.hotel.domain.model;

import com.hotel.domain.enums.AdditionalServiceType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private String id;
    private String guestName;
    private String guestEmail;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private List<AdditionalServiceType> services = new ArrayList<>();
    private boolean isCheckedIn;
    private boolean isCheckedOut;
    private String digitalKey;

    public Reservation() {}

    public void addService(AdditionalServiceType service) {
        this.services.add(service);
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getGuestName() { return guestName; }
    public void setGuestName(String guestName) { this.guestName = guestName; }
    public String getGuestEmail() { return guestEmail; }
    public void setGuestEmail(String guestEmail) { this.guestEmail = guestEmail; }
    public Room getRoom() { return room; }
    public void setRoom(Room room) { this.room = room; }
    public LocalDate getCheckInDate() { return checkInDate; }
    public void setCheckInDate(LocalDate checkInDate) { this.checkInDate = checkInDate; }
    public LocalDate getCheckOutDate() { return checkOutDate; }
    public void setCheckOutDate(LocalDate checkOutDate) { this.checkOutDate = checkOutDate; }
    public List<AdditionalServiceType> getServices() { return services; }
    public void setServices(List<AdditionalServiceType> services) { this.services = services; }
    public boolean isCheckedIn() { return isCheckedIn; }
    public void setCheckedIn(boolean checkedIn) { isCheckedIn = checkedIn; }
    public boolean isCheckedOut() { return isCheckedOut; }
    public void setCheckedOut(boolean checkedOut) { isCheckedOut = checkedOut; }
    public String getDigitalKey() { return digitalKey; }
    public void setDigitalKey(String digitalKey) { this.digitalKey = digitalKey; }
}
