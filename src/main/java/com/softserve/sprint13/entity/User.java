package com.softserve.sprint13.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    public enum Role {
        MENTOR, TRAINEE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Pattern(regexp = ".+@.+\\..+", message = "Please provide a valid email address")
    @Column(name = "email")
    private String email;

    @NotNull
    @Size(min = 2, max = 20, message = "First name must be between 2 and 20 characters")
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 20, message = "Last name must be between 2 and 20 characters")
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private String role;

    @ToString.Exclude
    @ManyToMany //type of relation, joinColumns with id
    @JoinTable(name = "marathon_user", joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "marathon_id")})
    private List<Marathon> marathonUsers;

    public User() {
    }
}
