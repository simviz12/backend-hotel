package com.hotel.application.service;

import com.hotel.application.dto.InvoiceDTO;
import com.hotel.domain.model.Reservation;
import com.hotel.domain.enums.Season;

public interface InvoiceService {
    InvoiceDTO generateInvoice(Reservation reservation, Season season);
}
