package com.example.redeamerica.repository;

// MembershipRequestRepository.java
import com.example.redeamerica.model.MembershipRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;
@Repository
public interface MembershipRequestRepository extends JpaRepository<MembershipRequestEntity, Long> {



}
