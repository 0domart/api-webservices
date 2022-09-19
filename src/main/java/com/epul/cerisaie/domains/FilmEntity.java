package com.epul.cerisaie.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "film", schema = "cinema", catalog = "")
public class FilmEntity {

    private int noFilm;
    private String titre;
    private int duree;
    private Date dateSortie;
    private int budget;
    private int montantRecette;

    @Id
    @Column(name = "NoFilm")
    public int getNoFilm() {
        return noFilm;
    }

    public void setNoFilm(int noFilm) {
        this.noFilm = noFilm;
    }

    @Basic
    @Column(name = "Titre")
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Basic
    @Column(name = "Duree")
    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    @Basic
    @Column(name = "DateSortie")
    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    @Basic
    @Column(name = "Budget")
    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    @Basic
    @Column(name = "MontantRecette")
    public int getMontantRecette() {
        return montantRecette;
    }

    public void setMontantRecette(int montantRecette) {
        this.montantRecette = montantRecette;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmEntity that = (FilmEntity) o;
        return noFilm == that.noFilm && duree == that.duree && budget == that.budget && montantRecette == that.montantRecette && Objects.equals(titre, that.titre) && Objects.equals(dateSortie, that.dateSortie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noFilm, titre, duree, dateSortie, budget, montantRecette);
    }

    @JsonIgnoreProperties("films")
    private CategorieEntity categorie;

    @ManyToOne
    @JoinColumn(name = "CodeCat", referencedColumnName = "CodeCat", nullable = false)
    public CategorieEntity getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieEntity categorie) {
        this.categorie = categorie;
    }

    @JsonIgnoreProperties("films")
    private RealisateurEntity realisateur;

    @ManyToOne
    @JoinColumn(name = "noRea", referencedColumnName = "noRea", nullable = false)
    public RealisateurEntity getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(RealisateurEntity realisateur) {
        this.realisateur = realisateur;
    }

    /*
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "film", orphanRemoval = true, fetch=FetchType.EAGER)
    @JsonIgnoreProperties("film")
    private Collection<PersonnageEntity> personnages = new ArrayList<>();

    public Collection<PersonnageEntity> getPersonnages() {
        return personnages;
    }
    public void setPersonnages(Collection<PersonnageEntity> personnages) {
        this.personnages = personnages;
    }*/

}
