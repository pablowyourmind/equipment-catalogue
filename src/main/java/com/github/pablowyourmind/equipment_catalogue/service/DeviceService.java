package com.github.pablowyourmind.equipment_catalogue.service;

import com.github.pablowyourmind.equipment_catalogue.model.Device;
import com.github.pablowyourmind.equipment_catalogue.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public Device save (Device device) {
        return deviceRepository.save(device);
    }

    public List<Device> searchByName(String name) {
        return deviceRepository.findByNameContainingIgnoreCase(name);
    }
}
