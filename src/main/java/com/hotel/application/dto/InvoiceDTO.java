package com.hotel.application.dto;

import java.util.List;

public class InvoiceDTO {
    private String reservationId;
    private String guestName;
    private double basePrice;
    private double seasonalFactor;
    private List<ServiceDetail> additionalServices;
    private double totalPrice;

    public InvoiceDTO() {}

    public InvoiceDTO(String reservationId, String guestName, double basePrice, double seasonalFactor, List<ServiceDetail> additionalServices, double totalPrice) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.basePrice = basePrice;
        this.seasonalFactor = seasonalFactor;
        this.additionalServices = additionalServices;
        this.totalPrice = totalPrice;
    }

    // Getters and Setters
    public String getReservationId() { return reservationId; }
    public void setReservationId(String reservationId) { this.reservationId = reservationId; }

    public String getGuestName() { return guestName; }
    public void setGuestName(String guestName) { this.guestName = guestName; }

    public double getBasePrice() { return basePrice; }
    public void setBasePrice(double basePrice) { this.basePrice = basePrice; }

    public double getSeasonalFactor() { return seasonalFactor; }
    public void setSeasonalFactor(double seasonalFactor) { this.seasonalFactor = seasonalFactor; }

    public List<ServiceDetail> getAdditionalServices() { return additionalServices; }
    public void setAdditionalServices(List<ServiceDetail> additionalServices) { this.additionalServices = additionalServices; }

    public double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

    public static class ServiceDetail {
        private String name;
        private double price;

        public ServiceDetail() {}
        public ServiceDetail(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public double getPrice() { return price; }
        public void setPrice(double price) { this.price = price; }
    }
}
