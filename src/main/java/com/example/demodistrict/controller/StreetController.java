package com.example.demodistrict.controller;

import com.example.demodistrict.dto.StreetDTO;
import com.example.demodistrict.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/street/")
public class StreetController {

    @Autowired
    private StreetService streetService;

    @RequestMapping(method = RequestMethod.POST)
    public StreetDTO createStreet(@RequestBody StreetDTO streetDTO) {
        StreetDTO res = streetService.createStreet(streetDTO);
        if(res == null) {
            return null;
        }
        return res;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<StreetDTO> list() {
        return streetService.listAll();

    }

    @RequestMapping(method = RequestMethod.GET, value = "/filter")
    public List<StreetDTO> filter(@RequestParam(value = "name") String name, @RequestParam(value = "district") int district) {
        return streetService.filterByNameAndDistrict(name, district);

    }
}
