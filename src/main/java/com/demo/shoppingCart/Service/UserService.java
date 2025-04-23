package com.demo.shoppingCart.Service;

import com.demo.shoppingCart.Model.User;
import com.demo.shoppingCart.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);

    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User getUserByNameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
