package com.example.redeamerica.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "posts")
public class PostEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userEntityId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Content is required")
    private String content;

    @NotBlank(message = "Media URL is required")
    private String mediaUrl;

    @Enumerated(EnumType.STRING)
    private ECategory category;

    private LocalDateTime timestamp;

    @NotBlank(message = "Country is required")
    private String country;
}
