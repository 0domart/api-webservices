package com.epul.cerisaie.repositories;


import com.epul.cerisaie.domains.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FilmEntityRepository extends JpaRepository<FilmEntity, Integer> {
}

