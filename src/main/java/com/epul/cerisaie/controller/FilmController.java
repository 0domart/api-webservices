package com.epul.cerisaie.controller;
import com.epul.cerisaie.domains.FilmEntity;
import com.epul.cerisaie.mesExceptions.MonException;
import com.epul.cerisaie.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/film")
public class FilmController {


    @Autowired
    private FilmService unFilmService;

/*************************************************/
/**************Tous les clients  ******************/
    /*************************************************/

    @PreAuthorize("hasAnyAuthority('admin', 'visiteur')")
    @GetMapping("/getAll")
    public List<FilmEntity> findAllClients() {
        String destinationPage = "";
        List<FilmEntity> mesClients = null;
        try {
            mesClients = unFilmService.getAllFilms();
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return mesClients;
    }

    @PreAuthorize("hasAnyAuthority('admin', 'visiteur')")
    @GetMapping("/{id}")
    public FilmEntity getFilmById(@PathVariable(value = "id") int id) {
        FilmEntity filmEntity = null;
        try {
            filmEntity  = unFilmService.getFilm(id);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return  filmEntity;
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