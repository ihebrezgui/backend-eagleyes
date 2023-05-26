package com.telcotec.eagleye.service.classes;

import com.telcotec.eagleye.dao.entities.CsvFile;
import com.telcotec.eagleye.service.interfaces.ICsvfileService;
import org.springframework.stereotype.Service;

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
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public List<CsvFile> csvToBean(InputStream inputStream) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
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
            csvData.setLocalCellId(String.valueOf(values[4]));
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
        return csvDataList;
    }

    public Date parseDate(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return new Date(dateFormat.parse(dateString).getTime());
    }
}
