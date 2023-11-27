package com.example.redeamerica.controller;

import com.example.redeamerica.model.MembershipRequestEntity;
import com.example.redeamerica.service.MembershipManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class MembershipManagementController {

    @Autowired
    MembershipManagementService membershipManagementService;

    @GetMapping
    public ResponseEntity<ArrayList<MembershipRequestEntity>> getAllMembershipRequests(){
        ArrayList<MembershipRequestEntity> requestList = membershipManagementService.getAllMembershipRequests();
        return ResponseEntity.status(HttpStatus.OK).body(requestList);
    }

    @PutMapping("approve/{requestId}")
    public ResponseEntity<?> approveMembershipRequest(@PathVariable Long requestId) {
        try {
            String response = membershipManagementService.approveMembershipRequest(requestId);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PutMapping("decline/{requestId}")
    public ResponseEntity<?> declineMembershipRequest(@PathVariable Long requestId) {
        try {
            String response = membershipManagementService.declineMembershipRequest(requestId);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
