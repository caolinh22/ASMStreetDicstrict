package com.example.demodistrict.controller;

import com.example.demodistrict.entity.District;
import com.example.demodistrict.entity.Street;
import com.example.demodistrict.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping(value = "/seed/generate")
public class SeedController {
    @Autowired
    private DistrictRepository districtRepository;

    private static ArrayList<District> listDistrict = new ArrayList<>();
    @RequestMapping(method = RequestMethod.GET)
    public String Seeding() {
        districtRepository.deleteAll();

        District district1 = new District("Hoang Mai");
        district1.addStreet(new Street("Nguyen Canh Di", "Home Address", new Date(), 1, district1));
        district1.addStreet(new Street("Linh Dam", "Linh Dam", new Date(), 1, district1));
        listDistrict.add(district1);
        District district2 = new District("Cau Giay");
        district2.addStreet(new Street("Ton That Thuyet", "FPT Aptech", new Date(), 1, district2));
        district2.addStreet(new Street("Trung Kinh", "Company Address", new Date(), 2, district2));
        listDistrict.add(district2);
        District district3 = new District("Hai Ba Trung");
        district3.addStreet(new Street("Tran Dai Nghia", "HUST", new Date(), 1, district3));
        district3.addStreet(new Street("Trai Ca", "A Dai", new Date(), 2, district3));
        listDistrict.add(district3);
        District district4 = new District("Long Bien");
        district4.addStreet(new Street("Co Linh", "Aeon Mall Long Bien", new Date(), 1, district4));
        district4.addStreet(new Street("Nguyen Van Cu", "Way to work", new Date(), 2, district4));
        listDistrict.add(district4);
        District district5 = new District("Ba Dinh");
        district5.addStreet(new Street("Au Co", "Rose Field", new Date(), 1, district5));
        district5.addStreet(new Street("Cua Bac", "Food Tour", new Date(), 2, district5));
        listDistrict.add(district5);
        for (District dis :
                listDistrict) {
            districtRepository.save(dis);
        }
        return "Seeding Done!";
    }}