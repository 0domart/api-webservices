package com.epul.cerisaie.controller;

import com.epul.cerisaie.domains.ActeurEntity;
import com.epul.cerisaie.domains.PersonnageEntity;
import com.epul.cerisaie.mesExceptions.MonException;
import com.epul.cerisaie.service.ActeurService;
import com.epul.cerisaie.service.PersonnageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/acteur")
public class ActeurController {


    @Autowired
    private ActeurService unActeurService;

/*************************************************/
/**************Tous les clients  ******************/
    /*************************************************/

    @PreAuthorize("hasAnyAuthority('admin', 'visiteur')")
    @GetMapping("/getAll")
    public List<ActeurEntity> findAllPersonnages() {
        List<ActeurEntity> mesActeurs = null;
        try {
            mesActeurs = unActeurService.getAllActeurs();
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return mesActeurs;
    }

}