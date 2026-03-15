package ma.project.mvccat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.project.mvccat.entities.Produit;
import ma.project.mvccat.services.ProduitService;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    // GET http://localhost:8084/api/produits
    @GetMapping
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }

    // GET http://localhost:8084/api/produits/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable int id) {
        return ResponseEntity.ok(produitService.getProduitById(id));
    }

    // POST http://localhost:8084/api/produits
    @PostMapping
    public ResponseEntity<Produit> createProduit(@RequestBody Produit produit) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produitService.createProduit(produit));
    }

    // PUT http://localhost:8084/api/produits/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable int id, @RequestBody Produit produit) {
        return ResponseEntity.ok(produitService.updateProduit(id, produit));
    }

    // DELETE http://localhost:8084/api/produits/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduit(@PathVariable int id) {
        produitService.deleteProduit(id);
        return ResponseEntity.ok("Produit supprimé avec succès (id: " + id + ")");
    }
}