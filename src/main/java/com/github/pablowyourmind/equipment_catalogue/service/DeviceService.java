package com.github.pablowyourmind.equipment_catalogue.service;

import com.github.pablowyourmind.equipment_catalogue.model.Device;
import com.github.pablowyourmind.equipment_catalogue.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
     * Finds a device by its ID.
     *
     * @param id the ID of the device to find
     * @return the found device, or null if not found
     */
    public Optional<Device> findById(String id) {
        return deviceRepository.findById(id);
    }

    /**
     * Finds all devices in the catalogue.
     *
     * @return a list of all devices
     */
    public List<Device> findAll() {
        return deviceRepository.findAll();
    }

    /**
     * Searches for devices by name.
     *
     * @param name the name to search for
     * @return a list of devices matching the search criteria
     */
    public List<Device> findByName(String name) {
        return deviceRepository.findByNameContainingIgnoreCase(name);
    }

    /**
     * Updates an existing device in the catalogue.
     * First, it checks if the device exists in the database.
     * If it does, it updates the device. Otherwise, method throws a NoSuchElementException.
     * @param device
     * @return
     */
    public Device update(Device device) {
        Optional<Device> deviceFromDb = deviceRepository.findById(device.getId());
        if (deviceFromDb.isPresent()) {
            return deviceRepository.save(device);
        } else {
            throw new NoSuchElementException("Device not found");
        }
    }

    /**
     * Deletes a device from the catalogue.
     *
     * @param device the device to delete
     */
    public void delete(Device device) {
        deviceRepository.delete(device);
    }
}
