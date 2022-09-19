package com.epul.cerisaie.service;

import com.epul.cerisaie.domains.FilmEntity;

import java.util.List;

public interface IFilmService {

    public List<FilmEntity> getAllFilms();

    public FilmEntity getFilm(int id) ;

}