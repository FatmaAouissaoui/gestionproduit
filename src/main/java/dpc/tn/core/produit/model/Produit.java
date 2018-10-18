package dpc.tn.core.produit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;
/**
 * Produit
 * 
 * @author user 
 *
 */
@Entity
public class Produit {

	@Id
	@GeneratedValue
	private Long id;

	private String nom;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Object getProduitId() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
