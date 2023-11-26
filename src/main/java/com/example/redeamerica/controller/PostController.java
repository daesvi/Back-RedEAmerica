package com.example.redeamerica.controller;

<<<<<<< HEAD

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
=======
import com.example.redeamerica.dto.PostDTO;
import com.example.redeamerica.model.PostEntity;
import com.example.redeamerica.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
>>>>>>> 5c751ed43c214f530743922f9fd17e31574c06e2

@RestController
@RequestMapping("/blog")
public class PostController {

    @Autowired
<<<<<<< HEAD
     PostService postService;
=======
    PostService postService;
>>>>>>> 5c751ed43c214f530743922f9fd17e31574c06e2

    @PostMapping(value = "create")
    public ResponseEntity<?> createPost(@RequestBody PostDTO postDTO) {
        try {
            PostEntity postCreated = postService.createPost(postDTO);
            return ResponseEntity.status(HttpStatus.OK).body(postCreated);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
<<<<<<< HEAD

    }
}
=======
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
>>>>>>> 5c751ed43c214f530743922f9fd17e31574c06e2
