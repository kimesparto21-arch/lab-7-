package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // GET all products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    // GET product by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return ResponseEntity.status(404).body("Product not found");
        }
        return ResponseEntity.ok(product);
    }

    // POST create product
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product created = productService.createProduct(product);
        return ResponseEntity.status(201).body(created);
    }

    // PUT update product
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(
            @PathVariable Long id,
            @RequestBody Product product
    ) {
        Product updated = productService.updateProduct(id, product);
        if (updated == null) {
            return ResponseEntity.status(404).body("Product not found");
        }
        return ResponseEntity.ok(updated);
    }

    // DELETE product
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        boolean removed = productService.deleteProduct(id);
        if (!removed) {
            return ResponseEntity.status(404).body("Product not found");
        }
        return ResponseEntity.ok("Product deleted successfully");
    }
}
