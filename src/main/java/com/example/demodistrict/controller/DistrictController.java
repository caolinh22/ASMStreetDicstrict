package com.example.demodistrict.controller;

import com.example.demodistrict.dto.DistrictDTO;
import com.example.demodistrict.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/district")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @RequestMapping(method = RequestMethod.GET)
    public List<DistrictDTO> list() {
        return districtService.listAll();

    }
}