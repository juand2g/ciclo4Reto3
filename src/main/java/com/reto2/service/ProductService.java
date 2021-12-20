package com.reto2.service;

import com.reto2.model.Product;
import com.reto2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository clotheRepository;

    public List<Product> getAll() {
        return clotheRepository.getAll();
    }

    public Optional<Product> getClothe(Integer id) {
        return clotheRepository.getClothe(id);
    }

    public Product create(Product product) {
        if (product.getId() == null) {
            return product;
        } else {
            return clotheRepository.create(product);
        }
    }

    public Product update(Product product) {

        if (product.getId() != null) {
            Optional<Product> dbProduct = clotheRepository.getClothe(product.getId());
            if (!dbProduct.isEmpty()) {

                if (product.getBrand()!= null) {
                    dbProduct.get().setBrand(product.getBrand());
                }

                if (product.getCategory() != null) {
                    dbProduct.get().setCategory(product.getCategory());
                }

                if (product.getInches()!= null){
                    dbProduct.get().setInches(product.getInches());
                }

                if (product.getResolution()!= null){
                    dbProduct.get().setResolution(product.getResolution());
                }
                if (product.getAspectRatio()!= null){
                    dbProduct.get().setAspectRatio(product.getAspectRatio());
                }

                if (product.getDescription() != null) {
                    dbProduct.get().setDescription(product.getDescription());
                }

                if (product.getPrice() != 0.0) {
                    dbProduct.get().setPrice(product.getPrice());
                }

                if (product.getQuantity() != 0) {
                    dbProduct.get().setQuantity(product.getQuantity());
                }

                if (product.getPhotography() != null) {
                    dbProduct.get().setPhotography(product.getPhotography());
                }

                dbProduct.get().setAvailability(product.isAvailability());
                clotheRepository.update(dbProduct.get());
                return dbProduct.get();
            } else {
                return product;
            }
        } else {
            return product;
        }
    }

    public boolean delete(Integer reference) {
        Boolean aBoolean = getClothe(reference).map(product -> {
            clotheRepository.delete(product);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
