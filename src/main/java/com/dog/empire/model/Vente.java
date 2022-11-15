package com.dog.empire.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vente")
public class Vente extends TrackingEntity{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name= "datedelavente")
	private Date datevente;
	@Column(name= "montantdelavente")
	private Double montant;
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
   
   @ManyToOne
    @JoinColumn(name = "idanimal")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "idvendeur")
    private Vendeur vendeur;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idseller")
    private Seller seller;

    @ManyToOne
    @JoinColumn(name = "clients")
    private Clients clients;
}
