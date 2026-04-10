package com.hotel.domain.enums;

public enum Season {
    HIGH(1.5),
    LOW(1.0);

    private final double factor;

    Season(double factor) {
        this.factor = factor;
    }

    public double getFactor() {
        return factor;
    }
}
