package com.example.redeamerica.dto;

import com.example.redeamerica.model.ERole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private long id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private String country;
    private ERole roles;
}
