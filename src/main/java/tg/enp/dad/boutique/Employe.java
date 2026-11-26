/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.enp.dad.boutique;

import java.time.LocalDate;

/**
 *
 * @author USER
 */
public class Employe extends Personne{
    private LocalDate dateNaissance;

    public Employe() {
        super();
    }

    public Employe(long id, String nom, String prenom, LocalDate dateNaissance) {
        super(id, nom, prenom);
        this.dateNaissance = dateNaissance;
    }
    
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    
    @Override
    public String toString() {
        return "Employe{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + '}';
    }
}
