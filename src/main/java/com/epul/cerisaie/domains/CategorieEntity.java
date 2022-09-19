package com.epul.cerisaie.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "categorie", schema = "cinema", catalog = "")
public class CategorieEntity {

    @Id
    private String codeCat;
    private String libelleCat;
    private String image;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "categorie", orphanRemoval = true, fetch=FetchType.EAGER)
    @JsonIgnoreProperties("categorie")
    private Collection<FilmEntity> films = new ArrayList<>();

    public Collection<FilmEntity> getFilms() {
        return films;
    }
    public void setFilms(Collection<FilmEntity> films) {
        this.films = films;
    }

    @Basic
    @Column(name = "LibelleCat")
    public String getLibelleCat() {
        return libelleCat;
    }

    public void setLibelleCat(String libelleCat) {
        this.libelleCat = libelleCat;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategorieEntity that = (CategorieEntity) o;
        return Objects.equals(codeCat, that.codeCat) && Objects.equals(libelleCat, that.libelleCat) && Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeCat, libelleCat, image);
    }
}
