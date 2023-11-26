package com.example.redeamerica.service;

import com.example.redeamerica.dto.MembershipRequestDTO;
import com.example.redeamerica.model.ERequestStatus;
import com.example.redeamerica.model.MembershipRequestEntity;
import com.example.redeamerica.model.UserEntity;
import com.example.redeamerica.repository.MembershipRequestRepository;
import com.example.redeamerica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MembershipRequestService {
    @Autowired
    private  MembershipRequestRepository membershipRequestRepository;
private UserRepository userRepository;

    public MembershipRequestEntity solicitarMembresia(MembershipRequestDTO membershipRequestDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();

            Optional<UserEntity> userFound = userRepository.findByEmail(username);
            MembershipRequestEntity request = MembershipRequestEntity.builder()

                    .userId (userFound.get().getId ())
                    .address(membershipRequestDTO.getAddress ())
                    .identificationType(membershipRequestDTO.getIdentificationType ())
                    .identificationNumber(membershipRequestDTO.getIdentificationNumber ())
                    .urlIdentificationScan(membershipRequestDTO.getUrlIdentificationScan ())
                    .educationLevel(membershipRequestDTO.getEducationLevel ())
                    .urlEducationCertificate(membershipRequestDTO.getUrlEducationCertificate ())
                    .requestStatus(ERequestStatus.PENDIENTE) // Puedes establecer el estado inicial según tus necesidades
                    .build();
            return membershipRequestRepository.save(request);
        }
        throw new IllegalArgumentException("Hubo un error al hacer la postulacion");

    }

    public MembershipRequestDTO obtenerMembresia(Long userId) {
        MembershipRequestEntity solicitud = membershipRequestRepository.findByUserId(userId);
        return transformarASolicitudDTO(solicitud);
    }

    public void eliminarMembresia(Long userId) throws MembresiaNotFoundException {
        MembershipRequestEntity solicitud = membershipRequestRepository.findByUserId(userId);
        if (solicitud != null) {
            membershipRequestRepository.delete(solicitud);
        } else {
            // Manejar el caso cuando la membresía no existe para el usuario dado
            throw new MembresiaNotFoundException("No se encontró la membresía para el usuario con ID: " + userId);
        }
    }

    private MembershipRequestDTO transformarASolicitudDTO(MembershipRequestEntity solicitud) {
        if (solicitud != null) {
            MembershipRequestDTO dto = new MembershipRequestDTO();
            // Mapeo de propiedades
            dto.setAddress(solicitud.getAddress());
            dto.setIdentificationType(solicitud.getIdentificationType());
            dto.setIdentificationNumber(solicitud.getIdentificationNumber());
            dto.setUrlIdentificationScan(solicitud.getUrlIdentificationScan());
            dto.setEducationLevel(solicitud.getEducationLevel());
            dto.setUrlEducationCertificate(solicitud.getUrlEducationCertificate());
            return dto;
        } else {
            return null; // Manejar el caso cuando la membresía es nula
        }
    }

    // Otros métodos

    public void actualizarMembresia(Long userId, String address, String identificationType, String identificationNumber, String urlIdentificationScan, String educationLevel, String urlEducationCertificate) throws MembresiaNotFoundException {
        // Lógica para actualizar información de membresía...
        MembershipRequestEntity solicitud = membershipRequestRepository.findByUserId(userId);
        if (solicitud != null) {
            solicitud.setAddress(address);
            solicitud.setIdentificationType(identificationType);
            solicitud.setIdentificationNumber(identificationNumber);
            solicitud.setUrlIdentificationScan(urlIdentificationScan);
            solicitud.setEducationLevel(educationLevel);
            solicitud.setUrlEducationCertificate(urlEducationCertificate);
            membershipRequestRepository.save(solicitud);
        } else {
            // Manejar el caso cuando la membresía no existe para el usuario dado
            throw new MembresiaNotFoundException("No se encontró la membresía para el usuario con ID: " + userId);
        }
    }



}
