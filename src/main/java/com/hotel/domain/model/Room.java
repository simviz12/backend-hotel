package com.hotel.domain.model;

import com.hotel.domain.enums.RoomType;

public class Room {
    private String id;
    private String number;
    private RoomType type;
    private boolean available;

    public Room() {}

    public Room(String id, String number, RoomType type, boolean available) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.available = available;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }
    public RoomType getType() { return type; }
    public void setType(RoomType type) { this.type = type; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}
