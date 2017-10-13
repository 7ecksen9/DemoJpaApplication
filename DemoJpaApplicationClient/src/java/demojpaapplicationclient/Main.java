/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojpaapplicationclient;

import ejb.session.stateless.PersonEntityControllerRemote;
import entity.PersonEntity;
import javax.ejb.EJB;

/**
 *
 * @author Teck_
 */
public class Main {

    @EJB
    private static PersonEntityControllerRemote personEntityControllerRemote;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersonEntity personEntity = new PersonEntity("Teck Seng", "Koh");
        personEntity = personEntityControllerRemote.persistNewPersonEntity(personEntity);
        System.out.println("Person entity created: " + personEntity.getId());
    }

}
