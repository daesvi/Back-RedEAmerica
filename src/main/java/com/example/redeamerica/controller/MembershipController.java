package com.example.redeamerica.controller;

import com.example.redeamerica.dto.MembershipRequestDTO;
import com.example.redeamerica.model.MembershipRequestEntity;
import com.example.redeamerica.service.MembershipRequestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/membership")
@Validated
public class MembershipController {

    private final MembershipRequestService membershipRequestService;

    @Autowired
    public MembershipController(MembershipRequestService membershipRequestService) {
        this.membershipRequestService = membershipRequestService;
    }

    @PostMapping("/solicitar")
    public ResponseEntity<?> solicitarMembresia(@Valid @RequestBody MembershipRequestDTO membershipRequestDTO) {
        try {
            MembershipRequestEntity membershipRequestEntity = membershipRequestService.solicitarMembresia(membershipRequestDTO);
            MembershipRequestDTO responseDTO = new MembershipRequestDTO(membershipRequestEntity);
            return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PostMapping("/aprobar/{requestId}")
    public ResponseEntity<?> aprobarSolicitudMembresia(@PathVariable Long requestId) {
        try {
            membershipRequestService.aprobarSolicitudMembresia(requestId);
            return ResponseEntity.status(HttpStatus.OK).body("Solicitud aprobada con éxito");
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PostMapping("/rechazar/{requestId}")
    public ResponseEntity<?> rechazarSolicitudMembresia(@PathVariable Long requestId) {
        try {
            membershipRequestService.rechazarSolicitudMembresia(requestId);
            return ResponseEntity.status(HttpStatus.OK).body("Solicitud rechazada con éxito");
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
