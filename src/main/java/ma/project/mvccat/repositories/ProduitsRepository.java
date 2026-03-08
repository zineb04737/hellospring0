package ma.project.mvccat.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ma.project.mvccat.entities.Produit;

public interface ProduitsRepository extends JpaRepository<Produit, Integer> {

    List<Produit> findByNomContains(String car);

    List<Produit> findByPrix(Double prix);

    List<Produit> findByNomContainsAndPrix(String nom, Double prix);

}