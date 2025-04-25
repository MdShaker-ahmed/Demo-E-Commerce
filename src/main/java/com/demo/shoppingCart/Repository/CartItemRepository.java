package com.demo.shoppingCart.Repository;

import com.demo.shoppingCart.Model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    public List<CartItem> findByUsername(String username);
    public void deleteByIdAndUsername(Long id, String username);
}
