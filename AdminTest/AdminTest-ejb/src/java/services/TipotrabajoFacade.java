/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pojos.Tipotrabajo;

/**
 *
 * @author Centro de Trabajo
 */
@Stateless
public class TipotrabajoFacade extends AbstractFacade<Tipotrabajo> implements TipotrabajoFacadeLocal {

    @PersistenceContext(unitName = "AdminTest-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipotrabajoFacade() {
        super(Tipotrabajo.class);
    }
    
}
