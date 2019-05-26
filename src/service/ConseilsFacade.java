/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.CategorieDiabete;
import bean.Conseils;
import bean.Medcin;
import java.util.List;

/**
 *
 * @author CHAACHAI Youssef
 */
public class ConseilsFacade extends AbstractFacade<Conseils> {

    public ConseilsFacade() {
        super(Conseils.class);
    }

    MedcinFacade medcinFacade = new MedcinFacade();
    CategorieDiabeteFacade categorieDiabeteFacade = new CategorieDiabeteFacade();

    public int createConseil(String titre, String message, Long idMedcin, Long idType) {
        Conseils conseil = new Conseils();
        Medcin med = medcinFacade.find(idMedcin);
        CategorieDiabete type = categorieDiabeteFacade.find(idType);
        if (med != null && type != null) {
            conseil.setTitre(titre);
            conseil.setConseils(message);
            conseil.setMedcin(med);
            conseil.setCategorieDiabete(type);
            create(conseil);
            return 1;
        } else {
            return -1;
        }

    }

    public List<Conseils> findByMedcinAndCategory(Long idMedcin, Long idCategorie) {
        String query = " SELECT c FROM Conseils c WHERE c.medcin.id ='" + idMedcin + "' AND c.categorieDiabete.id ='" + idCategorie + "' ";
        return getEntityManager().createQuery(query).getResultList();
    }

}
