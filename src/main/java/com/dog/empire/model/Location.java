package com.dog.empire.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "location")
public class Location extends TrackingEntity {
	
	private static final long serialVersionUID = 1L;

}
