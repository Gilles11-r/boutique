/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.enp.dad.boutique.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import tg.enp.dad.boutique.Employe;

/**
 *
 * @author USER
 */
public class EmployeService {
    
    private List<Employe> listesEmployes;
    private static EmployeService instance;
    
    private EmployeService() {
        this.listesEmployes = new ArrayList<>();
    }
    
    public static synchronized EmployeService getInstance() {
        if (instance == null) {
            instance = new EmployeService();
        }
        return instance;
    }
    
    public void ajouter(Employe employe) {
        listesEmployes.add(employe);
    }
    
    public Employe modifier(long id, String nom, String prenom, LocalDate dateNaissance) {
        Employe employe = trouver(id);
        if (employe != null) {
            employe.setNom(nom);
            employe.setPrenom(prenom);
            employe.setDateNaissance(dateNaissance);
        }
        return employe;
    }
    
    public void modifier(Employe employe) {
        try {
            if (employe != null) {
                int index = this.listesEmployes.indexOf(employe);
                if (index != -1) {
                    this.listesEmployes.set(index, employe);
                }
                System.out.println(employe);
            }
        } catch (Exception ex) {
            System.out.println("Employe non trouvé !");
        }
    }
    
    public Employe trouver(long id) {
        Employe employe = new Employe();
        try {
            for (Employe em : listesEmployes) {
                if (em.getId() == id) {
                    employe = em;
                }
            }
        } catch(Exception ex) {
            System.out.println("Employe non trouvé");
        }
        return employe;
    }
    
    public void supprimer(long id) {
        Employe employe = trouver(id);
        if (employe != null && this.listesEmployes.contains(employe)) {
            this.listesEmployes.remove(employe);
        }
    }
    
    public void supprimer(Employe employe) {
        if (this.listesEmployes.contains(employe)) {
            this.listesEmployes.remove(employe);
        }
    }
    
    public int compter() {
        return listesEmployes.size();
    }
    
    public List<Employe> lister() {
        return this.listesEmployes;
    }
}
