package dpc.tn.core.produit.controller;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dpc.tn.core.produit.model.Produit;
import dpc.tn.core.produit.repository.ProduitRepository;

@RestController
@RequestMapping("/api/")
public class ProduitController {

	@Autowired
	private ProduitRepository repository;

	@RequestMapping(value = "produits", method = RequestMethod.GET)
	public Collection<Produit> getContracts() {
		return repository.findAll().stream().collect(Collectors.toList());

	}

	@RequestMapping(value = "produit", method = RequestMethod.POST)
	public Produit addProduitt(@Valid @RequestBody Produit produit) {

		return repository.save(produit);
	}

	@RequestMapping("produits/{id}")
	public Produit getProduitById(@PathVariable(value = "id") Long produitId) {
		return repository.findById(produitId).orElseThrow(() -> new ResourceNotFoundException("produitId"));
	}

	 @RequestMapping(value = "produit/{id}", method = RequestMethod.DELETE)
	    public void deleteContract(@PathVariable("id") long id) {
	        Optional<Produit> currentProduit = null;
	        currentProduit = repository.findById(id);
	        if (currentProduit !=null ) {
	            repository.deleteById(id);
	}
}

	 
	 @RequestMapping(value = "produit/{id}", method = RequestMethod.PUT)
	    public Produit updateProduit(@PathVariable(value = "id") String produitId,
	                              @Valid @RequestBody Produit produitDetails) {

	        Produit produit = repository.findById(Long.parseLong(produitId))
	                .orElseThrow(() -> new ResourceNotFoundException("produitId"));
	        System.out.println(produit);
	          Produit updatedProduit = repository.save(produit);
	        System.out.println(updatedProduit);

	        return updatedProduit;
	    }

	}