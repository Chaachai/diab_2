/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author CHAACHAI Youssef
 */
@Entity
@Table(name = "PATIENT")
public class Patient extends Utilisateur implements Serializable {

    private float taille;
    private float poids;
    @ManyToOne
    private CategorieDiabete categorieDiabete;
    @OneToOne
    private Carnet carnet;
    @OneToOne
    private EtatPatient etat;
    @OneToMany(mappedBy = "patient")
    private List<Meal> meals;
    @OneToMany(mappedBy = "patient")
    private List<Avis> avisList;

    public Patient() {
    }

    public Patient(Long id) {
        super(id);
    }

    public Patient(Float aFloat, Float aFloat0, long MIN_VALUE, String text, String text0, String text1, String text2, String text3, Date date1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Avis> getAvisList() {
        return avisList;
    }

    public void setAvisList(List<Avis> avisList) {
        this.avisList = avisList;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public float getTaille() {
        return taille;
    }

    public void setTaille(float taille) {
        this.taille = taille;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public CategorieDiabete getCategorieDiabete() {
        return categorieDiabete;
    }

    public void setCategorieDiabete(CategorieDiabete categorieDiabete) {
        this.categorieDiabete = categorieDiabete;
    }

    public Carnet getCarnet() {
        return carnet;
    }

    public void setCarnet(Carnet carnet) {
        this.carnet = carnet;
    }

    public EtatPatient getEtat() {
        return etat;
    }

    public void setEtat(EtatPatient etat) {
        this.etat = etat;
    }

}
