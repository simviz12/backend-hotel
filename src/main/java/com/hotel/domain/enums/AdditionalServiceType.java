package com.hotel.domain.enums;

public enum AdditionalServiceType {
    SPA(50.0),
    BREAKFAST(15.0),
    TRANSFER(30.0);

    private final double price;

    AdditionalServiceType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
