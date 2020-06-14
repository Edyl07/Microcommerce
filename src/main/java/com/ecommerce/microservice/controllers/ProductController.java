package com.ecommerce.microservice.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ecommerce.microservice.controllers.exceptions.ProduitIntrouvableException;
import com.ecommerce.microservice.dao.ProductDao;
import com.ecommerce.microservice.models.Product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "Gestion des Produits")
@RestController
public class ProductController {
	
	@Autowired
	private ProductDao productDao;
	
	//Produits
	@GetMapping(value ="produits")
	public List<Product> index(){
		return productDao.findAll();
	}
	
	//Produits/{id}
	@ApiOperation(value = "Recupére un produit selon son id")
	@GetMapping(value ="produits/{id}")
	public Product show(@PathVariable int id) throws ProduitIntrouvableException {
		
		Product product = productDao.findById(id);
		
		if(product == null) throw new ProduitIntrouvableException("Le produit avec l'id "+id+" n'existe pas");
		
		return product;
	}
	
	@PostMapping(value ="/produits")
	public ResponseEntity<Void> store(@Valid @RequestBody Product product) {
		Product product1 = productDao.save(product);
		
		if(product == null) {
			return ResponseEntity.noContent().build();
		}
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(product1.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(value= "test/produits/{prixLimit}")
	public List<Product> testRequest(@PathVariable int prixLimit){
		return productDao.findByPrixGreaterThan(prixLimit);
	}

}
