package org.isetn;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
/*import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;*/
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface FormationRepository extends JpaRepository<Formation, Long> {
	//@Query("select p from Etudiant e where e.nom like :x")
	//public List<Etudiant> Chercher(@Param("x")String nom);
	//ou d'ecrire 
	
	//liste des étudiants qui font partie d'une formation
		@Query("select f from Formation f, Etudiant e where f.id = e.formation.id and e.id = ?1")
		Formation findByEtudiant (Long id) ;
	
}
