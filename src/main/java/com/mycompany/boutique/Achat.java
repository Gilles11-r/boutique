/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.boutique;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import user.Client;
import user.Employe;

/**
 *
 * @author USER
 */
public class Achat implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private long id;
    private LocalDateTime dateAchat;
    private double remise;
    
    private Client client;
    private Employe employe;
    private List<ProduitAchete> produitAchete = new ArrayList<>();
    
    public Achat ()  {
    }

    public Achat(Long id, LocalDateTime dateAchat, double remise, Client client, Employe employe) {
        this.id = id;
        this.dateAchat = dateAchat;
        this.remise = remise;
        this.client = client;
        this.employe = employe;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(LocalDateTime dateAchat) {
        this.dateAchat = dateAchat;
    }

    public double getRemise() {
        return remise;
    }

    public void setRemise(double remise) {
        this.remise = remise;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public List<ProduitAchete> getProduitAchete() {
        return produitAchete;
    }

    public void setProduitAchete(List<ProduitAchete> produitAchete) {
        this.produitAchete = produitAchete;
    }
    
    public double getRemiseTotale(){
        double totalRemisesArticle = this.remise;
        for (ProduitAchete item : produitAchete){
            totalRemisesArticle += item.getRemise();
        }
        return totalRemisesArticle;
    }
    
    public double getTotalPayer(){
        double totalBrut = 0.0;
        for(ProduitAchete item: this.produitAchete){
            if(item.getProduit() != null){
                totalBrut += item.getProduit().getPrixUnitaire();
            }
        }
        double totalNet = totalBrut - this.getRemiseTotale();
        //return Math.max(0, totalNet);remise peu etre eleve que le prix donc 
        return totalNet ;
    }
    
    //ajouter un produit qui a été acheté
    public void ajouterProduitAchete(ProduitAchete item){
        if(item != null){
            this.produitAchete.add(item);
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Achat other = (Achat) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Achat{" + "id=" + id + ", dateAchat=" + dateAchat + ", remiseGlobal=" + remise + ", client=" + client + ", employe=" + employe + ", produitAchete=" + produitAchete + '}';
    }
    
    
}
