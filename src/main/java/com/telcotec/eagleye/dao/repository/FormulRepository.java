package com.telcotec.eagleye.dao.repository;

import com.telcotec.eagleye.dao.entities.Compteur;
import com.telcotec.eagleye.dao.entities.Formule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormulRepository extends JpaRepository<Formule,Integer> {
    
}
