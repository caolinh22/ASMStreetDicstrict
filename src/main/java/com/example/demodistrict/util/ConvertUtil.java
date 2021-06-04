package com.example.demodistrict.util;

import com.example.demodistrict.dto.StreetDTO;
import com.example.demodistrict.entity.District;
import com.example.demodistrict.entity.Street;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertUtil {
    public static Street convertStreetDTOtoStreet(StreetDTO dto, District currentDistrict) {
        Street street  = new Street();
        street.setDescription(dto.getDescription());
        street.setName(dto.getName());
        street.setInauguratedAt(dto.getInauguratedAt());
        street.setStatus(dto.getStatus());
        street.setDistrict(currentDistrict);
        return street;
    }

    public static String convertJavaDateToString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        return dateFormat.format(date);
    }
}
