package com.demo.shoppingCart.Controller;

import com.demo.shoppingCart.Model.Product;
import com.demo.shoppingCart.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public Product saveOneProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/all")
    public List<Product> getAllProduct() {
        return productService.returnAllProduct();
    }

    @GetMapping("/name/{name}")
    public Product getByName(@PathVariable("name") String name) {
        return productService.findByProductName(name);
    }

    @GetMapping("/test")
    public String test() {
        return "hello world";
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        return productService.deleteProduct(id);
    }
}
