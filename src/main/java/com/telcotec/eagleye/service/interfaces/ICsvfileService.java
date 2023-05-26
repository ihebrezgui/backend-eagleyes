package com.telcotec.eagleye.service.interfaces;


import com.telcotec.eagleye.dao.entities.CsvFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;

public interface ICsvfileService {
    List<CsvFile> csvToBean(InputStream inputStream) throws IOException, ParseException;


}
