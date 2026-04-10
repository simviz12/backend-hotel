package com.hotel.application.dto;

import com.hotel.domain.enums.AdditionalServiceType;
import java.time.LocalDate;
import java.util.List;

public class ReservationDTO {
    private String id;
    private String guestName;
    private String guestEmail;
    private String roomId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private List<AdditionalServiceType> services;
    private boolean isCheckedIn;
    private boolean isCheckedOut;
    private String digitalKey;
    private double totalPrice;

    public ReservationDTO() {}

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getGuestName() { return guestName; }
    public void setGuestName(String guestName) { this.guestName = guestName; }
    public String getGuestEmail() { return guestEmail; }
    public void setGuestEmail(String guestEmail) { this.guestEmail = guestEmail; }
    public String getRoomId() { return roomId; }
    public void setRoomId(String roomId) { this.roomId = roomId; }
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
    public double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
}
