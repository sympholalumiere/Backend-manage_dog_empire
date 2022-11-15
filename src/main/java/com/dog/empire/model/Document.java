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
public class Document{
    @Column(name = "titre1")
    private String titre1;

    @Column(name = "titre2")
    private String tritre2;

    @Column(name = "plus")
    private String plus;

}
