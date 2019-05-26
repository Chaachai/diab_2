/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Medcin;

/**
 *
 * @author CHAACHAI Youssef
 */
public class MedcinFacade extends AbstractFacade<Medcin> {

    public MedcinFacade() {
        super(Medcin.class);
    }

    public int createMedcin() {

        Medcin med = new Medcin();
        med.setNom("AAAAAAAA");
        med.setPrenom("BBBBBB");
        create(med);
        
        return 1;
    }

}
