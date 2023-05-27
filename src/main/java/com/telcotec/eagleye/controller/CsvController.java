package com.telcotec.eagleye.controller;

import com.telcotec.eagleye.dao.entities.CsvFile;
import com.telcotec.eagleye.dao.helper.Helper;
import com.telcotec.eagleye.service.classes.CsvfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.util.Map;

import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CsvController {
    @Autowired
    private CsvfileService Csvfileservice;
    public CsvController() {
    }
    @PostMapping({"/product/upload"})
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        if (Helper.checkExcelFormat(file)) {
            this.Csvfileservice.save(file);
            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
        }
    }

    @GetMapping({"/product"})
    public List<CsvFile> getAllProduct() {
        return this.Csvfileservice.getAllProducts();
    }
    
}
