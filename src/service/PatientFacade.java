/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.CategorieDiabete;
import bean.Patient;
import java.util.Date;
import util.HashageUtil;

/**
 *
 * @author fatima
 */
public class PatientFacade extends AbstractFacade<Patient>{
      public PatientFacade() {
        super(Patient.class);       
    }
       @Override
     public void create(Patient patient){
         patient.setPassword(HashageUtil.sha256(patient.getPassword()));
         super.create(patient);
     }
//     CategorieDiabeteFacade categorieDiabeteFacade = new CategorieDiabeteFacade();
     
     public int createPatient(String nom, String prenom,int role, String email, String password, String telephone ,Date dateNaissance,float taille , float poid ,Long idType ) {
        Patient patient = new Patient();
        
            patient.setNom(nom);
            patient.setPrenom(prenom);
            patient.setRole(role);
            patient.setEmail(email);
            patient.setPassword(password);
            patient.setTelephone(telephone);
            patient.setDateNaissance(dateNaissance);
            create(patient);
            
            return 1;
        

    }

}
