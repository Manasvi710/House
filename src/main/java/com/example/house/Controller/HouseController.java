package com.example.house.Controller;
import com.example.house.Model.House;
import com.example.house.Model.ResponseDTO;
import com.example.house.Service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/house")
public class HouseController {
    @Autowired
    HouseService houseService;
    @PostMapping("/add")
    public ResponseEntity<ResponseDTO>addRecode(@RequestBody List<House> houses) {
       return new ResponseEntity<>(houseService.saveAll(houses), HttpStatus.ACCEPTED);
    }
    @GetMapping("/avg-price")
    public double avgPrice(){
        return houseService.getAvgPrice();
    }
    @GetMapping("/per-location")
    public List<Object[]> avgPerLocation(){
        return houseService.getAvgperLocation();
    }
    @GetMapping("/max")
    public double MaxPrice(){
        return houseService.getMaxPrice();
    }
    @GetMapping("/min")
    public double MinPrice(){
        return houseService.getMinPrice();
    }

    @GetMapping("/by-location/{location}")
    public double getavgbylocation(@PathVariable String location){
        return houseService.getAvgByLocation(location);
    }
}
