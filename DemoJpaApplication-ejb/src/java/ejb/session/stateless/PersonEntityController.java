/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.PersonEntity;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Teck_
 */
@Stateless
@Local(PersonEntityControllerLocal.class)
@Remote(PersonEntityControllerRemote.class)
public class PersonEntityController implements PersonEntityControllerRemote, PersonEntityControllerLocal {

    @PersistenceContext(unitName = "DemoJpaApplication-ejbPU")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public PersonEntity persistNewPersonEntity(PersonEntity personEntity) {
        em.persist(personEntity);
        em.flush();
        em.refresh(personEntity);
        return personEntity;
    }
}
