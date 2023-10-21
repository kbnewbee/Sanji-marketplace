package com.kaybee.marketplace.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/* User is a POJO for storing users in the database */
@Data
@Entity
@Table(name = "users")
public class User {

    /* id field represents the primary key of users table */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /* firstName field represents the first name of the user
    *  it cannot be null
    * */
    @NotNull
    @Column(nullable = false)
    private String firstName;

    /* lastName field represents the last name of the user */
    private String lastName;

    /* email field represents the email of the user
    *  it has to be unique and cannot be null or empty
    * */
    @NotEmpty
    @Column(nullable = false, unique = true)
    @Email(message = "{error.invalid_email}")
    private String email;


    /* password field represents the encoded password of the user to login into the application */
    private String password;

    /* roles field represents the list of roles belonging to a specific user
     * @ManyToMany relationship because -> one user can have multiple roles and one role can have multiple users as well
     * joining users and roles table to create user_role table to store the mapping between them
     * */
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")}
    )
    private List<Role> roles;

    /* Copy constructor taking User as a parameter */
    public User(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roles = user.getRoles();
    }

    /* No Argument constructor */
    public User() {}
}
