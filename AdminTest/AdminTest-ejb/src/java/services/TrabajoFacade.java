/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pojos.Trabajo;

/**
 *
 * @author Centro de Trabajo
 */
@Stateless
public class TrabajoFacade extends AbstractFacade<Trabajo> implements TrabajoFacadeLocal {

    @PersistenceContext(unitName = "AdminTest-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrabajoFacade() {
        super(Trabajo.class);
    }
    
}
