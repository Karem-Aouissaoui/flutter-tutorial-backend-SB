package org.isetn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classe {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codClass;
	private String nomClass;
	private int nbreEtud;
	@JsonIgnore
	@OneToMany(mappedBy="classe", fetch = FetchType.LAZY)
	private Collection<Etudiant> etudiants; 
}
