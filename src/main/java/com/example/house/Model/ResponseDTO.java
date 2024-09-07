package com.example.house.Model;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class ResponseDTO {
    private List<House> body;
    private String message;
    private String errorMessage;
    private HttpStatus status;

}
