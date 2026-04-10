package com.hotel.domain.repository;

import com.hotel.domain.model.Room;
import com.hotel.domain.model.Reservation;
import java.util.List;
import java.util.Optional;

public interface HotelRepository {
    List<Room> findAllRooms();
    Optional<Room> findRoomById(String id);
    void saveRoom(Room room);
    
    List<Reservation> findAllReservations();
    Optional<Reservation> findReservationById(String id);
    void saveReservation(Reservation reservation);
}
