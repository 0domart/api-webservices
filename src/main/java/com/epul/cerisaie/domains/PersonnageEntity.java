package com.epul.cerisaie.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "personnage", schema = "cinema", catalog = "")
@IdClass(PersonnageEntityPK.class)
public class PersonnageEntity {

    @Id
    private int noFilm;
    @Id
    private int noAct;
    private String nomPers;

    @Basic
    @Column(name = "NomPers")
    public String getNomPers() {
        return nomPers;
    }

    public void setNomPers(String nomPers) {
        this.nomPers = nomPers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonnageEntity that = (PersonnageEntity) o;
        return noFilm == that.noFilm && noAct == that.noAct && Objects.equals(nomPers, that.nomPers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noFilm, noAct, nomPers);
    }

    /*
    @ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "noFilm", referencedColumnName = "noFilm", nullable = false)
    @JsonIgnoreProperties("personnage")
    private FilmEntity film;*/
}
