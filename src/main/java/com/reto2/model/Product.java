package com.reto2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author juand2g
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
public class Product {
    @Id
    private Integer id;
    private String brand;
    private String category;
    private String inches;
    private String resolution;
    private String aspectRatio;
    private String description;
    private boolean availability;
    private double price;
    private Integer quantity;
    private String photography;
}
