package com.dog.empire.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Clients extends TrackingEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Embedded // cette anotation c'est pour signifier que nous avons a faire a un champ composé;
    private Adresse adresse;
	 @Column(name = "nom", nullable = false)
	    private String nom;
    @Column(name = "email")
    private String email;
    
    @Column(name = "nationalite")
    private String nationalite;
    
    @OneToMany(mappedBy = "clients")
    private List<Vente> vente;
    
    @OneToMany(mappedBy = "clients")
    private List<Seller> seller;

}
