package com.example.redeamerica.repository;

import com.example.redeamerica.model.MembershipRequestEntity;
import com.example.redeamerica.model.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface MembershipRequestRepository extends JpaRepository<MembershipRequestEntity, Long> {
    Optional<MembershipRequestEntity> findByUserId(Long id);

}