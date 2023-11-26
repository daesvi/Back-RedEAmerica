package com.example.redeamerica.service;

import com.example.redeamerica.dto.CommentDTO;
import com.example.redeamerica.model.CommentEntity;
import com.example.redeamerica.model.PostEntity;
import com.example.redeamerica.model.UserEntity;
import com.example.redeamerica.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    PostService postService;

    @Autowired
    CommentRepository commentRepository;

    public CommentEntity createComment(CommentDTO commentDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserEntity userFound = postService.getByEmailAuthenticated();

        CommentEntity newComment = new CommentEntity();
        newComment.setComment(commentDTO.getComment());
        newComment.setUserId(userFound.getId());
        newComment.setPostId(commentDTO.getPostId());

        return commentRepository.save(newComment);
    }

    public ArrayList<CommentEntity> getAllComments(Long id) {
        // Returns a list of all comments in the database.
        ArrayList<CommentEntity> listComments = commentRepository.findByPostId(id);
        return listComments;
    }
}
