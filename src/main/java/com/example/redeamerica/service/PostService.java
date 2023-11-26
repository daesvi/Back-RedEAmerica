package com.example.redeamerica.service;

<<<<<<< HEAD


=======
>>>>>>> 5c751ed43c214f530743922f9fd17e31574c06e2
import com.example.redeamerica.dto.PostDTO;
import com.example.redeamerica.model.PostEntity;
import com.example.redeamerica.model.UserEntity;
import com.example.redeamerica.repository.PostRepository;
import com.example.redeamerica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> 5c751ed43c214f530743922f9fd17e31574c06e2
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    public PostEntity createPost (PostDTO postDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

<<<<<<< HEAD
=======
        UserEntity userFound = getByEmailAuthenticated();

        PostEntity newPost = new PostEntity();

        newPost.setUserId(userFound.getId());
        newPost.setContent(postDTO.getContent());
        newPost.setMediaUrl(postDTO.getMediaUrl());
        newPost.setCategory(postDTO.getCategory());
        newPost.setTimestamp(LocalDateTime.now());
        newPost.setCountry(postDTO.getCountry());
        return postRepository.save(newPost);
    }



    public ArrayList<PostEntity> getAllFlights() {
        // Returns a list of all flights in the database.
        return (ArrayList<PostEntity>) postRepository.findAll();
    }


    public ArrayList<PostEntity> getPostsByUser (){
        UserEntity userFound = getByEmailAuthenticated();
        return (ArrayList<PostEntity>) postRepository.findByUserId(userFound.getId());
    }

    private UserEntity getByEmailAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
>>>>>>> 5c751ed43c214f530743922f9fd17e31574c06e2
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();

            Optional<UserEntity> userFound = userRepository.findByEmail(username);
<<<<<<< HEAD

            PostEntity newPost = new PostEntity();

            newPost.setUserId(userFound.get().getId());
            newPost.setContent(postDTO.getContent());
            newPost.setMediaUrl(postDTO.getMediaUrl());
            newPost.setCategory(postDTO.getCategory());
            newPost.setTimestamp(LocalDateTime.now());
            newPost.setCountry(postDTO.getCountry());
            return postRepository.save(newPost);
        }
        throw new IllegalArgumentException("Hubo un error al crear la publicacion");
    }
=======
            return userFound.orElseThrow();
        }
        throw new IllegalArgumentException("No hay un usuario logeado");
    }


    public boolean deletePostById(Long id){
        try {
            Optional<PostEntity> postFound = postRepository.findById(id);

            Long userId = postFound.get().getUserId();
            UserEntity userFound = getByEmailAuthenticated();

            if (userFound.getId() == userId) {
                postRepository.deleteById(id);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

>>>>>>> 5c751ed43c214f530743922f9fd17e31574c06e2
}
