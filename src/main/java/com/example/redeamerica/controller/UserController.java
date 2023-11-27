package com.example.redeamerica.controller;

import com.example.redeamerica.dto.UserProfileUpdateDTO;
import com.example.redeamerica.model.UserEntity;
import com.example.redeamerica.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// UserController.java
@RestController
@RequestMapping("/api/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{email}")
    public ResponseEntity<UserEntity> obtenerUsuario(@PathVariable String email) {
        UserEntity user = userService.obtenerUsuarioPorEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/{email}")
    public ResponseEntity<UserEntity> actualizarPerfilUsuario(
            @PathVariable String email,
            @RequestBody UserProfileUpdateDTO updateDTO) {
        UserEntity updatedUser = userService.actualizarPerfilUsuario(email, updateDTO);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}

