/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Patient;
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

}
