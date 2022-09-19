package com.epul.cerisaie.controller;

import com.epul.cerisaie.domains.CategorieEntity;
import com.epul.cerisaie.domains.PersonnageEntity;
import com.epul.cerisaie.mesExceptions.MonException;
import com.epul.cerisaie.service.CategorieService;
import com.epul.cerisaie.service.PersonnageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/personnage")
public class PersonnageController {


    @Autowired
    private PersonnageService unPersonnageService;

/*************************************************/
/**************Tous les clients  ******************/
    /*************************************************/

    @GetMapping("/getAll")
    public List<PersonnageEntity> findAllPersonnages() {
        List<PersonnageEntity> mesPersonnages = null;
        try {
            mesPersonnages = unPersonnageService.getAllPersonnages();
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return mesPersonnages;
    }

}