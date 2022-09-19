package com.epul.cerisaie.repositories;


import com.epul.cerisaie.domains.RealisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RealisateurEntityRepository extends JpaRepository<RealisateurEntity, Integer> {

    public RealisateurEntity findRealisateurByNoRea(int code);

}

