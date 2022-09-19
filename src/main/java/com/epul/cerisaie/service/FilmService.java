package com.epul.cerisaie.service;

import com.epul.cerisaie.domains.FilmEntity;
import com.epul.cerisaie.mesExceptions.MonException;
import com.epul.cerisaie.repositories.FilmEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService implements IFilmService {

    private FilmEntityRepository filmService;

    // on initialise à travers le constructeur
    @Autowired
    public FilmService(FilmEntityRepository filmService) {
        this.filmService = filmService;
    }


    // on liste tous les clients au format json
    @Override
    public List<FilmEntity> getAllFilms() {
        return filmService.findAll();
    }

    @Override
    public FilmEntity getFilm(int id) {
        return filmService.findById(id).orElseThrow(
                () -> new MonException("Film", "id", id)
        );
    }

    /*
    public EntityClient getUnClientID(int id) {
        return unClientRepository.findById(id).orElseThrow(
                () -> new MonException("Client", "id", id)
        );
    }

    // on insère un client
    @Override
    public void   ajouterClient(EntityClient unC) {
        try {
            unClientRepository.save(unC);
        }
        catch (Exception e) {
            throw new MonException("Insert", "Sql", e.getMessage());
        }
    }*/
}
