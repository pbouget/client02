package fr.bouget.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adresse implements Serializable {
	public static final long serialVersionUID=987654378L;

	private int id;
	private String voie;
	private String complement;
	private String codePostal;
	private String ville;
	private String pays;

	public Adresse(){
		this(null, null, null, null, null);
	}

	public Adresse(String voie, String complement, String codePostal, String ville, String pays){
		this.id=0;
		this.voie=voie;
		this.complement=complement;
		this.codePostal=codePostal;
		this.ville=ville;
		this.pays=pays;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(length=50)
	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	@Column(length=50)
	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	@Column(length=5)
	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	@Column(length=50)
	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Column(length=50)
	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	@Override
	public String toString(){
		return id+" "+voie+" "+complement+" "+codePostal+" "+ville+" "+pays;
	}
}
