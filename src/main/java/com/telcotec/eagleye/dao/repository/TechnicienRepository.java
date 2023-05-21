package com.telcotec.eagleye.dao.repository;

import com.telcotec.eagleye.dao.entities.Technicien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface TechnicienRepository extends JpaRepository<Technicien, Integer> {

    public Technicien findByNomAndPrenom(@Param("nom") String nom, @Param("prenom") String prenom);
}
