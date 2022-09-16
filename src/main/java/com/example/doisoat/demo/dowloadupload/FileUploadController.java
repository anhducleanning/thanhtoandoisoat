package com.example.doisoat.demo.dowloadupload;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileUploadController {

    @PostMapping("/uploadFile")
    public ResponseEntity<FileUploadResponse> uploadFile(
            @RequestParam("fileAtomi") MultipartFile fileAtomi,
            @RequestParam("fileImedia1") MultipartFile fileImedia1 ,
            @RequestParam("fileImedia2") MultipartFile fileImedia2)
            throws IOException {

        String fileName = StringUtils.cleanPath(fileAtomi.getOriginalFilename());
        String fileName1 = StringUtils.cleanPath(fileImedia1.getOriginalFilename());
        String fileName2 = StringUtils.cleanPath(fileImedia2.getOriginalFilename());
        long size = fileAtomi.getSize();

        String filecode = FileUploadUtil.saveFile(fileName, fileAtomi);
        System.out.println(filecode);
        FileUploadResponse response = new FileUploadResponse();
        response.setFileName(fileName);
        response.setSize(size);
        response.setDownloadUri("/downloadFile/" + filecode);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
