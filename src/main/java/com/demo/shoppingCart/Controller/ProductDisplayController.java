package com.demo.shoppingCart.Controller;

import com.demo.shoppingCart.DTO.ProductDTO;
import com.demo.shoppingCart.Service.ProductDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/product/display")
public class ProductDisplayController {

    @Autowired
    private ProductDisplayService productDisplayServiced;

    @GetMapping("/all")
    public List<ProductDTO> displayAllProducts() {
        return productDisplayServiced.getAllProduct();
    }
}
