package com.example.redeamerica.controller;

import com.example.redeamerica.dto.*;
import com.example.redeamerica.model.PostEntity;
import com.example.redeamerica.model.UserEntity;
import com.example.redeamerica.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("update/user")
    public ResponseEntity<?> updateUserInfo(@RequestBody UserUpdateDTO userUpdateDTO){
        String response = userService.updateUserInfo(userUpdateDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("update/redeamerica")
    public ResponseEntity<?> updateUserRedeamerica(@RequestBody RedeamericaUpdateDTO redeamericaUpdateDTO){
        String response = userService.updateUserRedeamerica(redeamericaUpdateDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
