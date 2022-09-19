package com.epul.cerisaie.controller;

import com.epul.cerisaie.domains.CategorieEntity;
import com.epul.cerisaie.mesExceptions.MonException;
import com.epul.cerisaie.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/categorie")
public class CategorieController {


    @Autowired
    private CategorieService unCategorieService;

/*************************************************/
/**************Tous les clients  ******************/
    /*************************************************/

    @PreAuthorize("hasAnyAuthority('admin', 'visiteur')")
    @GetMapping("/getAll")
    public List<CategorieEntity> findAllClients() {
        String destinationPage = "";
        List<CategorieEntity> mesCategories = null;
        try {
            mesCategories = unCategorieService.getAllCategories();
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return mesCategories;
    }

    @PreAuthorize("hasAnyAuthority('admin', 'visiteur')")
    @GetMapping("/{id}")
    public CategorieEntity getCategorieById(@PathVariable(value = "id") String id) {
        CategorieEntity categorieEntity = null;
        try {
            categorieEntity  = unCategorieService.getCategorieById(id);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return  categorieEntity;
    }

    // sauvegarde Client

    /*
    @RequestMapping(value = "/ajout", method = RequestMethod.POST)
    public ResponseEntity  ajoutClient(@RequestBody EntityClient unC)
            throws MonException,Exception
    {
        try {
            unFilmService.ajouterClient(unC);
            return ResponseEntity.ok().build();
        }
        catch (MonException e) {
            return ResponseEntity.notFound().build();
        }
        catch (Exception e) {

            return ResponseEntity.notFound().build();
        }
    }*/

}