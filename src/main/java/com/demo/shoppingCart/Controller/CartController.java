package com.demo.shoppingCart.Controller;

import com.demo.shoppingCart.Model.Cart;
import com.demo.shoppingCart.Service.CartItemService;
import com.demo.shoppingCart.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @PostMapping("/save")
    public Cart saveCart(@RequestBody Cart cart) {
        return cartService.saveCart(cart);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCartItem(@PathVariable("id") Long id) {
        return cartItemService.deleteCartitem(id);
    }
}
