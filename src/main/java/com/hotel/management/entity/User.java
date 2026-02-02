package com.hotel.management.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
    name = "users",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "mobileNumber")
    }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Customer Name
    @Column(nullable = false)
    private String name;

    // Email (Unique & Required)
    @Column(nullable = false, unique = true)
    private String email;

    // Mobile Number with Country Code
    @Column(nullable = false, unique = true)
    private String mobileNumber;

    // Address
    @Column(nullable = true, length = 500)
    private String address;

    // Username (Unique & Required)
    @Column(nullable = false, unique = true)
    private String username;

    // Password
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;   // ADMIN, STAFF, USER

  
}
