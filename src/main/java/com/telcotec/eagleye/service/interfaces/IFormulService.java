package com.telcotec.eagleye.service.interfaces;

import com.telcotec.eagleye.dao.entities.Formule;

import java.util.List;

public interface IFormulService {
    public Integer AjouteFormules(Formule f);
    public Formule afficherForumles(int id);

    public List<Formule> AfficherToutFormules();

}
