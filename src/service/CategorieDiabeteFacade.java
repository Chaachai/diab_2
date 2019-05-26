/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.CategorieDiabete;
import java.util.List;

/**
 *
 * @author CHAACHAI Youssef
 */
public class CategorieDiabeteFacade extends AbstractFacade<CategorieDiabete> {

    public CategorieDiabeteFacade() {
        super(CategorieDiabete.class);
    }

    public void createType(String libelle) {
        CategorieDiabete categorieDiabete = new CategorieDiabete();
        categorieDiabete.setLibelle(libelle);
        create(categorieDiabete);
    }
    
     public List<CategorieDiabete> findTypeByName(String libelle) {
        String query = " SELECT c FROM CategorieDiabete c WHERE c.libelle LIKE '%" + libelle + "%' ";
        return getEntityManager().createQuery(query).getResultList();
    }

}
