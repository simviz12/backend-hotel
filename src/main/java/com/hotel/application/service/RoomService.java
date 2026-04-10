package com.hotel.application.service;

import com.hotel.application.dto.RoomDTO;
import java.util.List;

public interface RoomService {
    List<RoomDTO> findAll();
    RoomDTO save(RoomDTO roomDTO);
}
