package com.demo.shoppingCart.Service;

import com.demo.shoppingCart.Model.Cart;
import com.demo.shoppingCart.Model.CartItem;
import com.demo.shoppingCart.Model.Product;
import com.demo.shoppingCart.Model.User;
import com.demo.shoppingCart.Repository.CartRepository;
import com.demo.shoppingCart.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CurrentUserService currentUserService;

    public Cart saveCart(Cart cart) {
        List<CartItem> cartItems = cart.getCartItems();
        List<CartItem> finalItems = new ArrayList<>();

        for(CartItem item: cartItems) {
            Product product = productRepository.findById(item.getProduct().getId()).orElse(null);
            item.setCart(cart);
            item.setNetPrice(item.getQuantity() * product.getUnitPrice());
            item.setUsername(currentUserService.returnCurrentUser().getUsername());
            finalItems.add(item);
        }

        cart.setCartItems(finalItems);
        cart.setUsername(currentUserService.returnCurrentUser().getUsername());

        return cartRepository.save(cart);
    }

    public List<Cart> getAllCart() {
        return cartRepository.findAll();
    }
}
