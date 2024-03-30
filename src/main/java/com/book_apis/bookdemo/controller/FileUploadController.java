package com.book_apis.bookdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.book_apis.bookdemo.helper.FileUploadHelper;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class FileUploadController {
@Autowired
public FileUploadHelper fileUploadHelper;

    @PostMapping("/upload-file") 
    public ResponseEntity<String> getMethod(@RequestParam("file") MultipartFile file){

        System.out.println(file.getSize());
        System.out.println(file.getName());


        try{
        if(file.isEmpty()){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request file is empty");
        }
        if(!file.getContentType().equals("image/png")){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("image format is wrong");
        }


      boolean f=  fileUploadHelper.uploadfile(file);
      if(f){
        return ResponseEntity.ok("file uploaded successfully");
      }

    }catch(Exception e){
        e.printStackTrace();
    }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
    }
    
}
