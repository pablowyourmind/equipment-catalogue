package com.github.pablowyourmind.equipment_catalogue.model;

import lombok.Data;

/**
 * Represents a reference to a file, including its type and URL.
 */
@Data
public class FileRef {
    private String type;
    private String url;
}
