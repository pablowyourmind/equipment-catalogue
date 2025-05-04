package com.github.pablowyourmind.equipment_catalogue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class EquipmentCatalogueApplicationTests {

	@Test
	void contextLoads() {
	}

}
