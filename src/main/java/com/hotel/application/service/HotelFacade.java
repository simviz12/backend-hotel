package com.hotel.application.service;

import com.hotel.application.dto.ReservationDTO;
import com.hotel.application.dto.InvoiceDTO;
import com.hotel.domain.enums.AdditionalServiceType;
import com.hotel.domain.model.Room;

import java.time.LocalDate;
import java.util.List;

public interface HotelFacade {
    ReservationDTO createReservation(ReservationDTO reservationDTO);
    void addService(String reservationId, AdditionalServiceType serviceType);
    void performCheckIn(String reservationId);
    InvoiceDTO performCheckOut(String reservationId);
    List<Room> getAvailableRooms(LocalDate start, LocalDate end, String type);
    ReservationDTO getReservation(String reservationId);
}
