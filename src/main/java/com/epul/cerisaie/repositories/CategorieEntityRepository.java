package com.epul.cerisaie.repositories;


import com.epul.cerisaie.domains.CategorieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategorieEntityRepository extends JpaRepository<CategorieEntity, Integer> {

    public CategorieEntity findCategorieEntityByCodeCat(String code);
}

