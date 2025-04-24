package com.demo.shoppingCart.Service;

import com.demo.shoppingCart.DTO.ProductDTO;
import com.demo.shoppingCart.Model.Product;
import com.demo.shoppingCart.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDisplayService {

    @Autowired
    private ProductRepository productRepository;

    private final List<ProductDTO> productList = new ArrayList<>();

    public List<ProductDTO> getAllProduct() {
        List<Product> products = productRepository.findAll();

        for(Product product: products) {
            ProductDTO productDTO = new ProductDTO();

            productDTO.setProductId(product.getProductId());
            productDTO.setName(product.getName());
            productDTO.setDescription(product.getDescription());
            productDTO.setUnitPrice(product.getUnitPrice());

            productList.add(productDTO);
        }

        return productList;
    }
}
