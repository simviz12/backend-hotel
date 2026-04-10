package com.hotel.application.service.impl;

import com.hotel.application.dto.InvoiceDTO;
import com.hotel.application.service.InvoiceService;
import com.hotel.domain.model.Reservation;
import com.hotel.domain.enums.AdditionalServiceType;
import com.hotel.domain.enums.Season;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Override
    public InvoiceDTO generateInvoice(Reservation reservation, Season season) {
        double baseRate = reservation.getRoom().getType().getBasePrice();
        long nights = ChronoUnit.DAYS.between(reservation.getCheckInDate(), reservation.getCheckOutDate());
        if (nights <= 0) nights = 1;

        double roomTotal = baseRate * season.getFactor() * nights;
        
        var services = reservation.getServices().stream()
                .map(s -> new InvoiceDTO.ServiceDetail(s.name(), s.getPrice()))
                .collect(Collectors.toList());

        double servicesTotal = reservation.getServices().stream()
                .mapToDouble(AdditionalServiceType::getPrice)
                .sum();

        return new InvoiceDTO(
            reservation.getId(),
            reservation.getGuestName(),
            baseRate,
            season.getFactor(),
            services,
            roomTotal + servicesTotal
        );
    }
}
