package com.kaybee.marketplace.repository;

import com.kaybee.marketplace.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

/* RoleRepository is a repository layer which extends JpaRepository to perform operations on Role table in the database */
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
