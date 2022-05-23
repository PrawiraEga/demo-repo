package com.test.demo.productdata.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize
public class ProductDataRequest {
    private int id;
    private String name;
    private String qty;
    private String picture;
    private String expiredAt;
    private String isActive;
}
