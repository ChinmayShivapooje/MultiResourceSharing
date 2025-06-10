package com.chinmay.Resource_Sharing.Controller;

import com.chinmay.Resource_Sharing.Entity.UploadEntity;
import com.chinmay.Resource_Sharing.Service.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/view")
public class ViewControlelr {
   @Autowired
    Upload service;

    @GetMapping("/show")
    public ResponseEntity<List<UploadEntity>> getData(){


     List<UploadEntity> l=   service.getAllData();


        return new ResponseEntity<>(l, HttpStatus.OK);
    }
}
