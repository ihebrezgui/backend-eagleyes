package com.telcotec.eagleye.controller;
import com.telcotec.eagleye.dao.repository.CsvfileRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CsvController {
    private CsvfileRepository cellDataRepository;


    @PostMapping("/convert")
    public List<List<String>> convertCSV(@RequestParam("file") MultipartFile file) {
        List<List<String>> outputData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] rowData = line.split(",", -1); // Split each line by comma
                List<String> row = new ArrayList<>();

                for (String cellData : rowData) {
                    row.add(StringUtils.hasText(cellData) ? cellData : ""); // Add data to row, handling empty cells
                }

                outputData.add(row); // Add the row to the output data
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputData;
    }
}
