package com.example.redeamerica.controller;

import com.example.redeamerica.dto.MembershipRequestDTO;
import com.example.redeamerica.model.MembershipRequestEntity;
import com.example.redeamerica.model.UserEntity;
import com.example.redeamerica.service.MembershipRequestService;
import com.example.redeamerica.service.MembresiaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/membership")
public class MembershipController {
    @Autowired
    private MembershipRequestService membershipRequestService;

    // Crear solicitud de membresía
    @PostMapping("/solicitar")
    public ResponseEntity<?> solicitarMembresia(@RequestBody MembershipRequestDTO membershipRequestDTO) {
        try {

            return ResponseEntity.ok(membershipRequestService.solicitarMembresia(membershipRequestDTO));
        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir durante la solicitud de membresía
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage ()  );
        }


    }

    // Obtener información de membresía para un usuario específico
    @GetMapping("/obtener/{userId}")
    public ResponseEntity<MembershipRequestDTO> obtenerMembresia(@PathVariable Long userId) throws MembresiaNotFoundException {
        try {
            MembershipRequestDTO membresia = membershipRequestService.obtenerMembresia(userId);
            return ResponseEntity.ok(membresia);
        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir durante la obtención de información de membresía
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    // Actualizar información de membresía para un usuario específico
    @PutMapping("/actualizar/{userId}")
    public ResponseEntity<String> actualizarMembresia(@PathVariable Long userId, @RequestBody MembershipRequestDTO requestDTO) {
        try {
            membershipRequestService.actualizarMembresia(userId, requestDTO.getAddress(),
                    requestDTO.getIdentificationType(),
                    requestDTO.getIdentificationNumber(),
                    requestDTO.getUrlIdentificationScan(),
                    requestDTO.getEducationLevel(),
                    requestDTO.getUrlEducationCertificate());

            return ResponseEntity.ok("Información de membresía actualizada correctamente");
        } catch (MembresiaNotFoundException e) {
            // Manejar el caso cuando la membresía no existe para el usuario dado
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró la membresía para el usuario con ID: " + userId);
        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir durante la actualización de información de membresía
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar la información de membresía");
        }
    }

    // Eliminar membresía para un usuario específico
    @DeleteMapping("/eliminar/{userId}")
    public ResponseEntity<String> eliminarMembresia(@PathVariable Long userId) {
        try {
            membershipRequestService.eliminarMembresia(userId);
            return ResponseEntity.ok("Membresía eliminada correctamente");
        } catch (MembresiaNotFoundException e) {
            // Manejar el caso cuando la membresía no existe para el usuario dado
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró la membresía para el usuario con ID: " + userId);
        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir durante la eliminación de membresía
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar la membresía");
        }
    }
}


