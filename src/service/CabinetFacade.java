/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Cabinet;
import bean.Medcin;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author CHAACHAI Youssef
 */
public class CabinetFacade extends AbstractFacade<Cabinet> {

    public CabinetFacade() {
        super(Cabinet.class);
    }

    MedcinFacade mf = new MedcinFacade();

    public int createCabinet(String nom, String adresse, String telephone, Long idMedcin) {
        Cabinet cabinet = new Cabinet();
        Medcin medcin = mf.find(idMedcin);
        if (medcin != null) {
            cabinet.setNom(nom);
            cabinet.setAdresse(adresse);
            cabinet.setTelephone(telephone);
            cabinet.setMedcin(medcin);
            create(cabinet);
            return 1;
        }
        return -1;

    }

    public List<Cabinet> getCabinetsByMedcin(Long idMedcin) {
        List<Cabinet> cabinets = findAll();
        List<Cabinet> res = new ArrayList();
        for (Cabinet cabinet : cabinets) {
            if (Objects.equals(cabinet.getMedcin().getId(), idMedcin)) {
                res.add(cabinet);
            }
        }
        return res;
    }
    
     public List<Cabinet> findCabinetByName(String name) {
        String query = " SELECT c FROM Cabinet c WHERE c.nom LIKE '%" + name + "%' ";
        return getEntityManager().createQuery(query).getResultList();
    }

}
