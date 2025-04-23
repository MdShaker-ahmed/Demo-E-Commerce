package com.demo.shoppingCart.Controller;

import com.demo.shoppingCart.Model.ProductType;
import com.demo.shoppingCart.Service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @PostMapping("/save")
    public ProductType saveProductType(@RequestBody ProductType productType) {
        return productTypeService.saveProductType(productType);
    }

    @GetMapping("/all")
    public List<ProductType> returnAllType() {
        return productTypeService.returnAllType();
    }
}
