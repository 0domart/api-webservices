package com.epul.cerisaie.service;

import com.epul.cerisaie.domains.RealisateurEntity;

import java.util.List;

public interface IRealisateurService {

    public List<RealisateurEntity> getAllRealisateurs();

    public RealisateurEntity getRealisateurById(int id) ;

}