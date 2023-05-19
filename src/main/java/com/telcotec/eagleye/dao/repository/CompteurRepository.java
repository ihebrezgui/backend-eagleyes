package com.telcotec.eagleye.dao.repository;

import com.telcotec.eagleye.dao.entities.Compteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteurRepository extends JpaRepository<Compteur,Integer> {

}
