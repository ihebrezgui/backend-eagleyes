package com.telcotec.eagleye.service.classes;

import com.telcotec.eagleye.dao.entities.CsvFile;
import com.telcotec.eagleye.dao.repository.CsvfileRepository;
import com.telcotec.eagleye.service.interfaces.ICsvfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



@Service
class CsvfileService implements ICsvfileService {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd");


    @Autowired
    private CsvfileRepository csvfileRepository;



    public Date parseDate(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return new Date(dateFormat.parse(dateString).getTime());
    }

    @Override
    public List<CsvFile> excelToBean(MultipartFile file) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(InputStream.nullInputStream()));
        List<CsvFile> csvDataList = new ArrayList<>();
        String line;
        int lineCount = 0; // Keep track of the line number for error reporting
        while ((line = br.readLine()) != null) {
            lineCount++;
            String[] values = line.split(",");
            if (values.length != 14) {
                throw new IllegalArgumentException("Invalid number of columns at line " + lineCount);
            }
            CsvFile csvData = new CsvFile();
            csvData.setENodeBName(String.valueOf(values[1]));
            csvData.setCellFDDTDDIndication(String.valueOf(values[2]));
            csvData.setCellName(String.valueOf(values[3]));
            csvData.setRRCConnectionSuccess(String.valueOf(values[5]));
            csvData.setRRCConnectionAttempt(String.valueOf(values[6]));
            csvData.setERAbAbnormalRelease(String.valueOf(values[7]));
            csvData.setERAbRelease(String.valueOf(values[8]));
            csvData.setIntraFreqSuccess(String.valueOf(values[9]));
            csvData.setIntraFreqAttempt(String.valueOf(values[10]));
            csvData.setCellTrafficVolume(String.valueOf(values[11]));
            csvData.setCellTransferTime(String.valueOf(values[12]));
            csvData.setAvgUserNum(String.valueOf(values[13]));

            csvDataList.add(csvData);
        }
        csvfileRepository.saveAll(csvDataList);

        return csvDataList;
    }
}
