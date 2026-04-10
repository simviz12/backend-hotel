package com.hotel.application.service;

import com.hotel.domain.model.Room;
import com.hotel.domain.enums.Season;
import java.time.LocalDate;

public interface PriceService {
    double calculatePrice(Room room, LocalDate start, LocalDate end);
    Season getSeason(LocalDate date);
}
