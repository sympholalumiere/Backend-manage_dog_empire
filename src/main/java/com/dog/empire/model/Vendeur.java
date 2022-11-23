package com.dog.empire.model;

//import java.util.ArrayList;
//import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vendeurs")
public class Vendeur extends TrackingEntity {

    @Column(name = "nom", nullable = false)
    private String nom;
    @Column(name = "prenom", nullable = false)
    private String prenom;
	private static final long serialVersionUID = 1L;
	@Embedded // cette anotation c'est pour signifier que nous avons a faire a un champ composé;
    private Adresse adresse;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "nationalite", nullable = false)
    
    private String nationalite;
    private String password;
    @OneToMany(mappedBy = "vendeur")
    private List<Vente> vente;
    @ManyToOne
    @JoinColumn(name = "identreprise")
    private Entreprise entreprise;

}
