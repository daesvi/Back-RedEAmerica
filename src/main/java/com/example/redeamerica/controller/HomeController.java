package com.example.redeamerica.controller;

import com.example.redeamerica.model.PostEntity;
import com.example.redeamerica.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("home")
@RequiredArgsConstructor
public class HomeController {

    @Autowired
    PostService postService;

    @GetMapping()
    public ResponseEntity<ArrayList<PostEntity>> getAllPosts(){
        ArrayList<PostEntity> listPosts = postService.getAllPosts();
        return ResponseEntity.status(HttpStatus.OK).body(listPosts);
    }
}
