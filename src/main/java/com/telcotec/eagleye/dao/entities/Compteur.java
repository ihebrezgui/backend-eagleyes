package com.telcotec.eagleye.dao.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "Compteur")
public class Compteur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCompteur")
    private Integer idCompteur; // Clé primaire
    private String nomCompteur;
    private String descCompteur;


    @ManyToOne
    Formule formules;

}
