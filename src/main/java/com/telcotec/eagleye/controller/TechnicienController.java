package com.telcotec.eagleye.controller;

import com.telcotec.eagleye.dao.entities.Technicien;
import com.telcotec.eagleye.service.classes.TechnicienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/technicien")
public class TechnicienController {

    @Autowired
    TechnicienService techServ;


    @GetMapping("Display")
    public List<Technicien> DisplayAllStudent() {
        return techServ.listTech();
    }

    @DeleteMapping("/Remove/{id}")
    public void removeOperateur(@PathVariable("id") int id) {
        techServ.supprimerTech(id);
    }
}
