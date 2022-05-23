package com.test.demo.productdata.service;

import com.test.demo.productdata.dto.ProductDataRequest;
import com.test.demo.productdata.dto.ProductDataResponse;
import com.test.demo.productdata.entity.ProductDataEntity;
import com.test.demo.productdata.repo.ProductDataRepo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductDataService {

    @Autowired
    private FileUploadService fileUploadService;

    @Autowired
    private ProductDataRepo dataRepo;

    SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd");

    public ProductDataResponse addProduct(ProductDataRequest dataRequest) throws Exception {
        ProductDataResponse response = new ProductDataResponse();
        ProductDataEntity entity = new ProductDataEntity();
        ProductDataRequest requestResp = dataRequest;
//        String fileResponse;
        Date expDate;

        if (requestResp != null) {
            entity.setName(dataRequest.getName());
            entity.setQty(Integer.parseInt(dataRequest.getQty()));
            entity.setIsActive(1);
            entity.setPicture(dataRequest.getPicture());

            expDate = toDate(dataRequest.getExpiredAt());
            entity.setExpiredAt(expDate);
            entity = dataRepo.save(entity);

            requestResp.setId(entity.getId());
            requestResp.setIsActive(Integer.toString(entity.getIsActive()));
            response.setDataRequest(requestResp);
            response.setMessage(dataRequest.getName() + " Successful Added");
        } else {
            throw new Exception();

        }

        try {


            /*if (!dataRequest.getFile().isEmpty()) {
                fileResponse = fileUploadService.uploadFile(dataRequest.getFile());
                entity.setPicture(fileResponse);

                entity = dataRepo.save(entity);
                requestResp.setId(entity.getId());
                response.setDataRequest(requestResp);
                response.setMessage(fileResponse + " Successful Added");
                return response;
            } else {
                response.setDataRequest(requestResp);
                response.setMessage("No File Added");
            }*/

        } catch (Exception e) {
            e.printStackTrace();
            response.setMessage("Data Fail To Save");
        }

        return response;
    }

    public Date toDate(String getDate) throws ParseException {
        Date date;
        date = sdFormatter.parse(getDate);

        return date;
    }

    public ProductDataResponse editData(ProductDataRequest request) throws Exception {
        ProductDataRequest dataRequest = request;
        ProductDataResponse response = new ProductDataResponse();
        ProductDataEntity entity;

        if (dataRequest.getId()>0) {
            entity = dataRepo.findByIdActive(dataRequest.getId());

            entity.setName(dataRequest.getName());
            entity.setPicture(dataRequest.getPicture());
            entity.setQty(Integer.parseInt(dataRequest.getQty()));
            Date expDate = toDate(dataRequest.getExpiredAt());
            entity.setExpiredAt(expDate);
            entity = dataRepo.save(entity);

            response.setDataRequest(dataRequest);
            response.setMessage(dataRequest.getName() + " Updated !");

        } else throw new Exception();

        return response;
    }

    public List<ProductDataEntity> getAllProduct() {
        List<ProductDataEntity> entityList;
        entityList = dataRepo.findAllByActive(1);
        return entityList;
    }

    public ProductDataResponse getByProductId(int id) throws Exception {
        ProductDataResponse response = new ProductDataResponse();
        ProductDataEntity entity;
        ProductDataRequest dataRequest = new ProductDataRequest();

        entity = dataRepo.findByIdActive(id);

        if (entity != null) {
            dataRequest.setId(entity.getId());
            dataRequest.setName(entity.getName());
            dataRequest.setPicture(entity.getPicture());
            dataRequest.setQty(Integer.toString(entity.getQty()));

            String expiredAt =  sdFormatter.format(entity.getExpiredAt());
            dataRequest.setExpiredAt(expiredAt);
            dataRequest.setIsActive(Integer.toString(entity.getIsActive()));

            response.setDataRequest(dataRequest);
            response.setMessage(" Get Product Succesful !");

        } else
            throw new Exception();

        return response;
    }

    public ProductDataResponse softDeleteProduct(int id) throws Exception {
        ProductDataResponse response = new ProductDataResponse();
        ProductDataEntity entity;
        ProductDataRequest dataRequest = new ProductDataRequest();

        try {
            entity = dataRepo.findByIdActive(id);

            entity.setIsActive(0);
            entity = dataRepo.save(entity);

            dataRequest.setId(entity.getId());
            dataRequest.setName(entity.getName());
            dataRequest.setIsActive(Integer.toString(entity.getIsActive()));

            response.setDataRequest(dataRequest);
            response.setMessage(dataRequest.getName() + " Deleted !");

        } catch (Exception e) {
            e.printStackTrace();
            response.setMessage("ID: " + id + " Fail To Delete");
        }

        return response;
    }


}
