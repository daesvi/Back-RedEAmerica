package com.example.redeamerica.repository;

import com.example.redeamerica.model.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
    ArrayList<PostEntity> findByUserId(Long id);
}
