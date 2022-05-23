package com.test.demo.productdata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDataResponse {
    ProductDataRequest dataRequest;
    String message;
}
