package com.demo.shoppingCart.Model;

import jakarta.persistence.OneToOne;

public class ProductItem {

    private Long id;
    private double quantity;
    private double netPrice;

    @OneToOne
    private Product product;
}
