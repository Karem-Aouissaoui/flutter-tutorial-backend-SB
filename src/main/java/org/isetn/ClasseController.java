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
@RequestMapping("/classes")
@CrossOrigin
public class ClasseController {
	@Autowired
	ClasseRepository classRep; 
	
	@RequestMapping(value="/all",method = RequestMethod.GET)
	public List<Classe> getAllClasses() {
		return classRep.findAll();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Classe getClasseById(@PathVariable("id") Long id) {
		return classRep.findById(id).get();
	}
	
	//créer un nouveau classe
		@RequestMapping(method = RequestMethod.POST)
		public Classe createClasse(@RequestBody Classe c) {
			 return classRep.save(c);
		}
		
		//mise à jour d'un étudiant
		@RequestMapping(method = RequestMethod.PUT)
		public Classe updateClasse(@RequestBody Classe c) {
			return classRep.save(c);
		}
		
		//supprimer un étudiant
		@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		public void deleteClasse(@PathVariable("id") Long id) {
			classRep.deleteById(id);
		}
}
