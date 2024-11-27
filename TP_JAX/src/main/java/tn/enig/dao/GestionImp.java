package tn.enig.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tn.enig.model.Produit;

public class GestionImp implements IGestion{
	
	private Connection connection;
	
    public GestionImp() {
   
        try {
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tpjax", "root", ""
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public Produit getProduitById(int id) {
		try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM produit WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Produit(
                		rs.getInt("id"), 
                		rs.getString("description"), 
                        rs.getDouble("prix"),
                        rs.getInt("nbre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return null;
	}

	public List<Produit> getAllProduits() {
		List<Produit> produits = new ArrayList<Produit>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM produit");
            while (rs.next()) {
                produits.add(new Produit(
                		rs.getInt("id"),
                		rs.getString("description"), 
                        rs.getDouble("prix"),
                        rs.getInt("nbre")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produits;
	}

	public void addProduit(Produit produit) {
		try {
            PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO produit (description, prix, nbre) VALUES (?, ?, ?)"
            );
            ps.setString(1, produit.getDescription());
            ps.setDouble(2, produit.getPrix());
            ps.setInt(3, produit.getNbre());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	public void deleteProduit(int id) {
		try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM produit WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
}
