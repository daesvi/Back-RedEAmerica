package com.example.redeamerica.controller;

import com.example.redeamerica.dto.MembershipRequestDTO;
import com.example.redeamerica.model.MembershipRequestEntity;
import com.example.redeamerica.service.MembershipRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/membership")
@RequiredArgsConstructor
public class MembershipController {

    @Autowired
    MembershipRequestService membershipRequestService;

    @PostMapping
    public ResponseEntity<?> requestMembership(@RequestBody MembershipRequestDTO membershipRequestDTO) {
        try {
            MembershipRequestEntity membershipRequestEntity = membershipRequestService.requestMembership(membershipRequestDTO);
            return ResponseEntity.status(HttpStatus.OK).body(membershipRequestEntity);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
