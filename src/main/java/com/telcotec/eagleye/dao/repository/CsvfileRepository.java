package com.telcotec.eagleye.dao.repository;


import com.telcotec.eagleye.dao.entities.CsvFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CsvfileRepository extends JpaRepository<CsvFile, Long> {
}
