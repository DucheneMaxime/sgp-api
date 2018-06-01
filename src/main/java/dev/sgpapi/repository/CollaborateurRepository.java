package dev.sgpapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sgpapi.entite.Collaborateur;
import dev.sgpapi.entite.Departement;

public interface CollaborateurRepository extends JpaRepository<Collaborateur, Integer> {

	public List<Collaborateur> findByDepartement(Departement departement);

	public Collaborateur findByMatricule(String matricule);
}
