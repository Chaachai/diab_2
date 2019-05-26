/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Utilisateur;
import java.util.List;
import org.eclipse.persistence.internal.oxm.mappings.Login;

/**
 *
 * @author CHAACHAI Youssef
 */
public class UtilisateurFacade extends AbstractFacade<Utilisateur> {

    public UtilisateurFacade() {
        super(Utilisateur.class);
    }

    public int createUser() {

        Utilisateur user = new Utilisateur();
        user.setNom("CHIADMI");
        user.setPrenom("Hamza");
        create(user);

        return 1;
    }

    public Utilisateur getUtilisateurByTelOrEmail(String identifiant) {
        List<Utilisateur> utilisateurs = findAll();
        for (Utilisateur utilisateur : utilisateurs) {
            System.out.println(utilisateur.getNom());
            if (utilisateur.getTelephone().equals(identifiant) || utilisateur.getEmail().equals(identifiant)) {
                System.out.println("Found !");
                return utilisateur;
            }
        }
        System.out.println("Nothing");
        return null;
    }
    public int seConnecter(String Login , String password) {
        Utilisateur LoadedUser = getUtilisateurByTelOrEmail(Login);
        if (LoadedUser == null) {
            System.out.println("erreur");
            return -1;
        } else if (!LoadedUser.getPassword().equals(password)) {
            System.out.println("password wrong !!");
            return -2;
        } else {
            if(LoadedUser.getRole() == 1){
                System.out.println("vous etes patient");
               
            }
            else {
                System.out.println("vous etes medcin");
              
            }
            return 1 ;
        }
    };

}
