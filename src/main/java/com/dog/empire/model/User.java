package com.dog.empire.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(	name = "users")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Long userId;
    private String username;
    private String email;
    private String numero;



    @Transient
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Vente> vente = new HashSet<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    private Collection<Achat> achat;

    @Transient
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Achat> achats = new HashSet<>();

    public Long getUserId() {
        return userId;
    }

    public User setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public User setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public Set<Achat> getAchats() {
        return achats;
    }

    public User setAchats(Set<Achat> achats) {
        this.achats = achats;
        return this;
    }

    public User(String username, String email, String numero) {
        this.username = username;
        this.email = email;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
