package com.example.redeamerica.controller;

import com.example.redeamerica.model.PostEntity;
import com.example.redeamerica.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<PostEntity>> getAllPosts() {
        List<PostEntity> listPosts = postService.getAllPosts();
        return ResponseEntity.ok(listPosts);
    }
}
