package com.example.redeamerica.service;

import com.example.redeamerica.dto.MembershipRequestDTO;
import com.example.redeamerica.dto.PostDTO;
import com.example.redeamerica.model.ERequestStatus;
import com.example.redeamerica.model.MembershipRequestEntity;
import com.example.redeamerica.model.PostEntity;
import com.example.redeamerica.model.UserEntity;
import com.example.redeamerica.repository.MembershipRequestRepository;
import com.example.redeamerica.repository.PostRepository;
import com.example.redeamerica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MembershipRequestService {
    @Autowired
    private MembershipRequestRepository membershipRequestRepository;
    @Autowired
    private UserRepository userRepository;

    public MembershipRequestEntity solicitarMembresia(MembershipRequestDTO membershipRequestDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();

            Optional<UserEntity> userFound = userRepository.findByEmail(username);
            if (userFound.isPresent()) {
                MembershipRequestEntity request = MembershipRequestEntity.builder()
                        .userId(userFound.get().getId())
                        .address(membershipRequestDTO.getAddress())
                        .identificationType(membershipRequestDTO.getIdentificationType())
                        .identificationNumber(membershipRequestDTO.getIdentificationNumber())
                        .urlIdentificationScan(membershipRequestDTO.getUrlIdentificationScan())
                        .educationLevel(membershipRequestDTO.getEducationLevel())
                        .urlEducationCertificate(membershipRequestDTO.getUrlEducationCertificate())
                        .requestStatus(ERequestStatus.PENDIENTE)
                        .build();
                return membershipRequestRepository.save(request);
            } else {
                throw new IllegalArgumentException("Usuario no encontrado");
            }
        }
        throw new IllegalArgumentException("Hubo un error al hacer la postulación");
    }}

