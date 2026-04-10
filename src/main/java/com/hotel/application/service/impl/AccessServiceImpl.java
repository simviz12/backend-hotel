package com.hotel.application.service.impl;

import com.hotel.application.service.AccessService;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class AccessServiceImpl implements AccessService {
    @Override
    public String generateDigitalKey() {
        return UUID.randomUUID().toString();
    }
}
