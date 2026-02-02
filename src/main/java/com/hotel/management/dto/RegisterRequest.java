package com.hotel.management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegisterRequest {

    // Customer Name
    @NotBlank(message = "Name is required")
    private String name;

    // Username
    @NotBlank(message = "Username is required")
    private String username;

    // Password
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    // Email
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    // Mobile Number with country code
    @NotBlank(message = "Mobile number is required")
    @Pattern(
        regexp = "^\\+\\d{10,15}$",
        message = "Mobile number must include country code"
    )
    private String mobileNumber;

    // Address
    @NotBlank(message = "Address is required")
    private String address;

    // ADMIN / STAFF / USER
    @NotBlank(message = "Role is required")
    private String role;

    // getters & setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
 
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }
 
    public void setAddress(String address) {
        this.address = address;
    }
 
    public String getRole() {
        return role;
    }
 
    public void setRole(String role) {
        this.role = role;
    }
}
