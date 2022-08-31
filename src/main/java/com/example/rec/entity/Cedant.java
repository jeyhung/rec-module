package com.example.rec.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cedants")
public class Cedant {
    @Id
    private String id;
    private String countryId;
    private String currencyId;
    private String groupCedantId;
    private String regionId;
    private String reinsuranceId;
    private String typeCedantId;
    private int benefitPercentage;
    private String code;
    private String color1;
    private String color2;
    private String contact;
    private String email;
    private String estimationType;
    private String logo;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
