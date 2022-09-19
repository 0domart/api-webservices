package com.epul.cerisaie.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "realisateur", schema = "cinema", catalog = "")
public class RealisateurEntity {

    @Id
    private int noRea;
    private String nomRea;
    private String prenRea;


    @OneToMany(cascade=CascadeType.ALL, mappedBy = "realisateur", orphanRemoval = true, fetch=FetchType.EAGER)
    @JsonIgnoreProperties("realisateur")
    private Collection<FilmEntity> films = new ArrayList<>();

    public Collection<FilmEntity> getFilms() {
        return films;
    }
    public void setFilms(Collection<FilmEntity> films) {
        this.films = films;
    }

    @Basic
    @Column(name = "NomRea")
    public String getNomRea() {
        return nomRea;
    }

    public void setNomRea(String nomRea) {
        this.nomRea = nomRea;
    }

    @Basic
    @Column(name = "PrenRea")
    public String getPrenRea() {
        return prenRea;
    }

    public void setPrenRea(String prenRea) {
        this.prenRea = prenRea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RealisateurEntity that = (RealisateurEntity) o;
        return noRea == that.noRea && Objects.equals(nomRea, that.nomRea) && Objects.equals(prenRea, that.prenRea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noRea, nomRea, prenRea);
    }
}
