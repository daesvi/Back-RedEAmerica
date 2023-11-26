package com.example.redeamerica.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "memberships")
public class MembershipRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;

    @NotBlank
    private String address;

    @NotBlank
    @Column(name = "identification_type")
    private String identificationType;

    @NotBlank
    @Column(name = "identification_number")
    private String identificationNumber;

    @NotBlank
    @Column(name = "url_identification_scan")
    private String urlIdentificationScan;

    @NotBlank
    @Column(name = "education_level")
    private String educationLevel;

    @NotBlank
    @Column(name = "url_education_certificate")
    private String urlEducationCertificate;

    @Enumerated(EnumType.STRING)
    @NotBlank
    @Column(name = "request_status")
    @Enumerated(EnumType.STRING)
    private ERequestStatus requestStatus;

}
