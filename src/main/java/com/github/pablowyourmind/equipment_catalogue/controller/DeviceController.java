package com.github.pablowyourmind.equipment_catalogue.controller;

import com.github.pablowyourmind.equipment_catalogue.model.Device;
import com.github.pablowyourmind.equipment_catalogue.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing devices.
 * Provides endpoints for adding and searching devices.
 */
@RestController
@RequestMapping("/api/devices")
@RequiredArgsConstructor
public class DeviceController {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    private final DeviceService deviceService;

    /**
     * Adds a new device to the catalogue.
     *
     * @param device the device to add
     * @return the added device
     */
    @PostMapping
    public ResponseEntity<Device> addDevice(@RequestBody Device device) {
        logger.info("Adding device: {}", device);
        Device savedDevice = deviceService.save(device);
        logger.info("Device saved. ID: {}, name: {}", savedDevice.getId(), savedDevice.getName());
        return ResponseEntity.ok(savedDevice);
    }

    /**
     * Searches for devices by name.
     *
     * @param name the name to search for
     * @return a list of devices matching the search criteria
     */
    @GetMapping("/search")
    public ResponseEntity<List<Device>> searchDevices(@RequestParam String name) {
        logger.info("Searching devices with name: {}", name);
        List<Device> devices = deviceService.findByName(name);
        logger.info("Found {} devices", devices.size());
        return ResponseEntity.ok(devices);
    }
}
