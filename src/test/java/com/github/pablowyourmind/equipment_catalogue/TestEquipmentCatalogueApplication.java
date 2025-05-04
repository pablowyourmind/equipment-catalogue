package com.github.pablowyourmind.equipment_catalogue;

import org.springframework.boot.SpringApplication;

public class TestEquipmentCatalogueApplication {

	public static void main(String[] args) {
		SpringApplication.from(EquipmentCatalogueApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
