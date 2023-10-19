package com.kaybee.marketplace.repository;

import com.kaybee.marketplace.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
