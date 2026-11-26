/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.enp.dad.boutique;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author USER
 */
public class ProduitAchete implements Serializable{
    /*private static final long serialVersionUID = 1L;
    
    private double remise;
    private Produit produit;
    private Achat achat ;
    
    public ProduitAchete(){
        
    }

    public ProduitAchete(double remise, Produit produit, Achat achat) {
        this.remise = remise;
        this.produit = produit;
        this.achat = achat;
    }

    public double getRemise() {
        return remise;
    }

    public void setRemise(double remise) {
        this.remise = remise;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "ProduitAchete{" + "remise=" + remise + ", produit=" + produit + '}';
    }*/
    
    private static final long serialVersionUID = 1L;
    
    private double remise;
    private Produit produit;
    private Achat achat;
    
    public ProduitAchete() {
        
    }
    
    public ProduitAchete(double remise, Produit produit, Achat achat) {
        this.remise = remise;
        this.produit = produit;
        this.achat = achat;
    }

    public Achat getAchat() {
        return achat;
    }

    public void setAchat(Achat achat) {
        this.achat = achat;
    }
    
    public double getRemise() {
        return remise;
    }
    
    public Produit getProduit() {
        return produit;
    }
    
    public void setRemise(double remise) {
        this.remise = remise;
    }
    
    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.produit);
        hash = 43 * hash + Objects.hashCode(this.achat);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProduitAchete other = (ProduitAchete) obj;
        if (!Objects.equals(this.produit, other.produit)) {
            return false;
        }
        return Objects.equals(this.achat, other.achat);
    }

    @Override
    public String toString() {
        return "ProduitAchete{" + "remise=" + remise + ", produit=" + produit + '}';
    }
}
