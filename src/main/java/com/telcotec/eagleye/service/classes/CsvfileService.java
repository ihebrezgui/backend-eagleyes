    package com.telcotec.eagleye.service.classes;
    
    import com.telcotec.eagleye.dao.entities.CsvFile;
    import com.telcotec.eagleye.dao.helper.Helper;
    import com.telcotec.eagleye.dao.repository.CsvfileRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import org.springframework.web.multipart.MultipartFile;
    
    import java.io.IOException;
    import java.util.List;
    
    
    
    @Service
    public class CsvfileService {
        
    
    
        @Autowired
        private CsvfileRepository csvfileRepository;
        public CsvfileService() {
        }
    
        public void save(MultipartFile file) {
            try {
                List<CsvFile> products = Helper.convertExcelToListOfCSV(file.getInputStream());
                this.csvfileRepository.saveAll(products);
            } catch (IOException var3) {
                var3.printStackTrace();
            }
    
        }
    
    
    
        public List<CsvFile> getAllProducts() {
            return this.csvfileRepository.findAll();
        }
    
    }
