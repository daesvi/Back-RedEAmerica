package com.example.redeamerica.controller;

import com.example.redeamerica.dto.CommentDTO;
import com.example.redeamerica.dto.PostDTO;
import com.example.redeamerica.model.CommentEntity;
import com.example.redeamerica.model.PostEntity;
import com.example.redeamerica.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forum")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping()
    public ResponseEntity<?> createComment(@RequestBody CommentDTO commentDTO) {
        try {
            CommentEntity commentCreated = commentService.createComment(commentDTO);
            return ResponseEntity.status(HttpStatus.OK).body(commentCreated);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
