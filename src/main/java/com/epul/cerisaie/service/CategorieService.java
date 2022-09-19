package com.epul.cerisaie.service;

import com.epul.cerisaie.domains.CategorieEntity;
import com.epul.cerisaie.mesExceptions.MonException;
import com.epul.cerisaie.repositories.CategorieEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService implements ICategorieService {

    private CategorieEntityRepository categorieService;

    // on initialise à travers le constructeur
    @Autowired
    public CategorieService(CategorieEntityRepository categorieService) {
        this.categorieService = categorieService;
    }


    // on liste tous les clients au format json
    @Override
    public List<CategorieEntity> getAllCategories() {
        return categorieService.findAll();
    }

    @Override
    public CategorieEntity getCategorieById(String id) {
        if (id != null) {
            return categorieService.findCategorieEntityByCodeCat(id);
        } else {
            throw new MonException("Categorie", "id", id);
        }
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
