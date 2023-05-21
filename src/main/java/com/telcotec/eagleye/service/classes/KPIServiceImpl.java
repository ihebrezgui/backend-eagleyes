package com.telcotec.eagleye.service.classes;

import com.telcotec.eagleye.dao.entities.KPI;
import com.telcotec.eagleye.dao.repository.KPIRepository;
import com.telcotec.eagleye.service.interfaces.IKpiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KPIServiceImpl implements IKpiService {
    @Autowired
    KPIRepository kpiRepository;
    
    @Override
    public List<KPI> AfficherToutKpis() {
        return kpiRepository.findAll();

    }
}
