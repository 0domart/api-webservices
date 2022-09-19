package com.epul.cerisaie.service;

import com.epul.cerisaie.config.CustomUserBean;
import com.epul.cerisaie.domains.EntityUtilisateur;
import com.epul.cerisaie.repositories.UtilisateurEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private UtilisateurEntityRepository unUtilisateurRepostory;

    // on initialise
    @Autowired
    public JwtUserDetailsService(UtilisateurEntityRepository UtilisateurRepostory) {
        this.unUtilisateurRepostory = UtilisateurRepostory;
    }

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    EntityUtilisateur unUtilisateur = null;
    // on accède à l'utilisateur
    unUtilisateur = unUtilisateurRepostory.rechercheNom(username);
    System.out.println(unUtilisateur);
    System.out.println(unUtilisateur.getRole());
    if (unUtilisateur != null) {
        return CustomUserBean.createInstance(unUtilisateur);
    } else {
        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}
}