package com.example.redeamerica.service;
import com.example.redeamerica.dto.MembershipRequestDTO;
import com.example.redeamerica.model.ERequestStatus;
import com.example.redeamerica.model.MembershipRequestEntity;
import com.example.redeamerica.model.UserEntity;
import com.example.redeamerica.repository.MembershipRequestRepository;
import com.example.redeamerica.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class MembershipRequestService {

    @Autowired
    private MembershipRequestRepository membershipRequestRepository;

    @Autowired
    private UserRepository userRepository;
    @Transactional
    public MembershipRequestEntity solicitarMembresia(MembershipRequestDTO membershipRequestDTO) {
        // Obtener la autenticación del contexto de seguridad
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Verificar si la autenticación es válida y si el principal es una instancia de UserDetails
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            // Obtener detalles del usuario autenticado
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();

            // Buscar al usuario por correo electrónico en la base de datos
            Optional<UserEntity> userFound = userRepository.findByEmail(username);

            // Verificar si se encontró al usuario
            if (userFound.isPresent()) {
                // Crear la solicitud de membresía con los datos proporcionados
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

                // Guardar la solicitud de membresía en la base de datos
                return membershipRequestRepository.save(request);
            } else {
                // Lanzar una excepción si el usuario no se encuentra
                throw new IllegalArgumentException("Usuario no encontrado");
            }
        }

        // Lanzar una excepción si hay un error al hacer la postulación
        throw new IllegalArgumentException("Hubo un error al hacer la postulación");
    }
    // Método para aprobar una solicitud de membresía
    public void aprobarSolicitudMembresia(Long requestId) {
        // Obtener la solicitud de membresía por ID
        Optional<MembershipRequestEntity> requestOptional = membershipRequestRepository.findById(requestId);

        if (requestOptional.isPresent()) {
            // Obtener la solicitud de membresía
            MembershipRequestEntity request = requestOptional.get();

            // Verificar si la solicitud está pendiente
            if (request.getRequestStatus() == ERequestStatus.PENDIENTE) {
                // Actualizar el estado de la solicitud a APROBADA
                request.setRequestStatus(ERequestStatus.APROBADO);
                membershipRequestRepository.save(request);
            } else {
                // Lanzar una excepción si la solicitud no está pendiente
                throw new IllegalArgumentException("La solicitud no está pendiente y no puede ser aprobada.");
            }
        } else {
            // Lanzar una excepción si la solicitud no se encuentra
            throw new IllegalArgumentException("Solicitud no encontrada con ID: " + requestId);
        }
    }
    @Transactional
    // Método para rechazar una solicitud de membresía
    public void rechazarSolicitudMembresia(Long requestId) {
        // Obtener la solicitud de membresía por ID
        Optional<MembershipRequestEntity> requestOptional = membershipRequestRepository.findById(requestId);

        if (requestOptional.isPresent()) {
            // Obtener la solicitud de membresía
            MembershipRequestEntity request = requestOptional.get();

            // Verificar si la solicitud está pendiente
            if (request.getRequestStatus() == ERequestStatus.PENDIENTE) {
                // Actualizar el estado de la solicitud a RECHAZADA
                request.setRequestStatus(ERequestStatus.RECHAZADO);
                membershipRequestRepository.save(request);
            } else {
                // Lanzar una excepción si la solicitud no está pendiente
                throw new IllegalArgumentException("La solicitud no está pendiente y no puede ser rechazada.");
            }
        } else {
            // Lanzar una excepción si la solicitud no se encuentra
            throw new IllegalArgumentException("Solicitud no encontrada con ID: " + requestId);
        }
    }
}


