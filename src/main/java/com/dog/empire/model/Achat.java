package com.dog.empire.model;



import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "achat")
public class Achat extends TrackingEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="designation")
	private String designation;
	@Column(name="prix_achat" , nullable = true)
	private int prix;
/*	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;*/


}
