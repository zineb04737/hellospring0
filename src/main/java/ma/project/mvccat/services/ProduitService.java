package ma.project.mvccat.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.project.mvccat.entities.Produit;
import ma.project.mvccat.repositories.ProduitsRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProduitService {

    @Autowired
    private ProduitsRepository produitRepository;

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Produit getProduitById(int id) {
        return produitRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produit not found with id: " + id));
    }

    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public Produit updateProduit(int id, Produit newProduit) {
        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produit not found with id: " + id));

        produit.setNom(newProduit.getNom());
        produit.setPrix(newProduit.getPrix());

        return produitRepository.save(produit);
    }

    public void deleteProduit(int id) {
        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produit not found with id: " + id));

        produitRepository.delete(produit);
    }
}