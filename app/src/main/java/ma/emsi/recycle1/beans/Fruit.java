package ma.emsi.recycle1.beans;

public class Fruit {
    private int id;
    private String nom;
    private double prix;
    private String image;
    private static int comp;

    public Fruit(String nom, double prix, String image) {
        this.nom = nom;
        this.prix = prix;
        this.image = image;
        this.id = ++comp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
