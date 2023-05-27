package com.telcotec.eagleye.dao.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "CsvFile")

public class CsvFile {
    @Id
    @GeneratedValue
    private Long id;

    private Date date;
    private String eNodeBName;
    private String cellFDDTDDIndication;
    private String cellName;
    
    private String rRCConnectionSuccess;
    private String rRCConnectionAttempt;
    private String eRAbAbnormalRelease;
    private String eRAbRelease;
    private String intraFreqSuccess;
    private String intraFreqAttempt;
    private String cellTrafficVolume;
    private String cellTransferTime;
    private String avgUserNum;


}
