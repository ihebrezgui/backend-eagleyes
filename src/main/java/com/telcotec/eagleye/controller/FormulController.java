package com.telcotec.eagleye.controller;
import com.telcotec.eagleye.dao.entities.Formule;
import com.telcotec.eagleye.service.interfaces.IFormulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/Conventions")


public class FormulController {
    @Autowired
    IFormulService formulServ;


    @GetMapping("/all")
    public List<Formule> displayAllConventions(int id) {
        return formulServ.AfficherToutFormules();
    }

    @PostMapping("/addFormules")
    public Integer addConventions(@RequestBody Formule f) {
        return formulServ.AjouteFormules(f);
    }
    @GetMapping("/Conventions/{idf}")
    public Formule Conventions(@PathVariable("idf") int id) {
        return formulServ.afficherForumles(id);
    }





}
