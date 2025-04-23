package com.demo.shoppingCart.Service;

import com.demo.shoppingCart.Model.Product;
import com.demo.shoppingCart.Model.ProductType;
import com.demo.shoppingCart.Repository.ProductRepository;
import com.demo.shoppingCart.Repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    public Product saveProduct(Product product) {
        final ProductType productType = product.getProductType();

        productTypeRepository.save(productType);

        return productRepository.save(product);
    }

    public List<Product> returnAllProduct() {
        return productRepository.findAll();
    }

    public Product findByProductName(String name) {
        return productRepository.findByName(name);
    }

    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        final ProductType productType = product.getProductType();

        existingProduct.setProductId(product.getProductId());
        existingProduct.setProductType(product.getProductType());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setUnitPrice(product.getUnitPrice());
        existingProduct.setImageUrl(product.getImageUrl());

        productTypeRepository.save(productType);

        return productRepository.save(existingProduct);
    }

    public String deleteProduct(Long id) {
        productRepository.deleteById(id);
        return "Product Deleted";
    }
}
