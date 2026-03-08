package ma.project.mvccat.entities;

import jakarta.persistence.*;

@Entity
@Table(name="produits")

public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="ID_PRODUIT")
    private Integer id;

    @Column(name="NOM_PRODUIT")
    private String nom;

    private Double prix;

    public Produit() {
    }

    public Produit(Integer id, String nom, Double prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }
}