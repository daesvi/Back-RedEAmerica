package com.example.redeamerica.controller;

import com.example.redeamerica.dto.MembershipRequestDTO;
import com.example.redeamerica.dto.PostDTO;
import com.example.redeamerica.model.MembershipRequestEntity;
import com.example.redeamerica.model.PostEntity;
import com.example.redeamerica.service.MembershipRequestService;
import com.example.redeamerica.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/membership")
public class MembershipController {

    @Autowired
     MembershipRequestService membershipRequestService;

    // Crear solicitud de membresía
    @PostMapping(value = "solicitar")
    public ResponseEntity<?> solicitarMembresia(@RequestBody MembershipRequestDTO membershipRequestDTO) {
        try {
            MembershipRequestEntity  membershipsolicitar= membershipRequestService.solicitarMembresia(membershipRequestDTO);
            return ResponseEntity.status(HttpStatus.OK).body( membershipsolicitar);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }  }  }




