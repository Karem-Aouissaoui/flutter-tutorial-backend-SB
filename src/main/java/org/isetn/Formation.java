package org.isetn;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Formation {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private int duree;
	@JsonIgnore
	@OneToMany(mappedBy="formation", fetch = FetchType.LAZY)
	private Collection<Etudiant> etudiants;
	@Override
	public String toString() {
		return "Formation [id=" + id + ", nom=" + nom + ", duree=" + duree + "]";
	} 
	
	
}
