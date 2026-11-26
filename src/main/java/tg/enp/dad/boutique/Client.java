/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.enp.dad.boutique;

/**
 *
 * @author USER
 */
public class Client extends Personne{
    public Client(){
        super();
    }

    public Client(long id, String nom, String prenom) {
        super(id, nom, prenom);
    }
    
    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + '}';
    }
}
