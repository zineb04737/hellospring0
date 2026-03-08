package ma.project.mvccat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ma.project.mvccat.entities.Produit;
import ma.project.mvccat.repositories.ProduitsRepository;

@SpringBootApplication
public class Hellospring0Application implements CommandLineRunner {

@Autowired
private ProduitsRepository produitsRepository;

public static void main(String[] args) {
SpringApplication.run(Hellospring0Application.class, args);
}

@Override
public void run(String... args) throws Exception {

produitsRepository.save(new Produit(0,"TCL",23.00));
produitsRepository.save(new Produit(0,"Samsung",23.00));

produitsRepository.findAll().forEach(p->{
System.out.println(p.toString());
});

System.out.println("***************************");

Produit produit = produitsRepository.findById(5).get();
System.out.println("produit trouvé: "+ produit.toString());

System.out.println("Recherche par nom ***************************");

produitsRepository.findByNomContains("de").forEach(p->{
System.out.println(p.toString());
});

System.out.println("Recherche par prix ***************************");

produitsRepository.findByPrix(10.00).forEach(p->{
System.out.println(p.toString());
});

System.out.println("Recherche double critères ***************************");

produitsRepository.findByNomContainsAndPrix("p",10.00).forEach(p->{
System.out.println(p.toString());
});

produitsRepository.deleteById(9);

}
}
