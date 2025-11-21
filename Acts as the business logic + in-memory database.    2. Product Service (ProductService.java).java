package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProductService {

    private Map<Long, Product> products = new HashMap<>();
    private Long nextId = 4L;

    public ProductService() {
        products.put(1L, new Product(1L, "Laptop Pro", 59999.0));
        products.put(2L, new Product(2L, "Gaming Mouse", 1299.0));
        products.put(3L, new Product(3L, "Mechanical Keyboard", 3499.0));
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    public Product getProductById(Long id) {
        return products.get(id);
    }

    public Product createProduct(Product newProduct) {
        newProduct.setId(nextId++);
        products.put(newProduct.getId(), newProduct);
        return newProduct;
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        if (!products.containsKey(id)) {
            return null;
        }
        updatedProduct.setId(id);
        products.put(id, updatedProduct);
        return updatedProduct;
    }

    public boolean deleteProduct(Long id) {
        return products.remove(id) != null; n-b +0666
    }
}
