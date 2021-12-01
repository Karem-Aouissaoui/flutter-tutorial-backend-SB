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
@RequestMapping("/formations")
@CrossOrigin
public class FormationController {
	@Autowired
	FormationRepository formRep; 
	
	@RequestMapping(value="/all",method = RequestMethod.GET)
	public List<Formation> getAllFormations() {
		return formRep.findAll();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Formation getFormationById(@PathVariable("id") Long id) {
		return formRep.findById(id).get();
	}
	
	@RequestMapping(value="etudiant/{id}",method = RequestMethod.GET)
	public Formation getFormationByEtudiantId(@PathVariable("id") Long id) {
		return formRep.findByEtudiant (id);
	}
	
	//créer une nouvelle formation
	@RequestMapping(method = RequestMethod.POST)
	public Formation createFormation(@RequestBody Formation f) {
		return formRep.save(f);
	}
			
	//mise à jour d'une formation
	@RequestMapping(method = RequestMethod.PUT)
	public Formation updateFormation(@RequestBody Formation f) {
		return formRep.save(f);
	}
			
	//supprimer une formation
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteFormation(@PathVariable("id") Long id) {
		formRep.deleteById(id);
	}
	
}
