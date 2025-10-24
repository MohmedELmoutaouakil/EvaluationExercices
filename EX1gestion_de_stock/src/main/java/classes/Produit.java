package classes;

import jakarta.persistence.*;

@Entity
@NamedQuery(name = "Produit.findPrixSup100", query = "from Produit p where p.prix > 100")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reference;
    private float prix;

    @ManyToOne
    @JoinColumn(name = "id")
    private Category category;

    public Produit() {}

    public Produit(String reference, float prix, Category categorie) {
        this.reference = reference;
        this.prix = prix;
        this.category = categorie;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getReference() { return reference; }
    public void setReference(String reference) { this.reference = reference; }

    public float getPrix() { return prix; }
    public void setPrix(float prix) { this.prix = prix; }

    public Category getCategorie() { return category; }
    public void setCategorie(Category categorie) { this.category = categorie; }
}