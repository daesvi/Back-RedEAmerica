package com.example.redeamerica.repository;

<<<<<<< HEAD

import com.example.redeamerica.model.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
=======
import com.example.redeamerica.model.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
    ArrayList<PostEntity> findByUserId(Long id);
>>>>>>> 5c751ed43c214f530743922f9fd17e31574c06e2
}
