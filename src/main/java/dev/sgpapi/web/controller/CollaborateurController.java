package dev.sgpapi.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.sgpapi.entite.Banque;
import dev.sgpapi.entite.Collaborateur;
import dev.sgpapi.repository.BanqueRepository;
import dev.sgpapi.repository.CollaborateurRepository;
import dev.sgpapi.repository.DepartementRepository;

@RestController
@RequestMapping("/api/collaborateurs")
public class CollaborateurController {

	@Autowired
	CollaborateurRepository cr;

	@Autowired
	DepartementRepository dr;

	@Autowired
	BanqueRepository br;

	@RequestMapping(method = RequestMethod.GET)
	public List<Collaborateur> listerCollaborateurs() {
		return cr.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, params = { "departement" })
	public List<Collaborateur> findCollaborateursById(@RequestParam("departement") Integer depId) {
		return cr.findByDepartement(dr.getOne(depId));
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{matricule}")
	public Collaborateur findCollaborateurByMatricule(@PathVariable String matricule) {
		return cr.findByMatricule(matricule);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{matricule}")
	public void modifierCollaborateur(@PathVariable String matricule, @RequestBody Collaborateur collaborateur) {
		collaborateur.setId(cr.findByMatricule(matricule).getId());
		cr.save(collaborateur);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{matricule}/banque")
	public Banque findBanqueOfCollaborateur(@PathVariable String matricule) {
		return br.getOne(cr.findByMatricule(matricule).getId());
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{matricule}/banque")
	public void modifierBanqueOfCollaborateur(@PathVariable String matricule, @RequestBody Banque banque) {
		Collaborateur toUpdate = cr.findByMatricule(matricule);
		toUpdate.setBanque(banque);
		cr.save(toUpdate);
	}

}
