package com.epul.cerisaie.service;

import com.epul.cerisaie.domains.RealisateurEntity;
import com.epul.cerisaie.mesExceptions.MonException;
import com.epul.cerisaie.repositories.RealisateurEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealisateurService implements IRealisateurService {

    private RealisateurEntityRepository realisateurService;

    // on initialise à travers le constructeur
    @Autowired
    public RealisateurService(RealisateurEntityRepository realisateurService) {
        this.realisateurService = realisateurService;
    }


    // on liste tous les clients au format json
    @Override
    public List<RealisateurEntity> getAllRealisateurs() {
        return realisateurService.findAll();
    }

    @Override
    public RealisateurEntity getRealisateurById(int id) {
        if (id != 0) {
            return realisateurService.findRealisateurByNoRea(id);
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
