package com.example.redeamerica.controller;

import com.example.redeamerica.dto.RedeamericaDTO;
import com.example.redeamerica.dto.UserDTO;
import com.example.redeamerica.model.PostEntity;
import com.example.redeamerica.model.UserEntity;
import com.example.redeamerica.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/profile")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("user")
    public ResponseEntity<?> getProfileInfoUser(){
        UserDTO user = userService.getProfileInfoUser();
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("redeamerica")
    public ResponseEntity<?> getProfileInfoRedeamerica(){
        RedeamericaDTO user = userService.getProfileInfoRedeamerica();
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
