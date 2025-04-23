package com.demo.shoppingCart.Service;

import com.demo.shoppingCart.Model.CartItem;
import com.demo.shoppingCart.Repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    public List<CartItem> saveCartItems(List<CartItem> cartItemList) {
        return cartItemRepository.saveAll(cartItemList);
    }

    public String deleteCartitem(Long id) {
        cartItemRepository.deleteById(id);
        return "Cart item deleted";
    }
}
