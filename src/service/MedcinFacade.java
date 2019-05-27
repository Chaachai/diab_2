/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Medcin;
import java.util.Date;


/**
 *
 * @author CHAACHAI Youssef
 */
public class MedcinFacade extends AbstractFacade<Medcin> {

    public MedcinFacade() {
        super(Medcin.class);
    }

    public int createPatient(String nom, String prenom,int role, String email, String password, String telephone,Date dateNaissance ,String speciaite ) {
            Medcin med = new Medcin();
            //CategorieDiabete type = categorieDiabeteFacade.find(idType);
            med.setNom(nom);
            med.setPrenom(prenom);
            med.setRole(role);
            med.setEmail(email);
            med.setPassword(password);
            med.setTelephone(telephone);
            med.setDateNaissance(dateNaissance);
            med.setSpeciaite(speciaite);
            create(med);
            
            return 1;
        

    }


}
