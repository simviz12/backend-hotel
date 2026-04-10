package com.hotel.application.service.impl;

import com.hotel.application.dto.InvoiceDTO;
import com.hotel.application.dto.ReservationDTO;
import com.hotel.application.service.*;
import com.hotel.domain.enums.AdditionalServiceType;
import com.hotel.domain.model.Reservation;
import com.hotel.domain.model.Room;
import com.hotel.domain.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class HotelFacadeImpl implements HotelFacade {

    private final HotelRepository repository;
    private final PriceService priceService;
    private final AccessService accessService;
    private final InvoiceService invoiceService;

    public HotelFacadeImpl(HotelRepository repository, PriceService priceService, 
                           AccessService accessService, InvoiceService invoiceService) {
        this.repository = repository;
        this.priceService = priceService;
        this.accessService = accessService;
        this.invoiceService = invoiceService;
    }

    @Override
    public ReservationDTO createReservation(ReservationDTO dto) {
        Room room = repository.findRoomById(dto.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));
        
        if (!room.isAvailable()) {
            throw new RuntimeException("Room is not available");
        }

        Reservation reservation = new Reservation();
        reservation.setId(UUID.randomUUID().toString());
        reservation.setGuestName(dto.getGuestName());
        reservation.setGuestEmail(dto.getGuestEmail());
        reservation.setRoom(room);
        reservation.setCheckInDate(dto.getCheckInDate());
        reservation.setCheckOutDate(dto.getCheckOutDate());
        
        room.setAvailable(false);
        repository.saveRoom(room);
        repository.saveReservation(reservation);

        return mapToDTO(reservation);
    }

    @Override
    public void addService(String reservationId, AdditionalServiceType serviceType) {
        Reservation res = repository.findReservationById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        res.addService(serviceType);
        repository.saveReservation(res);
    }

    @Override
    public void performCheckIn(String reservationId) {
        Reservation res = repository.findReservationById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        res.setCheckedIn(true);
        res.setDigitalKey(accessService.generateDigitalKey());
        repository.saveReservation(res);
    }

    @Override
    public InvoiceDTO performCheckOut(String reservationId) {
        Reservation res = repository.findReservationById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        res.setCheckedOut(true);
        res.getRoom().setAvailable(true);
        repository.saveRoom(res.getRoom());
        repository.saveReservation(res);

        return invoiceService.generateInvoice(res, priceService.getSeason(res.getCheckInDate()));
    }

    @Override
    public List<Room> getAvailableRooms(LocalDate start, LocalDate end, String type) {
        return repository.findAllRooms().stream()
                .filter(Room::isAvailable)
                .filter(r -> type == null || r.getType().name().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    @Override
    public ReservationDTO getReservation(String reservationId) {
        return repository.findReservationById(reservationId)
                .map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
    }

    private ReservationDTO mapToDTO(Reservation res) {
        ReservationDTO dto = new ReservationDTO();
        dto.setId(res.getId());
        dto.setGuestName(res.getGuestName());
        dto.setGuestEmail(res.getGuestEmail());
        dto.setRoomId(res.getRoom().getId());
        dto.setCheckInDate(res.getCheckInDate());
        dto.setCheckOutDate(res.getCheckOutDate());
        dto.setServices(res.getServices());
        dto.setCheckedIn(res.isCheckedIn());
        dto.setCheckedOut(res.isCheckedOut());
        dto.setDigitalKey(res.getDigitalKey());
        dto.setTotalPrice(priceService.calculatePrice(res.getRoom(), res.getCheckInDate(), res.getCheckOutDate()));
        return dto;
    }
}
