package com.telcotec.eagleye.service.classes;

import com.telcotec.eagleye.dao.entities.KPI;
import com.telcotec.eagleye.dao.repository.KPIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class KPISeeder implements CommandLineRunner {

    @Autowired
    private KPIRepository kpiRepository;

    @Override
    public void run(String... args) throws Exception {
        // Create some sample KPIs
        KPI kpi1 = new KPI();
        kpi1.setNomKPI("KPI 1");
        kpi1.setDescKPI("This is the description for KPI 1");

        KPI kpi2 = new KPI();
        kpi2.setNomKPI("KPI 2");
        kpi2.setDescKPI("This is the description for KPI 2");

        KPI kpi3 = new KPI();
        kpi3.setNomKPI("KPI 3");
        kpi3.setDescKPI("This is the description for KPI 3");

        // Save the KPIs to the database if they don't already exist
        saveIfNotExists(kpi1);
        saveIfNotExists(kpi2);
        saveIfNotExists(kpi3);
    }

    private void saveIfNotExists(KPI kpi) {
        KPI existingKpi = kpiRepository.findByNomKPI(kpi.getNomKPI());
        if (existingKpi == null) {
            kpiRepository.save(kpi);
        }
    }
}