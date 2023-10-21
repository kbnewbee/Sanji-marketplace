package com.kaybee.marketplace.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/* Role is a POJO for storing roles of users in the database */
@Data
@Entity
@Table(name = "roles")
public class Role {

    /* id field represents the primary key of roles table */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /* name field represents the role name
    *  it has to be unique and cannot be null
    * */
    @Column(nullable = false, unique = true)
    @NotEmpty
    private String name;

    /* users field represents the list of users belonging to a specific role
    * @ManyToMany relationship because -> one user can have multiple roles and one role can have multiple users as well
    * */
    @ManyToMany(mappedBy = "roles")
    private List<User> users;

}
