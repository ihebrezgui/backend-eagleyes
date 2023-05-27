package com.telcotec.eagleye.dao.helper;

import com.telcotec.eagleye.dao.entities.CsvFile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.Console;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Helper {
    public  Helper(){
        
    }
    public static boolean checkExcelFormat(MultipartFile file) {
        return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet".equals(file.getContentType());

    }
    public static List<CsvFile> convertExcelToListOfCSV(InputStream is) {
        List<CsvFile> list = new ArrayList<>();

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {
                Row row = iterator.next();
                if (rowNumber == 0) {
                    rowNumber++;
                } else {
                    Iterator<Cell> cells = row.iterator();
                    int cid = 0;
                    CsvFile p = new CsvFile();

                    while (cells.hasNext()) {
                        Cell cell = cells.next();
                        switch (cid) {
                            case 0:
                                if (cell.getCellType() == CellType.NUMERIC) {
                                    p.setDate(cell.getDateCellValue());
                                }
                                break;
                            case 1:
                                if (cell.getCellType() == CellType.STRING) {
                                    p.setENodeBName(cell.getStringCellValue());
                                }
                                break;
                            case 2:
                                if (cell.getCellType() == CellType.STRING) {
                                    p.setCellFDDTDDIndication(cell.getStringCellValue());
                                }
                                break;
                            case 3:
                                if (cell.getCellType() == CellType.STRING) {
                                    p.setCellName(cell.getStringCellValue());
                                }
                                break;
                            case 4:
                                if (cell.getCellType() == CellType.NUMERIC) {
                                    p.setRRCConnectionSuccess((float) cell.getNumericCellValue());
                                }
                                break;
                            case 5:
                                if (cell.getCellType() == CellType.NUMERIC) {
                                    p.setRRCConnectionAttempt(((float) cell.getNumericCellValue()));
                                }
                                break;
                                
                            case 6:
                                if (cell.getCellType() == CellType.NUMERIC) {
                                    p.setERAbAbnormalRelease((float) cell.getNumericCellValue());
                                }
                                break;
                            case 7:
                                if (cell.getCellType() == CellType.NUMERIC) {
                                    p.setERAbRelease((float) cell.getNumericCellValue());
                                }
                                break;
                            case 8:
                                if (cell.getCellType() == CellType.NUMERIC) {
                                    p.setIntraFreqSuccess((float) cell.getNumericCellValue());
                                }
                                break;
                            case 9:
                                if (cell.getCellType() == CellType.NUMERIC) {
                                    p.setIntraFreqAttempt((float) cell.getNumericCellValue());
                                }
                                break;
                            case 10:
                                if (cell.getCellType() == CellType.NUMERIC) {
                                    p.setCellTrafficVolume((float) cell.getNumericCellValue());
                                }
                                break;
                            case 11:
                                if (cell.getCellType() == CellType.NUMERIC) {
                                    p.setCellTransferTime((float) cell.getNumericCellValue());
                                }
                                break;
                            case 12:
                                if (cell.getCellType() == CellType.NUMERIC) {
                                    p.setAvgUserNum((float) cell.getNumericCellValue());
                                }
                                break;
                            default:
                                break;
                        }
                        cid++;
                    }
                    list.add(p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}
