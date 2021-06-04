package com.example.demodistrict.service;

import com.example.demodistrict.dto.StreetDTO;
import com.example.demodistrict.entity.District;
import com.example.demodistrict.entity.Street;
import com.example.demodistrict.repository.DistrictRepository;
import com.example.demodistrict.repository.StreetRepository;
import com.example.demodistrict.util.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StreetService {
    @Autowired
    private StreetRepository streetRepository;

    @Autowired
    private DistrictRepository districtRepository;


    public StreetDTO createStreet(StreetDTO streetDto) {
        Optional<District> districtOptional = districtRepository.findById(streetDto.getDistrictId());
        District currentDistrict = districtOptional.orElse(null);
        if(currentDistrict == null) {
            return null;
        }

        Street street = ConvertUtil.convertStreetDTOtoStreet(streetDto, currentDistrict);
        Street saved = streetRepository.save(street);
        if(saved == null) {
            return null;
        }
        //covert to dto to return
        return new StreetDTO(saved);
    }

    public List<StreetDTO> listAll() {
        List<Street> all = streetRepository.findAll();
        //covert to dto
        return all.stream().map(item -> new StreetDTO(item)).collect(Collectors.toList());
    }

    public List<StreetDTO> filterByNameAndDistrict(String name, int district) {
        List<Street> streets = streetRepository.filterStreet(name, district);
        return streets.stream().map(item -> new StreetDTO(item)).collect(Collectors.toList());
    }
}