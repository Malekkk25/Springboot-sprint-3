package com.malek.vols.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Aeroport {
	@Id
	@GeneratedValue( strategy =GenerationType.IDENTITY)
	private Long idAir;
	
	private String nomAir;
	private String adresseAir;
	
	@JsonIgnore
	@OneToMany(mappedBy ="aeroport")
	private List<Vol> vols;
	
	public Long getIdAir() {
		return idAir;
	}

	public void setIdAir(Long idAir) {
		this.idAir = idAir;
	}

	public String getNomAir() {
		return nomAir;
	}

	public void setNomAir(String nomAir) {
		this.nomAir = nomAir;
	}

	public String getAdresseAir() {
		return adresseAir;
	}

	public void setAdresseAir(String adresseAir) {
		this.adresseAir = adresseAir;
	}

	public List<Vol> getVols() {
		return vols;
	}

	public void setVols(List<Vol> vols) {
		this.vols = vols;
	}

	public Aeroport() {
		super();
	}

	public Aeroport(String nomAir, String adresseAir, List<Vol> vols) {
		super();
		this.nomAir = nomAir;
		this.adresseAir = adresseAir;
		this.vols = vols;
	}
	
	
}
