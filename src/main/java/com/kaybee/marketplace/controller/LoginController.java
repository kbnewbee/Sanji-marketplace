package com.kaybee.marketplace.controller;

import com.kaybee.marketplace.global.GlobalData;
import com.kaybee.marketplace.model.Role;
import com.kaybee.marketplace.model.User;
import com.kaybee.marketplace.repository.RoleRepository;
import com.kaybee.marketplace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login(){
        GlobalData.cart.clear();
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, HttpServletRequest httpServletRequest) throws ServletException {
        String password = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(password));

        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findById(2).get());

        user.setRoles(roles);

        userRepository.save(user);

        httpServletRequest.login(user.getEmail(), password);
        return "redirect:/";
    }
}
