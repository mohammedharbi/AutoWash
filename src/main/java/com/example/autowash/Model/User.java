package com.example.autowash.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Check(constraints = "role = 'Customer' or 'Admin'")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "username is empty")
    @Size(min = 4,message = "username must be at least 4 characters or more ")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String username;

    @NotEmpty(message = "password is empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String password;

    @NotEmpty(message = "email is empty")
    @Email
    @Column(columnDefinition = "varchar(40) not null unique")
    private String email;

    @NotEmpty(message = "role is empty")
    @Pattern(regexp = "^(Customer|Admin)")
    @Column(columnDefinition = "varchar(8) not null")
    private String role;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime registrationDate;
}
