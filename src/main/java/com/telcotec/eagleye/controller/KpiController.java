package com.telcotec.eagleye.controller;

import com.telcotec.eagleye.dao.entities.KPI;

import com.telcotec.eagleye.service.interfaces.IKpiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/Kpis")
public class KpiController {
    @Autowired
    IKpiService kpisrv;
    @GetMapping("/displaykpis")
    public List<KPI> AfficherKpis() {
        return kpisrv.AfficherToutKpis();
    }
}
