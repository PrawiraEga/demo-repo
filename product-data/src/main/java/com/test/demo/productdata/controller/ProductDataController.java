package com.test.demo.productdata.controller;

import com.test.demo.productdata.dto.ProductDataRequest;
import com.test.demo.productdata.dto.ProductDataResponse;
import com.test.demo.productdata.entity.ProductDataEntity;
import com.test.demo.productdata.service.ProductDataService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class ProductDataController {
    protected final Log log = LogFactory.getLog(getClass());

    @Autowired
    private ProductDataService productDataService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDataResponse> addProduct(@RequestBody ProductDataRequest request,
                                                          HttpServletRequest httpRequest) throws Exception {
//        request.setFile(file);
        log.info("Hit On: " + httpRequest.getRequestURI());
        return new ResponseEntity<ProductDataResponse>(productDataService.addProduct(request), HttpStatus.OK);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDataResponse> editProduct(@PathVariable int id,
                                                           @RequestBody ProductDataRequest request,
                                                           HttpServletRequest httpRequest
                                                           ) throws Exception {
        log.info("Hit On: " + httpRequest.getRequestURI());
        request.setId(id);
        return new ResponseEntity<ProductDataResponse>(productDataService.editData(request), HttpStatus.OK);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<ProductDataEntity>> getAllProduct(HttpServletRequest httpRequest) {
        log.info("Hit On: " + httpRequest.getRequestURI());
        return new ResponseEntity<List<ProductDataEntity>>(productDataService.getAllProduct(), HttpStatus.OK);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDataResponse> getById(@PathVariable int id,
                                                       HttpServletRequest httpRequest) throws Exception {
        log.info("Hit On: " + httpRequest.getRequestURI());
        return new ResponseEntity<ProductDataResponse>(productDataService.getByProductId(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ProductDataResponse> softDelete(@PathVariable int id, HttpServletRequest httpRequest) throws Exception {
        log.info("Hit On: " + httpRequest.getRequestURI());
        return new ResponseEntity<ProductDataResponse>(productDataService.softDeleteProduct(id), HttpStatus.OK);
    }

}
