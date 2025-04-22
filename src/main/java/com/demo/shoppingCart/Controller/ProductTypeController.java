package com.demo.shoppingCart.Controller;

import com.demo.shoppingCart.Model.ProductType;
import com.demo.shoppingCart.Service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/type")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @PostMapping("/save")
    public ProductType saveProductType(ProductType productType) {
        return productTypeService.saveProductType(productType);
    }

    @GetMapping("/all")
    public List<ProductType> returnAllType() {
        return productTypeService.returnAllType();
    }
}
