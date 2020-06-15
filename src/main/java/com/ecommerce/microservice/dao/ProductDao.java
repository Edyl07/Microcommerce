package com.ecommerce.microservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.microservice.models.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
	
	Product findById(int id);
	
	List<Product> findByPrixGreaterThan(int prixLimit);
	
	/*@Query("SELECT id, nom, prix FROM Product p WHERE p.prix > :prixLimit")
	List<Product> chercherUnproduitCher(@Param("prixLimit") int prix);*/
	
	/*@Query("SELECT * FROM product p AND (p.prix - p.prixAchat)")
	List<Product> calculerMargeProduit();*/
	
	List<Product> findAllByOrderByNomAsc();
}
