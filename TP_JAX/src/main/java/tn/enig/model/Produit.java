package tn.enig.model;


public class Produit {
private int id;
private String description;
private double prix;
private int nbre;
public Produit(int id, String description, double prix, int nbre) {
	super();
	this.id = id;
	this.description = description;
	this.prix = prix;
	this.nbre = nbre;
}
public Produit() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public double getPrix() {
	return prix;
}
public void setPrix(float prix) {
	this.prix = prix;
}
public int getNbre() {
	return nbre;
}
public void setNbre(int nbre) {
	this.nbre = nbre;
}

}
