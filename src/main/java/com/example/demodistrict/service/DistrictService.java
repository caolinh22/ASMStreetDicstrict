package com.example.demodistrict.service;

import com.example.demodistrict.dto.DistrictDTO;
import com.example.demodistrict.entity.District;
import com.example.demodistrict.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    public List<DistrictDTO> listAll() {
        List<District> all = districtRepository.findAll();
        return all.stream().map(item -> new DistrictDTO(item)).collect(Collectors.toList());
    }
}
