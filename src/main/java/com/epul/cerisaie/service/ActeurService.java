package com.epul.cerisaie.service;

import com.epul.cerisaie.domains.ActeurEntity;
import com.epul.cerisaie.domains.PersonnageEntity;
import com.epul.cerisaie.repositories.ActeurEntityRepository;
import com.epul.cerisaie.repositories.PersonnageEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActeurService implements IActeurService {

    private ActeurEntityRepository acteurService;

    // on initialise à travers le constructeur
    @Autowired
    public ActeurService(ActeurEntityRepository acteurService) {
        this.acteurService = acteurService;
    }


    // on liste tous les clients au format json
    @Override
    public List<ActeurEntity> getAllActeurs() {
        return acteurService.findAll();
    }
}
