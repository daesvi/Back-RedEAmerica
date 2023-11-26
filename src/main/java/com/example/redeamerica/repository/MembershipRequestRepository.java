package com.example.redeamerica.repository;

// MembershipRequestRepository.java
import com.example.redeamerica.model.MembershipRequestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipRequestRepository extends JpaRepository<MembershipRequestEntity, Long> {

    MembershipRequestEntity findByUserId(Long userId);


}
