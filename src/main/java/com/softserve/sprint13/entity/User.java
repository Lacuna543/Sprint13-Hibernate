package com.softserve.sprint13.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Getter
@Setter
public class User {
    public enum Role {
        MENTOR, TRAINEE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = ".+@.+\\..+", message = "Please provide a valid email address")
    @NotNull
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
    private Role role;

    @ToString.Exclude
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "marathon_user", joinColumns = {@JoinColumn(name = "user_id")},//type of relation, joinColumns with id
            inverseJoinColumns = {@JoinColumn(name = "marathon_id")})
    private List<Marathon> marathonUsers;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
