package com.example.house.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "houseno")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    private int bedrooms;
    private int bathrooms;
    private double squareFootage;
    private String location;
    private int salePrice;
}
