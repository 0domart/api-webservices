package com.epul.cerisaie.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "utilisateur", schema = "cinema", catalog = "")
@NamedQuery(name = "EntityUtilisateur.rechercheNom", query = "select ut  from EntityUtilisateur  ut where ut.nomUtil = ?1")
public class EntityUtilisateur {
    private Integer numUtil;
    private String nomUtil;
    private String motPasse;
    private String role;

    @Id
    @Column(name = "numutil", nullable = false)
    public Integer getNumUtil() {
        return numUtil;
    }

    public void setNumUtil(Integer numUtil) {
        this.numUtil = numUtil;
    }

    @Basic
    @Column(name = "nomutil", nullable = false, length = 100)
    public String getNomUtil() {
        return nomUtil;
    }

    public void setNomUtil(String nomUtil) {
        this.nomUtil = nomUtil;
    }

    @Basic
    @Column(name = "motpasse", nullable = false, length = 100)
    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    @Basic
    @Column(name = "role", nullable = false, length = 100)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityUtilisateur that = (EntityUtilisateur) o;
        return Objects.equals(numUtil, that.numUtil) &&
                Objects.equals(nomUtil, that.nomUtil) &&
                Objects.equals(motPasse, that.motPasse) &&
                Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numUtil, nomUtil, motPasse, role);
    }
}
