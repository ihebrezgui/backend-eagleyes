package com.telcotec.eagleye.dao.entities;

import lombok.*;

import javax.persistence.*;

import java.util.Date;


@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "csv_file")

public class CsvFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCsv")
    private Integer idCsv; // Clé primaire
    private Date date;
    private String eNodeBName;
    private String cellFDDTDDIndication;
    private String cellName;

    private float rRCConnectionSuccess;
    private float rRCConnectionAttempt;
    private float eRAbAbnormalRelease;
    private float eRAbRelease;
    private float intraFreqSuccess;
    private float intraFreqAttempt;
    private float cellTrafficVolume;
    private float cellTransferTime;
    private float avgUserNum;


}
