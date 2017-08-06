/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pojos.Prioridades;

/**
 *
 * @author Centro de Trabajo
 */
@Stateless
public class PrioridadesFacade extends AbstractFacade<Prioridades> implements PrioridadesFacadeLocal {

    @PersistenceContext(unitName = "AdminTest-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrioridadesFacade() {
        super(Prioridades.class);
    }
    
}
