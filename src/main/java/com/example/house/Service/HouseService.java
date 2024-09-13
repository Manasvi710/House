package com.example.house.Service;
import com.example.house.Model.House;
import com.example.house.Model.ResponseDTO;
import com.example.house.Repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {
    @Autowired
    HouseRepository houseRepository;

    public ResponseDTO saveAll(List<House> houses) {
        ResponseDTO rs = new ResponseDTO();
        try {
            List<House> h = houseRepository.saveAll(houses);
            rs.setBody(h);
            rs.setMessage("data is added....");
            rs.setStatus(HttpStatus.OK);
            rs.setErrorMessage(null);
        } catch (Exception e) {
            rs.setBody(null);
            rs.setMessage("price is not set successfully");
            rs.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            rs.setErrorMessage(e.getMessage());
        }
        return rs;
    }
    public double getAvgPrice(){
        return houseRepository.getAverageSalePrice();
    }
    public List<Object[]> getAvgperLocation(){
        return houseRepository.getAverageSalePricePerLocation();
    }
    public double getMaxPrice(){
        return houseRepository.getMaxSalePrice();
    }
    public double getMinPrice(){
        return houseRepository.getMinSalePrice();
    }
    public double getAvgByLocation(String location){
        return houseRepository.getavgbyLocation(location);
    }

}

