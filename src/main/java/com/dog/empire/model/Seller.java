package com.dog.empire.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "seller")
public class Seller extends TrackingEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name= "datedelavente")
	private Date datevente;
	@Column(name= "montantdelavente")
	private float montant;
   
   @ManyToOne
    @JoinColumn(name = "idanimal")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "seller")
    private Seller seller;

    @ManyToOne
    @JoinColumn(name = "clients")
    private Clients clients;
    
    @ManyToOne
    @JoinColumn(name = "identreprise")
    private Entreprise entreprise;
}
