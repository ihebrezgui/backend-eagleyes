package com.telcotec.eagleye.dao.helper;

import com.telcotec.eagleye.dao.entities.CsvFile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Helper {
    public  Helper(){
        
    }
    public static boolean checkExcelFormat(MultipartFile file) {
        return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet".equals(file.getContentType());

    }
    public static List<CsvFile> convertExcelToListOfCSV(InputStream is) {
        List<CsvFile> list = new ArrayList();

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheet("data");
            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();

            while(true) {
                while(iterator.hasNext()) {
                    Row row = (Row)iterator.next();
                    if (rowNumber == 0) {
                        ++rowNumber;
                    } else {
                        Iterator<Cell> cells = row.iterator();
                        int cid = 0;

                        CsvFile p;
                        for(p = new CsvFile(); cells.hasNext(); ++cid) {
                            Cell cell = (Cell)cells.next();
                            switch (cid) {
                                case 0:
                                    p.setDate((Date) cell.getDateCellValue());
                                    break;
                                case 1:
                                    p.setENodeBName(cell.getStringCellValue());
                                    break;
                                case 2:
                                    p.setCellFDDTDDIndication(cell.getStringCellValue());
                                    break;
                                case 3:
                                    p.setCellName((cell.getStringCellValue()));
                                    break;
                                case 4:
                                    p.setRRCConnectionSuccess((cell.getStringCellValue()));
                                    break;
                                case 5:
                                    p.setERAbAbnormalRelease((cell.getStringCellValue()));
                                    break;
                                case 6:
                                    p.setERAbRelease((cell.getStringCellValue()));
                                    break;
                                case 7:
                                    p.setIntraFreqSuccess((cell.getStringCellValue()));
                                    break;
                                case 8:
                                    p.setIntraFreqAttempt((cell.getStringCellValue()));
                                    break;
                                case 9:
                                    p.setCellTrafficVolume((cell.getStringCellValue()));
                                    break;

                                case 10:
                                    p.setCellTransferTime((cell.getStringCellValue()));
                                    break;

                                case 11:
                                    p.setAvgUserNum((cell.getStringCellValue()));
                                    break;   
                            }
                        }

                        list.add(p);
                    }
                }

                return list;
            }
        } catch (Exception var11) {
            var11.printStackTrace();
            return list;
        }
    }
}
