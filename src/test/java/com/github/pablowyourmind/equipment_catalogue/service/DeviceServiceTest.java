package com.github.pablowyourmind.equipment_catalogue.service;


import com.github.pablowyourmind.equipment_catalogue.model.Device;
import com.github.pablowyourmind.equipment_catalogue.repository.DeviceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeviceServiceTest {

    @Mock
    private DeviceRepository deviceRepository;

    @InjectMocks
    private DeviceService deviceService;

    @Test
    void saveShouldPersistDevice() {
        Device device = new Device();
        device.setId("1");
        device.setName("Device A");
        when(deviceRepository.save(device)).thenReturn(device);

        Device result = deviceService.save(device);

        assertEquals(device, result);
        verify(deviceRepository).save(device);
    }

    @Test
    void findByIdShouldReturnDeviceWhenExists() {
        String id = "1";
        Device device = new Device();
        device.setId(id);
        device.setName("Device A");
        when(deviceRepository.findById(id)).thenReturn(Optional.of(device));

        Optional<Device> result = deviceService.findById(id);

        assertTrue(result.isPresent());
        assertEquals(device, result.get());
    }

    @Test
    void findByIdShouldReturnEmptyWhenNotExists() {
        String id = "1";
        when(deviceRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Device> result = deviceService.findById(id);

        assertTrue(result.isEmpty());
    }

    @Test
    void findAllShouldReturnAllDevices() {
        Device device1 = new Device();
        device1.setId("1");
        device1.setName("Device A");
        Device device2 = new Device();
        device2.setId("2");
        device2.setName("Device B");
        List<Device> devices = List.of(device1, device2);
        when(deviceRepository.findAll()).thenReturn(devices);

        List<Device> result = deviceService.findAll();

        assertEquals(devices, result);
    }

    @Test
    void findByNameShouldReturnMatchingDevices() {
        String name = "Device";
        Device device1 = new Device();
        device1.setId("1");
        device1.setName("Device A");
        Device device2 = new Device();
        device2.setId("2");
        device2.setName("Device B");
        List<Device> devices = List.of(device1, device2);
        when(deviceRepository.findByNameContainingIgnoreCase(name)).thenReturn(devices);

        List<Device> result = deviceService.findByName(name);

        assertEquals(devices, result);
    }

    @Test
    void updateShouldModifyExistingDevice() {
        Device device = new Device();
        device.setId("1");
        device.setName("Updated Device");
        when(deviceRepository.findById(device.getId())).thenReturn(Optional.of(device));
        when(deviceRepository.save(device)).thenReturn(device);

        Device result = deviceService.update(device);

        assertEquals(device, result);
        verify(deviceRepository).save(device);
    }

    @Test
    void updateShouldThrowExceptionWhenDeviceNotFound() {
        Device device = new Device();
        device.setId("1");
        device.setName("Nonexistent Device");
        when(deviceRepository.findById(device.getId())).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> deviceService.update(device));
    }

    @Test
    void deleteShouldRemoveDevice() {
        Device device = new Device();
        device.setId("1");
        device.setName("Device A");

        deviceService.delete(device);

        verify(deviceRepository).delete(device);
    }
}
