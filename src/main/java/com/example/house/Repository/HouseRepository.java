package com.example.house.Repository;

import com.example.house.Model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<House, Integer> {
    @Query(value = "SELECT avg(h.sale_Price) fROM houseno h ",nativeQuery = true)
    double getAverageSalePrice();
    @Query(value = "SELECT h.location as location , avg(sale_Price) as avgPrice from houseno h group by h.location", nativeQuery = true)
    List<Object[]> getAverageSalePricePerLocation();
    @Query(value = "Select max(h.sale_Price) from houseno h",nativeQuery = true)
    double getMaxSalePrice();

    @Query(value = "select min(h.sale_Price) from houseno h", nativeQuery = true)
    double getMinSalePrice();

    @Query(value = "select avg(h.sale_Price) from houseno h where h.location = : location", nativeQuery = true)
    double getavgbyLocation(@Param("location") String location);
}
