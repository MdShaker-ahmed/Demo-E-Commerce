package com.demo.shoppingCart.Controller;

import com.demo.shoppingCart.Model.User;
import com.demo.shoppingCart.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public User registerUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        User userT = userService.getUserByNameAndPassword(user.getUsername(), user.getPassword());

        if(userT == null)
            return "User not registered/credentials is incorrect";
        else
            return "Log in successful!!";
    }
}
