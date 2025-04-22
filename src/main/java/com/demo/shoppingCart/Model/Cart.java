package com.demo.shoppingCart.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

//@Entity
public class Cart {


    private Long id;

    @OneToMany
    private ProductItem productItem;

}
