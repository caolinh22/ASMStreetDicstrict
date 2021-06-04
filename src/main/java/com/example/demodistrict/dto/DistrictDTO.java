package com.example.demodistrict.dto;

import com.example.demodistrict.entity.District;
import lombok.*;

import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@Setter
@Getter
public class DistrictDTO {
    private int id;
    private String name;
    private Set<StreetDTO> streets;

    public DistrictDTO(District district) {
        this.id = district.getId();
        this.name = district.getName();
        this.streets = district.getStreets().stream().map(item -> new StreetDTO(item)).collect(Collectors.toSet());
    }
}
