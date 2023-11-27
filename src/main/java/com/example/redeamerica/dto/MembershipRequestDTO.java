package com.example.redeamerica.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MembershipRequestDTO {

    private String address;
    private String identificationType;
    private String identificationNumber;
    private String urlIdentificationScan;
    private String educationLevel;
    private String urlEducationCertificate;
}
