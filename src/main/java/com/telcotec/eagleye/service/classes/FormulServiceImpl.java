package com.telcotec.eagleye.service.classes;
import com.telcotec.eagleye.dao.entities.Compteur;
import com.telcotec.eagleye.dao.entities.Formule;
import com.telcotec.eagleye.dao.entities.KPI;
import com.telcotec.eagleye.dao.repository.CompteurRepository;
import com.telcotec.eagleye.dao.repository.FormulRepository;
import com.telcotec.eagleye.dao.repository.KPIRepository;
import com.telcotec.eagleye.service.interfaces.IFormulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormulServiceImpl implements IFormulService {
    @Autowired
    FormulRepository formulRepository;
    @Autowired
    KPIRepository KpiRepository;
    @Autowired
    private CompteurRepository compteurRepository;

    @Override
    public Integer AjouteFormules(Formule f) {
        // Retrieve the existing KPI from the database
        KPI existingKPI = KpiRepository.findById(f.getKpis().getIdKPI()).orElse(null);
        if (existingKPI == null) {
            // Handle the case when the KPI ID doesn't exist in the database
            throw new IllegalArgumentException("Invalid KPI ID: " + f.getKpis().getIdKPI());
        }

        // Retrieve the existing Compteur from the database
        Compteur existingCompteur = compteurRepository.findById(f.getCompteurs().getIdCompteur()).orElse(null);
        if (existingCompteur == null) {
            // Handle the case when the Compteur ID doesn't exist in the database
            throw new IllegalArgumentException("Invalid Compteur ID: " + f.getCompteurs().getIdCompteur());
        }

        // Set the retrieved KPI and Compteur objects in the Formule entity
        f.setKpis(existingKPI);
        f.setCompteurs(existingCompteur);

        // Save the formule in the database
        formulRepository.save(f);

        return f.getIdFormule();
    }

    @Override
    public Formule afficherForumles(int id) {
        return formulRepository.findById(id).get();

    }

    @Override
    public List<Formule> AfficherToutFormules() {
        return formulRepository.findAll();

    }

    @Override
    public Formule mettreAjourFormule(int id, Formule f) {
        f.setIdFormule(id);
        formulRepository.save(f);
        return f;
    }

    @Override
    public void supprimerFormule(int id) {
        formulRepository.delete(formulRepository.getById(id));

    }


}
