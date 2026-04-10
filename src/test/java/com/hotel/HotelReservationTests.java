package com.hotel;

import com.hotel.application.dto.InvoiceDTO;
import com.hotel.application.dto.ReservationDTO;
import com.hotel.application.service.HotelFacade;
import com.hotel.domain.enums.AdditionalServiceType;
import com.hotel.domain.model.Room;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HotelReservationTests {

    @Autowired
    private HotelFacade hotelFacade;

    @Test
    void testFullReservationFlow() {
        // 1. Check availability
        LocalDate start = LocalDate.now();
        LocalDate end = start.plusDays(2);
        List<Room> rooms = hotelFacade.getAvailableRooms(start, end, "SINGLE");
        assertFalse(rooms.isEmpty());
        String roomId = rooms.get(0).getId();

        // 2. Create Reservation
        ReservationDTO dto = new ReservationDTO();
        dto.setGuestName("John Doe");
        dto.setGuestEmail("john@example.com");
        dto.setRoomId(roomId);
        dto.setCheckInDate(start);
        dto.setCheckOutDate(end);

        ReservationDTO reservation = hotelFacade.createReservation(dto);
        assertNotNull(reservation.getId());
        assertEquals("John Doe", reservation.getGuestName());

        // 3. Perform Check-in (issuing digital key)
        hotelFacade.performCheckIn(reservation.getId());
        ReservationDTO updatedRes = hotelFacade.getReservation(reservation.getId());
        assertTrue(updatedRes.isCheckedIn());
        assertNotNull(updatedRes.getDigitalKey());

        // 4. Add Services
        hotelFacade.addService(reservation.getId(), AdditionalServiceType.SPA);
        hotelFacade.addService(reservation.getId(), AdditionalServiceType.BREAKFAST);

        // 5. Complete Check-out and Verify Invoice
        InvoiceDTO invoice = hotelFacade.performCheckOut(reservation.getId());
        assertNotNull(invoice);
        assertTrue(invoice.getTotalPrice() > 0);
        assertEquals(2, invoice.getAdditionalServices().size());
        System.out.println("Final Invoice Price: $" + invoice.getTotalPrice());
    }
}
