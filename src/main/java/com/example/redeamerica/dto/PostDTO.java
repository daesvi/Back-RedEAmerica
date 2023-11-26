package com.example.redeamerica.dto;

import com.example.redeamerica.model.ECategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDTO {

    private String content;
    private String mediaUrl;
    private ECategory category;
    private String country;
}
