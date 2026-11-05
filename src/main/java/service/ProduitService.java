/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import com.mycompany.boutique.Produit;
import java.util.LinkedList;

/**
 *
 * @author USER
 */
public class ProduitService {
    private static ProduitService instance  = null;
    
    private List<Produit> liste;
    
    private ProduitService(){
       this.liste = new LinkedList<>();
    }
    
    public synchronized static ProduitService getInstance(){
        if(instance == null){
            instance = new ProduitService();
       }
        return instance;
    }
    
    //ajouter produut
    public void ajouter(Produit p){
        if (p != null){
            this.liste.add(p);
        }
    }
    
    //modifier produit
    
    public void modifier(Produit p){
        if(p == null) return ;
        int index = this.liste.indexOf(p);
        if(index != -1){
            this.liste.set(index, p);
        }
    }
    
    //trouver un produit
    
    public Produit trouver(long id){
        for(Produit p : this.liste){
            if(id == p.getId()){
                return p;
            }
        }
        return null;
    }
    
    //suprimer un produit
    public void supprimer(long id){
        Produit p = trouver(id);
        if(p != null){
            this.liste.remove(p);
        }
    }
    //compter le nombre de produit
    
    public int compter(){
        return this.liste.size();
    }
    
    //lister tous les produits
    
    public List<Produit> lister(){
        return this.liste;
    }
    
    
    public List<Produit> listerPermie(){
        List<Produit> perimes = new LinkedList<>();
        
        for(Produit p : this.liste){
            if (p.estPerime()){
                perimes.add(p);
            }
        }
        return perimes;
    }
}
