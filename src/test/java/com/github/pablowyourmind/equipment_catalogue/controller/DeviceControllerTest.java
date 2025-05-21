package com.github.pablowyourmind.equipment_catalogue.controller;

import com.github.pablowyourmind.equipment_catalogue.model.Device;
import com.github.pablowyourmind.equipment_catalogue.service.DeviceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test class for the DeviceController.
 * This class uses the @WebMvcTest annotation to test the controller layer in isolation.
 */
@WebMvcTest(DeviceController.class)
class DeviceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private DeviceService deviceService;

    /**
     * Test for the addDevice method in the DeviceController.
     * This test verifies that a device can be added successfully and that the response contains the correct device information.
     *
     * @throws Exception if an error occurs during the request
     */
    @Test
    void shoudlAddDevice() throws Exception {
        Device device = new Device();
        device.setName("Monitor");
        when(deviceService.save(any(Device.class))).thenReturn(device);

        mockMvc.perform(post("/api/devices")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "name": "Monitor"
                        }
                        """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Monitor"));
    }
}
