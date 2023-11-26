package com.example.redeamerica.controller;


import com.example.redeamerica.dto.PostDTO;
import com.example.redeamerica.model.PostEntity;
import com.example.redeamerica.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;

@RestController
@RequestMapping("/blog")
public class PostController {

    @Autowired
     PostService postService;

    @PostMapping(value = "create")
    public ResponseEntity<?> createPost(@RequestBody PostDTO postDTO) {
        try {
            PostEntity postCreated = postService.createPost(postDTO);
            return ResponseEntity.status(HttpStatus.OK).body(postCreated);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }

    }
}