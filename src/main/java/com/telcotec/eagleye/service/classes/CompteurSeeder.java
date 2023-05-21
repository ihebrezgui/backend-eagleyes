package com.telcotec.eagleye.service.classes;

import com.telcotec.eagleye.dao.entities.Compteur;
import com.telcotec.eagleye.dao.repository.CompteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CompteurSeeder implements CommandLineRunner {

    @Autowired
    private CompteurRepository compteurRepository;

    @Override
    public void run(String... args) throws Exception {
        // Create some sample Compteurs
        Compteur compteur1 = new Compteur();
        compteur1.setNomCompteur("Compteur 1");
        compteur1.setDescCompteur("This is the description for Compteur 1");

        Compteur compteur2 = new Compteur();
        compteur2.setNomCompteur("Compteur 2");
        compteur2.setDescCompteur("This is the description for Compteur 2");

        Compteur compteur3 = new Compteur();
        compteur3.setNomCompteur("Compteur 3");
        compteur3.setDescCompteur("This is the description for Compteur 3");

        // Save the Compteurs to the database if they don't already exist
        saveIfNotExists(compteur1);
        saveIfNotExists(compteur2);
        saveIfNotExists(compteur3);
    }

    private void saveIfNotExists(Compteur compteur) {
        Compteur existingCompteur = compteurRepository.findByNomCompteur(compteur.getNomCompteur());
        if (existingCompteur == null) {
            compteurRepository.save(compteur);
        }
    }
}
