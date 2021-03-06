/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pojos.Repuesto;

/**
 *
 * @author Centro de Trabajo
 */
@Stateless
public class RepuestoFacade extends AbstractFacade<Repuesto> implements RepuestoFacadeLocal {

    @PersistenceContext(unitName = "AdminTest-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RepuestoFacade() {
        super(Repuesto.class);
    }
    
}
