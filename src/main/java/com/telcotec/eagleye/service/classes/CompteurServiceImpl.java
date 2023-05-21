package com.telcotec.eagleye.service.classes;

import com.telcotec.eagleye.dao.entities.Compteur;
import com.telcotec.eagleye.dao.repository.CompteurRepository;
import com.telcotec.eagleye.service.interfaces.ICompteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteurServiceImpl implements ICompteurService {
    @Autowired
    CompteurRepository compteurRepository;
    
    @Override
    public List<Compteur> AfficherToutCompteurs() {
        return compteurRepository.findAll();

    }
}
