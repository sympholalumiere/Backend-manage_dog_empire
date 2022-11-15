package com.dog.empire.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
@Table(name = "entreprise")
public class Entreprise extends TrackingEntity{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "nomresponsable")
    private String nomresponsable;

    @Embedded // cette anotation c'est pour signifier que nous avons a faire a un champ composé;
    private Adresse adresse;
    @Embedded // cette anotation c'est pour signifier que nous avons a faire a un champ composé;
    private Document document;

   @OneToMany(mappedBy = "seller")
    private List<Seller> seller;
   
   @OneToMany(mappedBy = "entreprise")
   private List<Vendeur> vendeur;
   
  @OneToMany(mappedBy = "entreprise")
    private List<Veterinaire> veterinaire;
  @Column(name = "nom_entreprise")
	private String nom;
	@Column(name = "description")
	private String description;
	@Column(name = "codeFiscal")
	private String codeFiscal;
	@Column(name = "photo")
	private String photo;
	@Column(name = "email")
	private String email;
	@Column(name = "numTel")
	private String numTel;
	@Column(name = "siteweb")
	private String siteweb;
    
}
