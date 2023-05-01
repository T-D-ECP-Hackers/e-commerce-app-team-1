package org.global.ecp.hackathon.app.product;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    private final ProductService productService;

    public ProductController(final ProductService productService) {this.productService = productService;}

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody final ProductDto productDto) {

        return ResponseEntity.ok(productService.create(productDto));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {

        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable final Long id) {

        return ResponseEntity.ok(productService.getProductById(id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductId(@PathVariable final Long id) {

        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }
}