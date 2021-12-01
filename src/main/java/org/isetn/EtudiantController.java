package org.isetn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/etudiants")
@CrossOrigin
public class EtudiantController {
	
	@Autowired
	EtudiantRepository etudRep; 
	
	@RequestMapping(value="/all",method = RequestMethod.GET)
	public List<Etudiant> getAllEtudiants() {
		return etudRep.findAll();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Etudiant getEtudiantById(@PathVariable("id") Long id) {
		return etudRep.findById(id).get();
	}
	
	@RequestMapping(value="/classe/{id}",method = RequestMethod.GET)
	public List<Etudiant> getByClasse(@PathVariable("id") Long id) {
		return etudRep.findByClasse(id);
	}
	
	//créer un nouveau étudiant
	@RequestMapping(method = RequestMethod.POST)
	public Etudiant createEtudiant(@RequestBody Etudiant e) {
		 return etudRep.save(e);
	}
	
	//mise à jour d'un étudiant
	@RequestMapping(method = RequestMethod.PUT)
	public Etudiant updateEtudiant(@RequestBody Etudiant e) {
		return etudRep.save(e);
	}
	
	//supprimer un étudiant
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteEtudiant(@PathVariable("id") Long id) {
		etudRep.deleteById(id);
	}
}
