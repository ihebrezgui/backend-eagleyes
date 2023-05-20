package com.telcotec.eagleye.service.classes;
import com.telcotec.eagleye.dao.entities.Formule;
import com.telcotec.eagleye.dao.repository.FormulRepository;
import com.telcotec.eagleye.service.interfaces.IFormulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormulServiceImpl implements IFormulService {
    @Autowired
    FormulRepository formulRepository;
    @Override
    public Integer AjouteFormules(Formule f) {
        formulRepository.save(f);
        return f.getIdFormule() ;
    }

    @Override
    public Formule afficherForumles(int id) {
        return formulRepository.findById(id).get();

    }

    @Override
    public List<Formule> AfficherToutFormules() {
        return formulRepository.findAll();

    }


}
