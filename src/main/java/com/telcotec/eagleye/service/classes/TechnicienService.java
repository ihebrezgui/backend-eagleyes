package com.telcotec.eagleye.service.classes;

import com.telcotec.eagleye.dao.entities.Technicien;
import com.telcotec.eagleye.dao.repository.TechnicienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicienService {

    @Autowired
    TechnicienRepository techRep;

    public void supprimerTech(int id) {
        techRep.deleteById(id);
    }
    public List<Technicien> listTech() {
        List<Technicien> techniciens =(List<Technicien>) techRep.findAll();
        return techniciens;
    }
}
