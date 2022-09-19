package com.epul.cerisaie.repositories;

import com.epul.cerisaie.domains.EntityUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurEntityRepository extends JpaRepository<EntityUtilisateur, Integer> {

   public EntityUtilisateur rechercheNom(String login);
}
