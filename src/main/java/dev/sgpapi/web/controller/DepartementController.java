package dev.sgpapi.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.sgpapi.entite.Departement;
import dev.sgpapi.repository.DepartementRepository;

@Controller
@RequestMapping("/api")
public class DepartementController {

	@Autowired
	DepartementRepository dr;

	@RequestMapping(method = RequestMethod.GET, path = "/departements")
	@ResponseBody
	public List<Departement> listerDepartements() {
		return dr.findAll();

	}

}
