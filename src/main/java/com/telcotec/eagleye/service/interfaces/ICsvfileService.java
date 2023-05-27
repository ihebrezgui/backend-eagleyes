package com.telcotec.eagleye.service.interfaces;


import com.telcotec.eagleye.dao.entities.CsvFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;

public interface ICsvfileService {
    List<CsvFile> excelToBean(MultipartFile file) throws IOException, ParseException;

}
