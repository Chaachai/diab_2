/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Utilisateur;

/**
 *
 * @author CHAACHAI Youssef
 */
public class UtilisateutFacade extends AbstractFacade<Utilisateur> {

    public UtilisateutFacade() {
        super(Utilisateur.class);
    }

    public int createUser() {

        Utilisateur user = new Utilisateur();
        user.setNom("CHIADMI");
        user.setPrenom("Hamza");
        create(user);
        
        return 1;
    }

}
