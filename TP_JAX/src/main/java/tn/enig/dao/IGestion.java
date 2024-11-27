package tn.enig.dao;

import java.util.List;

import tn.enig.model.Produit;

public interface IGestion {
	Produit getProduitById(int id);
    List<Produit> getAllProduits();
    void addProduit(Produit produit);
    void deleteProduit(int id);
}
