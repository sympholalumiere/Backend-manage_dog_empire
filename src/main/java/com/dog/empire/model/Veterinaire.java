package com.dog.empire.model;



import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author SYMPHORIEN
 *
 */


@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Veterinaire")
public class Veterinaire extends TrackingEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "nom", nullable = false)
  
    private String nom;
    @Embedded // cette anotation c'est pour signifier que nous avons a faire a un champ composé;
    private Adresse adresse;
    @Column(name = "email", nullable = false)
    
    private String email;
    @Column(name = "nationalite", nullable = false)
    private String nationalite;

    @ManyToOne
    @JoinColumn(name = "identreprise")
    private Entreprise entreprise;


}
