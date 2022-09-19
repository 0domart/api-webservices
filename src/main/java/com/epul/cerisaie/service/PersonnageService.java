package com.epul.cerisaie.service;

import com.epul.cerisaie.domains.CategorieEntity;
import com.epul.cerisaie.domains.PersonnageEntity;
import com.epul.cerisaie.mesExceptions.MonException;
import com.epul.cerisaie.repositories.CategorieEntityRepository;
import com.epul.cerisaie.repositories.PersonnageEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonnageService implements IPersonnageService {

    private PersonnageEntityRepository personnageService;

    // on initialise à travers le constructeur
    @Autowired
    public PersonnageService(PersonnageEntityRepository personnageService) {
        this.personnageService = personnageService;
    }


    // on liste tous les clients au format json
    @Override
    public List<PersonnageEntity> getAllPersonnages() {
        return personnageService.findAll();
    }
}
