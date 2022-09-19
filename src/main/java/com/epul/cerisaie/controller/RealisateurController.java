package com.epul.cerisaie.controller;

import com.epul.cerisaie.domains.RealisateurEntity;
import com.epul.cerisaie.service.RealisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/realisateur")
public class RealisateurController {


    @Autowired
    private RealisateurService unRealisateurService;

/*************************************************/
/**************Tous les clients  ******************/
    /*************************************************/

    @PreAuthorize("hasAnyAuthority('admin', 'visiteur')")
    @GetMapping("/getAll")
    public List<RealisateurEntity> findAllRealisateurs() {
        String destinationPage = "";
        List<RealisateurEntity> mesRealisateurs = null;
        try {
            mesRealisateurs = unRealisateurService.getAllRealisateurs();
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return mesRealisateurs;
    }

    @PreAuthorize("hasAnyAuthority('admin', 'visiteur')")
    @GetMapping("/{id}")
    public RealisateurEntity getRealisateurById(@PathVariable(value = "id") int id) {
        RealisateurEntity realisateurEntity = null;
        try {
            realisateurEntity  = unRealisateurService.getRealisateurById(id);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return  realisateurEntity;
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