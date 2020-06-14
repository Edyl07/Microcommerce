package com.ecommerce.microservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(value = {"id", "prixAchat"})
@Entity

public class Product {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Length(min=3, max=20, message = "Le nom doit être compris entre 3 et 20 caractére")
	private String nom;
	private int prix;
	private int prixAchat;
	
	
	
	public Product() {
		super();
	}


	public Product(int id, String nom, int prix, int prixAchat) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.prixAchat = prixAchat;
	}


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


	public double getPrix() {
		return prix;
	}


	public void setPrix(int prix) {
		this.prix = prix;
	}


	public double getPrixAchat() {
		return prixAchat;
	}


	public void setPrixAchat(int prixAchat) {
		this.prixAchat = prixAchat;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", nom=" + nom + ", prix=" + prix + ", prixAchat=" + prixAchat + "]";
	}
	
	

}
