package com.dog.empire.model;

import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "animal")
public class Animal extends TrackingEntity {

   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "nom", nullable = false)
    private String nom;
    @Column(name = "race", nullable =false )
    private String race;

    @Column(name = "pseudo", nullable = true)
    private String pseudo;

    @Column(name = "localite", nullable = true)
    private String localite;
    @Column(name = "age", nullable = true)
    private int age;

     @Column(name = "sexe", nullable = false)
    private String sexe;
    @Column(name = "dateNaissance")
    @DateTimeFormat(pattern="dd-MM-yyyy")

    private LocalDate dateNaissance;

    @OneToMany(mappedBy = "animal")
    private List<Vente> vente;
    
    @OneToMany(mappedBy = "animal")
    private List<Seller> seller;

/*
    @ManyToMany(mappedBy ="animal",fetch = FetchType.EAGER)
    private Collection <Vendeur> vendeur = new ArrayList<>();
*/
    

}
