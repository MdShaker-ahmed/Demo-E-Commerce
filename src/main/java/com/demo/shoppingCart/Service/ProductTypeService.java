package com.demo.shoppingCart.Service;

import com.demo.shoppingCart.Model.ProductType;
import com.demo.shoppingCart.Repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductTypeService {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    public ProductType saveProductType(ProductType productType) {
        return productTypeRepository.save(productType);
    }

    public List<ProductType> returnAllType() {
        return productTypeRepository.findAll();
    }
}
