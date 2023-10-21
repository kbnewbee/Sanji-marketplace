package com.kaybee.marketplace.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* CustomUserDetails is a POJO extending User class
*  It implements UserDetails class
* */
public class CustomUserDetail extends User implements UserDetails {

    public CustomUserDetail(User user) {
        super(user);
    }

    /* Get all the authorities granted to the user */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        super.getRoles().forEach( role -> {
            authorityList.add(new SimpleGrantedAuthority(role.getName()));
        });

        return authorityList;
    }

    /* Get the username of the user which is email of the user to login into the application */
    @Override
    public String getUsername() {
        return super.getEmail();
    }

    /* Get encoded password of the user to login into the application*/
    @Override
    public String getPassword() {
        return super.getPassword();
    }

    /* To ensure account is not expired */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /* To ensure account is not locked */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /* To ensure credentials of the user are not expired */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /* To ensure the user is enabled */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
