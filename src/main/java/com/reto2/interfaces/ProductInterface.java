package com.reto2.interfaces;

import com.reto2.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductInterface extends MongoRepository<Product, Integer> {

}
