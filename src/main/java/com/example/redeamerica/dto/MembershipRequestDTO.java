package com.example.redeamerica.dto;

import com.example.redeamerica.model.MembershipRequestEntity;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MembershipRequestDTO {
    private String address;
    private String identificationType;
    private String identificationNumber;
    private String urlIdentificationScan;
    private String educationLevel;
    private String urlEducationCertificate;

    public MembershipRequestDTO(MembershipRequestEntity membershipsolicitar) {
    }
}


