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

    //    @Autowired
//    public ModelMapper modelMapper;
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


//    public ResponseDTO getAverageSalePrice() {
//        ResponseDTO rs = new ResponseDTO();
//        try {
//            House averagePrice = houseRepository.getAverageSalePrice();
//            List<House> averagePriceList = new ArrayList<>();
//            averagePriceList.add(averagePrice);
//            rs.setBody(averagePriceList);
//            rs.setMessage("price set successfully");
//            rs.setStatus(HttpStatus.OK);
//            rs.setErrorMessage(null);
//        } catch (Exception e) {
//            rs.setBody(null);
//            rs.setMessage("price is not set successfully");
//            rs.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
//            rs.setErrorMessage(e.getMessage());
//        }
//        return rs;
//    }
//
//        public ResponseDTO getAverageSalePriceperLocation(){
//        ResponseDTO rs=new ResponseDTO();
//        try {
//            House salePrice= (House) houseRepository.getAverageSalePricePerLocation();
//            List<House> salePriceList=new ArrayList<>();
//            salePriceList.add(salePrice);
//            rs.setBody(salePriceList);
//            rs.setMessage("price set successfully");
//            rs.setStatus(HttpStatus.OK);
//            rs.setErrorMessage(null);
//        }catch (Exception e){
//            rs.setBody(null);
//            rs.setMessage("price is not set successfully");
//            rs.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
//            rs.setErrorMessage(e.getMessage());
//        }
//        return rs;
//    }
//    public ResponseDTO getMaxSalePrice() {
//        ResponseDTO rs = new ResponseDTO();
//        try {
//            House maxSalePrice = houseRepository.getMaxSalePrice();
//            List<House> maxSalePriceList = new ArrayList<>();
//            maxSalePriceList.add(maxSalePrice);
//            rs.setBody(maxSalePriceList);
//            rs.setMessage("price set successfully");
//            rs.setStatus(HttpStatus.OK);
//            rs.setErrorMessage(null);
//        } catch (Exception e) {
//            rs.setBody(null);
//            rs.setMessage("price is not set successfully");
//            rs.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
//            rs.setErrorMessage(e.getMessage());
//        }
//        return rs;
//    }
//
//    public ResponseDTO getMinSalePrice() {
//        ResponseDTO rs = new ResponseDTO();
//        try {
//            House minSalePrice = houseRepository.getMinSalePrice();
//            List<House> minSalePriceList = new ArrayList<>();
//            minSalePriceList.add(minSalePrice);
//            rs.setBody(minSalePriceList);
//            rs.setMessage("price set successfully");
//            rs.setStatus(HttpStatus.OK);
//            rs.setErrorMessage(null);
//        } catch (Exception e) {
//            rs.setBody(null);
//            rs.setMessage("price is not set successfully");
//            rs.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
//            rs.setErrorMessage(e.getMessage());
//        }
//        return rs;
//    }
//    public List<House> save(List<House> houses){
//        return houseRepository.saveAll(houses);
//    }
}

