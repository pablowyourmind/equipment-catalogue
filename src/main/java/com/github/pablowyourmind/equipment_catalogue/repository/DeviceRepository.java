package com.github.pablowyourmind.equipment_catalogue.repository;

import com.github.pablowyourmind.equipment_catalogue.model.Device;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Repository interface for managing Device entities in the MongoDB database.
 * This interface extends MongoRepository to provide CRUD operations and custom query methods.
 */
public interface DeviceRepository extends MongoRepository<Device, String> {
    /**
     * Finds devices by their name, ignoring case.
     *
     * @param name the name to search for
     * @return a list of devices matching the search criteria
     */
    List<Device> findByNameContainingIgnoreCase(String name);

    /**
     * Finds devices by their manufacturer.
     *
     * @param manufacturer the manufacturer to search for
     * @return a list of devices matching the search criteria
     */
    List<Device> findByManufacturer(String manufacturer);
}
