package com.telcotec.eagleye.dao.entities;


import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table( name = "KPI")
public class KPI implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idKPI")
    private Integer idKPI; // Clé primaire
    private String nomKPI;
    private String descKPI;

    @OneToMany
    @JsonIgnore
    private List<Formule> formules;


}
