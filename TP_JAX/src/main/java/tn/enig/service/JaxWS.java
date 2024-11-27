package tn.enig.service;


import jakarta.jws.WebMethod;

import jakarta.jws.WebService;

import java.util.List;


import tn.enig.dao.GestionImp;
import tn.enig.model.Produit;
@WebService(serviceName = "JaxWS")
public class JaxWS {
	 private GestionImp gestion = new GestionImp();

	    @WebMethod(operationName="getProduitById")
	    public Produit getProduitc(int id) {
	        return gestion.getProduitById(id);
	    }

	    @WebMethod(operationName="getProduit")
	    public List<Produit> getProduits() {
	        return gestion.getAllProduits();
	    }

	    @WebMethod(operationName="addProduit")
	    public void addProduit(Produit produit) {
	        gestion.addProduit(produit);
	    }

	    @WebMethod(operationName="deleteProduit")
	    public void deleteProduit(int id) {
	        gestion.deleteProduit(id);
	    }
}
