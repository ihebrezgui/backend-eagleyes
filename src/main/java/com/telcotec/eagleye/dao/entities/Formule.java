package com.telcotec.eagleye.dao.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "Formule")
public class Formule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFormule")
    private Integer idFormule; // Clé primaire
    private String nomFormule;
    private String descFormule;

    @JsonIgnore
    @ManyToOne
    KPI kpis;


    @JsonIgnore
    @ManyToOne
    private Compteur compteurs;


}
