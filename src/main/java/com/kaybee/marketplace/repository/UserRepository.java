package com.kaybee.marketplace.repository;

import com.kaybee.marketplace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/* UserRepository is a repository layer which extends JpaRepository to perform operations on User table in the database */
public interface UserRepository extends JpaRepository<User, Integer> {

    /* Get a single user by its email from the database */
    public Optional<User> findUserByEmail(String email);
}
