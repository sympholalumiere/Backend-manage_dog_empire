package com.dog.empire.model;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vente")
public class Vente {
    @Id
    @SequenceGenerator(
            name="vente_sequence",
            sequenceName = "vente_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Long idVente;
	private static final long serialVersionUID = 1L;
	@Column(name= "datedelavente")
	private Date datevente;
	@Column(name= "montantdelavente")
	private Double montant;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "userId")
    private User user;

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

    public Vente(Date datevente, Double montant, User user, Animal animal) {
        this.datevente = datevente;
        this.montant = montant;
        this.user = user;
        this.animal = animal;
    }

    public Vente(Date datevente, Double montant, User user, Animal animal, Vendeur vendeur, Clients clients) {
        this.datevente = datevente;
        this.montant = montant;
        this.user = user;
        this.animal = animal;
        this.vendeur = vendeur;
        this.clients = clients;
    }

    public Long getIdVente() {
        return idVente;
    }

    public Vente setIdVente(Long idVente) {
        this.idVente = idVente;
        return this;
    }

    public Date getDatevente() {
        return datevente;
    }

    public Vente setDatevente(Date datevente) {
        this.datevente = datevente;
        return this;
    }

    public Double getMontant() {
        return montant;
    }

    public Vente setMontant(Double montant) {
        this.montant = montant;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Vente setUser(User user) {
        this.user = user;
        return this;
    }

    public Animal getAnimal() {
        return animal;
    }

    public Vente setAnimal(Animal animal) {
        this.animal = animal;
        return this;
    }

    public Vendeur getVendeur() {
        return vendeur;
    }

    public Vente setVendeur(Vendeur vendeur) {
        this.vendeur = vendeur;
        return this;
    }

    public Seller getSeller() {
        return seller;
    }

    public Vente setSeller(Seller seller) {
        this.seller = seller;
        return this;
    }

    public Clients getClients() {
        return clients;
    }

    public Vente setClients(Clients clients) {
        this.clients = clients;
        return this;
    }

    @Override
    public String toString() {
        return "Vente{" +
                "idVente=" + idVente +
                ", datevente=" + datevente +
                ", montant=" + montant +
                ", user=" + user +
                ", animal=" + animal +
                '}';
    }
    public void assignUser(User user) {
        this.user = user;
    }
}
