package com.hotel.web.controller;

import com.hotel.application.dto.InvoiceDTO;
import com.hotel.application.dto.ReservationDTO;
import com.hotel.application.service.HotelFacade;
import com.hotel.domain.enums.AdditionalServiceType;
import com.hotel.domain.model.Room;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/hotel")
@CrossOrigin(origins = "*")
public class HotelController {

    private final HotelFacade hotelFacade;

    public HotelController(HotelFacade hotelFacade) {
        this.hotelFacade = hotelFacade;
    }

    @PostMapping("/reserve")
    public ResponseEntity<ReservationDTO> reserve(@RequestBody ReservationDTO reservationDTO) {
        return ResponseEntity.ok(hotelFacade.createReservation(reservationDTO));
    }

    @GetMapping("/availability")
    public ResponseEntity<List<Room>> getAvailability(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end,
            @RequestParam(required = false) String type) {
        return ResponseEntity.ok(hotelFacade.getAvailableRooms(start, end, type));
    }

    @PostMapping("/services/{reservationId}")
    public ResponseEntity<Void> addService(
            @PathVariable String reservationId,
            @RequestParam AdditionalServiceType type) {
        hotelFacade.addService(reservationId, type);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/check-in/{reservationId}")
    public ResponseEntity<Void> checkIn(@PathVariable String reservationId) {
        hotelFacade.performCheckIn(reservationId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/check-out/{reservationId}")
    public ResponseEntity<InvoiceDTO> checkOut(@PathVariable String reservationId) {
        return ResponseEntity.ok(hotelFacade.performCheckOut(reservationId));
    }

    @GetMapping("/reservation/{reservationId}")
    public ResponseEntity<ReservationDTO> getReservation(@PathVariable String reservationId) {
        return ResponseEntity.ok(hotelFacade.getReservation(reservationId));
    }
}
