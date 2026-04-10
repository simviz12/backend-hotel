package com.hotel.application.service.impl;

import com.hotel.domain.enums.Season;
import com.hotel.domain.model.Room;
import com.hotel.application.service.PriceService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

@Service
public class PriceServiceImpl implements PriceService {

    @Override
    public double calculatePrice(Room room, LocalDate start, LocalDate end) {
        long nights = ChronoUnit.DAYS.between(start, end);
        if (nights <= 0) nights = 1;

        double basePrice = room.getType().getBasePrice();
        double factor = getSeason(start).getFactor();

        return basePrice * factor * nights;
    }

    @Override
    public Season getSeason(LocalDate date) {
        Month month = date.getMonth();
        if (month == Month.DECEMBER || month == Month.JANUARY || month == Month.JUNE || month == Month.JULY) {
            return Season.HIGH;
        }
        return Season.LOW;
    }
}
