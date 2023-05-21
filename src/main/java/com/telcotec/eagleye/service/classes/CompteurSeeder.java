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

                Compteur compteur1 = new Compteur();
                compteur1.setNomCompteur("Compteur 1");
                compteur1.setDescCompteur("This is the description for Compteur 1");

                Compteur compteur2 = new Compteur();
                compteur2.setNomCompteur("Compteur 2");
                compteur2.setDescCompteur("This is the description for Compteur 2");

                Compteur compteur3 = new Compteur();
                compteur3.setNomCompteur("Compteur 3");
                compteur3.setDescCompteur("This is the description for Compteur 3");
                compteurRepository.save(compteur1);
                compteurRepository.save(compteur2);
                compteurRepository.save(compteur3);
            }
        }