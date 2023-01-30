package com.dog.empire.model;



import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.util.Date;


@Data
//@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "achat")
public class Achat{
	@Id
	@SequenceGenerator(
			name="achat_sequence",
			sequenceName = "achat_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE
	)
	private Long idAchat;
	private static final long serialVersionUID = 1L;

	@Column(name="designation")
	private String designation;
	@Column(name="prix_achat" , nullable = false)
	private int prix;


	@CreatedDate
	@Column(name = "dateAchat", nullable = false)
	private Date dateAchat;


	@ManyToOne
	@JoinColumn(name="id_user", referencedColumnName = "userId")
	private User user;

	public Achat(String designation, int prix, User user, Date dateAchat) {
		this.designation = designation;
		this.prix = prix;
		this.dateAchat = dateAchat;
		this.user = user;
	}

	public Long getIdAchat() {
		return idAchat;
	}

	public Achat setIdAchat(Long idAchat) {
		this.idAchat = idAchat;
		return this;
	}

	public String getDesignation() {
		return designation;
	}

	public Achat setDesignation(String designation) {
		this.designation = designation;
		return this;
	}

	public int getPrix() {
		return prix;
	}

	public Achat setPrix(int prix) {
		this.prix = prix;
		return this;
	}

	public User getUser() {
		return user;
	}

	public Achat setUser(User user) {
		this.user = user;
		return this;
	}


	public void assignUser(User user) {
		this.user = user;
	}

	public Date getDateAchat() {
		return dateAchat;
	}

	public Achat setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
		return this;
	}

	@Override
	public String toString() {
		return "Achat{" +
				"idAchat=" + idAchat +
				", designation='" + designation + '\'' +
				", prix=" + prix +
				", dateAchat=" + dateAchat +
				", user=" + user +
				'}';
	}
}
	/*
            @ManyToOne(fetch=FetchType.LAZY)
            @JoinColumn(name="user_id", referencedColumnName = "userId")
            private User user;
        */
/*
	public Achat(String designation, int prix, User user) {
		this.designation = designation;
		this.prix = prix;
		this.user = user;
	}*/
