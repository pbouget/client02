package fr.bouget.jpa.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Client implements Serializable {
	public static final long serialVersionUID=987654378L;

	private int id;
	private String nom;
	private String prenom;
	private Adresse adresse;

	public Client(){
		this(null, null);
	}

	public Client(String nom, String prenom){
		this(null, null, null);
	}

	public Client(String nom, String prenom, Adresse adresse){
		this.nom=nom;
		this.prenom=prenom;
		this.adresse=adresse;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="ADDRESS_ID")
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString(){
		if(adresse==null){
			return "id="+id+" nom="+nom+" prenom="+prenom;
		}else{
			return "id="+id+" nom="+nom+" prenom="+prenom+" adresse : "+adresse.toString();
		}
	}
}
