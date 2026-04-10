package com.hotel.infrastructure.persistence;

import com.hotel.domain.model.Room;
import com.hotel.domain.model.Reservation;
import com.hotel.domain.enums.RoomType;
import com.hotel.domain.repository.HotelRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryHotelRepository implements HotelRepository {
    private final Map<String, Room> rooms = new HashMap<>();
    private final Map<String, Reservation> reservations = new HashMap<>();

    public InMemoryHotelRepository() {
        // Initialize 15 rooms
        for (int i = 101; i <= 105; i++) {
            rooms.put(String.valueOf(i), new Room(String.valueOf(i), "Room " + i, RoomType.SINGLE, true));
        }
        for (int i = 201; i <= 205; i++) {
            rooms.put(String.valueOf(i), new Room(String.valueOf(i), "Room " + i, RoomType.DOUBLE, true));
        }
        for (int i = 301; i <= 305; i++) {
            rooms.put(String.valueOf(i), new Room(String.valueOf(i), "Room " + i, RoomType.SUITE, true));
        }
    }

    @Override
    public List<Room> findAllRooms() {
        return new ArrayList<>(rooms.values());
    }

    @Override
    public Optional<Room> findRoomById(String id) {
        return Optional.ofNullable(rooms.get(id));
    }

    @Override
    public void saveRoom(Room room) {
        rooms.put(room.getId(), room);
    }

    @Override
    public List<Reservation> findAllReservations() {
        return new ArrayList<>(reservations.values());
    }

    @Override
    public Optional<Reservation> findReservationById(String id) {
        return Optional.ofNullable(reservations.get(id));
    }

    @Override
    public void saveReservation(Reservation reservation) {
        reservations.put(reservation.getId(), reservation);
    }
}
