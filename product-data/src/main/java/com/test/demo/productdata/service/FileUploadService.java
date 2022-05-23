package com.test.demo.productdata.service;

import com.test.demo.productdata.util.FileUploadUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class FileUploadService {

    protected final Log log = LogFactory.getLog(getClass());

    public String uploadFile(MultipartFile file) throws Exception {
        String response = null;
        if (!file.isEmpty()) {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            FileUploadUtil.saveFile(fileName, file);
            file.transferTo(new File(
                    "C:\\Users\\Lenovo\\Documents\\EP\\NILA\\Mulai\\product-data\\src\\main\\java\\com\\test\\demo\\productdata\\stores-file"
                            + fileName)); // adjust to your local path

            response = fileName;
            log.info( fileName + " Successful Added");
        }
        return response;
    }
}
