package com.github.pablowyourmind.equipment_catalogue.repository;

import com.github.pablowyourmind.equipment_catalogue.model.Device;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DeviceRepository extends MongoRepository<Device, String> {
    List<Device> findByNameContainingIgnoreCase(String name);
    List<Device> findByManufacturer(String manufacturer);
}
