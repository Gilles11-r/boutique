/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.enp.dad.boutique.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import tg.enp.dad.boutique.Achat;
import tg.enp.dad.boutique.Client;
import tg.enp.dad.boutique.Employe;
import tg.enp.dad.boutique.ProduitAchete;

/**
 *
 * @author USER
 */
public class AchatService {
    private List<Achat> listesAchats;
    private static AchatService instance;
    
    private AchatService() {
        this.listesAchats = new ArrayList<>();
    }
    
    public static synchronized AchatService getInstance() {
        if (instance == null) {
            instance = new AchatService();
        }
        return instance;
    }
    
    public void ajouter(Achat achat) {
        listesAchats.add(achat);
    }
    
    public Achat modifier(long id, LocalDateTime dateAchat, double remise, Client client, Employe employe, List<ProduitAchete> produitAchetes) {
        Achat achat = trouver(id);
        if (achat != null) {
            achat.setDateAchat(dateAchat);
            achat.setRemise(remise);
            achat.setClient(client);
            achat.setEmploye(employe);
            achat.setProduitAchete(produitAchetes);
        }
        return achat;
    }
    
    public void modifier(Achat achat) {
        try {
            if (achat != null) {
                int index = this.listesAchats.indexOf(achat);
                if (index != -1) {
                    this.listesAchats.set(index, achat);
                }
                System.out.println(achat);
            }
        } catch (Exception ex) {
            System.out.println("Achat non trouvé !");
        }
    }
    
    public Achat trouver(long id) {
        Achat achat = new Achat();
        try {
            for (Achat ac : listesAchats) {
                if (ac.getId() == id) {
                    achat = ac;
                }
            }
        } catch(Exception ex) {
            System.out.println("Achat non trouvé");
        }
        return achat;
    }
    
    public void supprimer(long id) {
        Achat achat = trouver(id);
        if (achat != null && this.listesAchats.contains(achat)) {
            listesAchats.remove(achat);
        }
    }
    
    public void supprimer(Achat achat) {
        if (this.listesAchats.contains(achat)) {
            listesAchats.remove(achat);
        }
    }
    
    public int compter() {
        return listesAchats.size();
    }
    
    public List<Achat> lister() {
        return listesAchats;
    }
}
