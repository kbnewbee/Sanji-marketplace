package com.kaybee.marketplace.service;

import com.kaybee.marketplace.model.CustomUserDetail;
import com.kaybee.marketplace.model.User;
import com.kaybee.marketplace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/* CustomUserDetailService is an implementation of UserDetailsService.
*  It is a service layer on top of userRepository to perform operations on users
* */
@Service
public class CustomUserDetailService implements UserDetailsService {

    /* userRepository layer to access user data from database */
    @Autowired
    private UserRepository userRepository;

    /* Get username by its email from thw database via userRepository layer */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByEmail(email);

        // If we DO NOT find any username having the given email in the database, we throw UsernameNotFoundException
        user.orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // user is wrapper up inside UserDetails POJO
        return user.map(CustomUserDetail::new).get();
    }
}
