package dpc.tn.core.produit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import dpc.tn.core.produit.model.Produit;

@RepositoryRestResource
public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
