package com.github.pablowyourmind.equipment_catalogue.service;

import com.github.pablowyourmind.equipment_catalogue.model.Device;
import com.github.pablowyourmind.equipment_catalogue.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing devices in the equipment catalogue.
 * This class provides methods to save a device and search for devices by name.
 */
@Service
@RequiredArgsConstructor
public class DeviceService {

    private final DeviceRepository deviceRepository;

    /**
     * Saves a device to the catalogue.
     *
     * @param device the device to save
     * @return the saved device
     */
    public Device save (Device device) {
        return deviceRepository.save(device);
    }

    /**
     * Searches for devices by name.
     *
     * @param name the name to search for
     * @return a list of devices matching the search criteria
     */
    public List<Device> searchByName(String name) {
        return deviceRepository.findByNameContainingIgnoreCase(name);
    }
}
