package com.dog.empire.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Adresse {
	 @Column(name = "adresse1")
	    private String adresse1;

	    @Column(name = "adresse2")
	    private String adresse2;

	    @Column(name = "ville")
	    private String ville;
	    @Column(name = "codepostale")
	    private String codepostale;

	    @Column(name = "pays")
	    private String pays;

	    @Column(name = "telephone", nullable = false)
	    private String telephone;


}
