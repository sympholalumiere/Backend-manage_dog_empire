package com.dog.empire.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "dresseur")
public class Dresseur extends TrackingEntity {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;
	private Adresse adresse;

}
