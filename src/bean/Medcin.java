/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author CHAACHAI Youssef
 */
@Entity
@Table(name = "MEDCIN")
public class Medcin extends Utilisateur {

    @OneToMany(mappedBy = "medcin")
    private List<Conseils> conseilss;
    @OneToMany(mappedBy = "medcin")
    private List<Avis> aviss;
    private String speciaite;
    @OneToMany(mappedBy = "medcin")
    private List<Cabinet> cabinets;

  

  
    public List<Conseils> getConseilss() {
        return conseilss;
    }

    public void setConseilss(List<Conseils> conseilss) {
        this.conseilss = conseilss;
    }

    public List<Avis> getAviss() {
        return aviss;
    }

    public void setAviss(List<Avis> aviss) {
        this.aviss = aviss;
    }

    public String getSpeciaite() {
        return speciaite;
    }

    public void setSpeciaite(String speciaite) {
        this.speciaite = speciaite;
    }

    public List<Cabinet> getCabinets() {
        return cabinets;
    }

    public void setCabinets(List<Cabinet> cabinets) {
        this.cabinets = cabinets;
    }

    public Medcin() {
    }

    public Medcin(Long id) {
        super(id);
    }
    
    

}
