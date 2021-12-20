package com.reto2.repository;

import com.reto2.interfaces.ProductInterface;
import com.reto2.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author juand2g
 */

@Repository
public class ProductRepository {
    @Autowired
    private ProductInterface productCrudRepository;

    public List<Product> getAll() {
        return productCrudRepository.findAll();
    }

    public Optional<Product> getClothe(Integer id) {
        return productCrudRepository.findById(id);
    }

    public Product create(Product product) {
        return productCrudRepository.save(product);
    }

    public void update(Product product) {
        productCrudRepository.save(product);
    }

    public void delete(Product product) {
        productCrudRepository.delete(product);
    }
}
