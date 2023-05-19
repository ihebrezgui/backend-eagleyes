package com.telcotec.eagleye.dao.repository;

import com.telcotec.eagleye.dao.entities.KPI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KPIRepository extends JpaRepository<KPI, Integer> {

}
