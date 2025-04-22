package com.demo.shoppingCart.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class ProductType {

    @Id
    private Long id;
    private String type;
    @OneToMany(mappedBy = "productType", cascade = CascadeType.ALL)
    private List<Product> product;

    public ProductType() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
