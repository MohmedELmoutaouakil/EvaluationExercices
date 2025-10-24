package classes;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    @OneToMany(mappedBy = "Produit",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Produit> produits = new ArrayList<Produit>();
    private String code;
    private String libelle;

        public Category(){}

    public Category(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }


    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }

    public List<Produit> getProduits() { return produits; }
    public void setProduits(List<Produit> produits) { this.produits = produits; }
}
