package com.epul.cerisaie.domains;


import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PersonnageEntityPK implements Serializable {

    @Id
    private int noFilm;
    @Id
    private int noAct;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonnageEntityPK that = (PersonnageEntityPK) o;
        return noFilm == that.noFilm && noAct == that.noAct;
    }

    @Override
    public int hashCode() {
        return Objects.hash(noFilm, noAct);
    }
}
