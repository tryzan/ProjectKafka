package com.unittestdemo.dto;

import com.unittestdemo.entity.Role;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class RegisterAccDTO {

    private Long id;

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "password is required")
    private String password;

    @NotBlank(message = "password confirmation is required")
    private String confirmPassword;

    @NotBlank(message = "role is required")
    private List<Role> role;

    @NotBlank(message = "first name is required")
    private String firstName;

    private String lastName;

    private String address;

    @NotBlank(message = "phone number is required")
    private String phoneNo;
}
