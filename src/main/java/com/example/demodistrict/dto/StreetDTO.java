package com.example.demodistrict.dto;
import com.example.demodistrict.entity.Street;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@ToString
@NoArgsConstructor
public class StreetDTO {
    private int id;
    private String name;
    private String description;
    private Date inauguratedAt;
    private int status;
    private int districtId;
    public StreetDTO(Street street) {
        this.id = street.getId();
        this.description = street.getDescription();
        this.inauguratedAt = street.getInauguratedAt();
        this.status = street.getStatus();
        this.name = street.getName();
        if(street.getDistrict() != null) {
            this.districtId = street.getDistrict().getId();
        }
    }

}