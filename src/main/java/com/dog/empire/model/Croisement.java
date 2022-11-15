package com.dog.empire.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)

public class Croisement extends TrackingEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
    @JoinColumn(name = "idanimal")
    private Animal animal1;
	@ManyToOne
    @JoinColumn(name = "idanimal")
    private Animal animal2;

    @ManyToOne
    @JoinColumn(name = "idproprietaire")
    private Vendeur proprietaire1;
    @ManyToOne
    @JoinColumn(name = "idproprietaire")
    private Vendeur proprietaire2;

}
