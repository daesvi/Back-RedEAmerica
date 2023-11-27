package com.example.redeamerica.repository;

import com.example.redeamerica.model.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
    //List<PostEntity> findByUserId(Long id);  // Cambiado a List en lugar de ArrayList
    List<PostEntity> findByUserEntityId(Long userId);
}

