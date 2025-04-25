package com.demo.shoppingCart.Controller;

import com.demo.shoppingCart.DTO.CartDTO;
import com.demo.shoppingCart.Model.Cart;
import com.demo.shoppingCart.Model.CartItem;
import com.demo.shoppingCart.Service.CartItemService;
import com.demo.shoppingCart.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cart/user")
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
        return cartItemService.deleteCartItem(id);
    }

    @GetMapping("/display")
    public List<CartDTO> returnCartItemByUser() {
        return cartItemService.returnCartItemByUser();
    }

    @GetMapping("/total")
    public double returnTotalPrice() {
        final List<CartDTO> cartItem = cartItemService.returnCartItemByUser();
        double sum = 0.0;
        final double finalPrice;

        for(CartDTO item : cartItem) {
            sum += item.getNetPrice();
        }

        finalPrice = sum;

        return finalPrice;
    }
}
