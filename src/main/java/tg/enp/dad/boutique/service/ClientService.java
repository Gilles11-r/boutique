/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.enp.dad.boutique.service;

import java.util.ArrayList;
import java.util.List;
import tg.enp.dad.boutique.Client;

/**
 *
 * @author USER
 */
public class ClientService {
    private List<Client> listesClients;
    private static ClientService instance;
    
    private ClientService() {
        this.listesClients = new ArrayList<>();
    }
    
    public static synchronized ClientService getInstance() {
        if (instance == null) {
            instance = new ClientService();
        }
        return instance;
    }
    
    public void ajouter(Client client) {
        listesClients.add(client);
    }
    
    public Client modifier(long id, String nom, String prenom) {
        Client client = trouver(id);
        if (client != null) {
            client.setNom(nom);
            client.setPrenom(prenom);
        }
        return client;
    }
    
    public void modifier(Client client) {
        try {
            if (client != null) {
                int index = this.listesClients.indexOf(client);
                if (index != -1) {
                    this.listesClients.set(index, client);
                }
                System.out.println(client);
            }
        } catch (Exception ex) {
            System.out.println("Client non trouvé !");
        }
    }
    
    public Client trouver(long id) {
        Client client = new Client();
        try {
            for (Client cl : listesClients) {
                if (cl.getId() == id) {
                    client = cl;
                }
            }
        } catch(Exception ex) {
            System.out.println("Client non trouvé");
        }
        return client;
    }
    
    public void supprimer(long id) {
        Client client = trouver(id);
        if (client != null && this.listesClients.contains(client)) {
            listesClients.remove(client);
        }
    }
    
    public void supprimer(Client client) {
        if (this.listesClients.contains(client)) {
            listesClients.remove(client);
        }
    }
    
    public int compter() {
        return listesClients.size();
    }
    
    public List<Client> lister() {
        return listesClients;
    }
}
