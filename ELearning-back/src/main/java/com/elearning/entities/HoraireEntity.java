package com.elearning.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "horaire")
@Inheritance(strategy = InheritanceType.JOINED)
public class HoraireEntity extends MyEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeDebut;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeFin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateTimeDebut() {
        return dateTimeDebut;
    }

    public void setDateTimeDebut(Date dateTimeDebut) {
        this.dateTimeDebut = dateTimeDebut;
    }

    public Date getDateTimeFin() {
        return dateTimeFin;
    }

    public void setDateTimeFin(Date dateFin) {
        this.dateTimeFin = dateFin;
    }
}
