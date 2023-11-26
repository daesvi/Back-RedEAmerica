package com.example.redeamerica.controller;

import com.example.redeamerica.dto.PostDTO;
import com.example.redeamerica.model.PostEntity;
import com.example.redeamerica.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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

    @GetMapping
    public ResponseEntity<ArrayList<PostEntity>> getPostsByUser(){
        ArrayList<PostEntity> postCreated = postService.getPostsByUser();
        return ResponseEntity.status(HttpStatus.OK).body(postCreated);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String>  deletePostById(@PathVariable Long id){
        boolean postDeleted = postService.deletePostById(id);
        if (postDeleted){
            return ResponseEntity.status(HttpStatus.OK).body("Publicación eliminada con éxito");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                "Hubo un error al eliminar la publicación, verifica los datos");
    }

}
