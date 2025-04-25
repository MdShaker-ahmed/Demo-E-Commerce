package com.demo.shoppingCart.Service;

import com.demo.shoppingCart.DTO.CartDTO;
import com.demo.shoppingCart.Model.CartItem;
import com.demo.shoppingCart.Model.User;
import com.demo.shoppingCart.Repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CurrentUserService currentUserService;

    public List<CartItem> saveCartItems(List<CartItem> cartItemList) {
        return cartItemRepository.saveAll(cartItemList);
    }

    public String deleteCartItem(Long id) {
        User user = currentUserService.returnCurrentUser();
        //cartItemRepository.deleteByIdAndUsername(id, currentUserService.returnCurrentUser().getUsername());
        cartItemRepository.deleteById(id);
        return "Cart item deleted";
    }

    public List<CartDTO> returnCartItemByUser() {
        List<CartItem> cartItems = cartItemRepository.findByUsername(currentUserService.returnCurrentUser().getUsername());
        final List<CartDTO> cartItem = new ArrayList<>();

        for(CartItem item : cartItems) {
            CartDTO cartDTO = new CartDTO();

            cartDTO.setCartId(item.getCart().getId());
            cartDTO.setCartItemId(item.getId());
            cartDTO.setProductId(item.getProduct().getProductId());
            cartDTO.setName(item.getProduct().getName());
            cartDTO.setDescription(item.getProduct().getDescription());
            cartDTO.setUnitPrice(item.getProduct().getUnitPrice());
            cartDTO.setQuantity(item.getQuantity());
            cartDTO.setNetPrice(item.getNetPrice());

            cartItem.add(cartDTO);
        }

        return cartItem;
    }
}
