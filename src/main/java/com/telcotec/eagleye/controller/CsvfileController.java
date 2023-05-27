package com.telcotec.eagleye.controller;


import com.telcotec.eagleye.dao.entities.CsvFile;
import com.telcotec.eagleye.dao.repository.CsvfileRepository;
import com.telcotec.eagleye.service.interfaces.ICsvfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/CSV")
public class CsvfileController {
    @Autowired
    private CsvfileRepository csvRepository;

    @Autowired
    private ICsvfileService csvService;

    @PostMapping("/upload")
    public String uploadCsv(@RequestParam("file") MultipartFile file) {
        try {
            List<CsvFile> csvDataList = csvService.excelToBean(file);
            csvRepository.saveAll(csvDataList);
            return "CSV data saved successfully";
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return "Error occurred while uploading CSV file";
        }
    }
}
