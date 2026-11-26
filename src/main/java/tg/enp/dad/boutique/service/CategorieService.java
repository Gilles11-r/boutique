/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.enp.dad.boutique.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import tg.enp.dad.boutique.Categorie;

/**
 *
 * @author USER
 */
public class CategorieService {
    private List<Categorie> listesCategories;
    private static CategorieService instance;
    
    private CategorieService() {
        listesCategories = new ArrayList<>();
    }
    
    public static synchronized CategorieService getInstance() {
        if (instance == null) {
            instance = new CategorieService();
        }
        return instance;
    }
    
    public void ajouter(Categorie categorie) {
        listesCategories.add(categorie);
    }
    
    public Categorie modifier(Integer id, String libelle, String description) {
        Categorie categorie = trouver(id);
        if (categorie != null) {
            categorie.setLibelle(libelle);
            categorie.setDescription(description);
            
        }
        return categorie;
    }
    
    public void modifier(Categorie categorie) {
        try {
            if (categorie != null) {
                int index = this.listesCategories.indexOf(categorie);
                if (index != -1) {
                    this.listesCategories.set(index, categorie);
                }
                System.out.println(categorie);
            }
        } catch (Exception ex) {
            System.out.println("Categorie non trouvé !");
        }
    }
    
    public Categorie trouver(Integer id) {
        Categorie categorie = new Categorie();
        try {
            for (Categorie c : listesCategories) {
                if (Objects.equals(c.getId(), id)) {
                    categorie = c;
                }
            }
        } catch(Exception ex) {
            System.out.println("Categorie non trouvé");
        }
        return categorie;
    }
    
    public void supprimer(Integer id) {
        Categorie categorie = trouver(id);
        if (categorie != null && this.listesCategories.contains(categorie)) {
            listesCategories.remove(categorie);
        }
    }
    
    public void supprimer(Categorie categorie) {
        if (this.listesCategories.contains(categorie)) {
            listesCategories.remove(categorie);
        }
    }
    
    public int compter() {
        return listesCategories.size();
    }
    
    public List<Categorie> lister() {
        return listesCategories;
    }
}
