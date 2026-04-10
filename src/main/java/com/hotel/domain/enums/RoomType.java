package com.hotel.domain.enums;

public enum RoomType {
    SINGLE(100.0),
    DOUBLE(180.0),
    SUITE(350.0);

    private final double basePrice;

    RoomType(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getBasePrice() {
        return basePrice;
    }
}
