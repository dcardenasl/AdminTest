/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pojos.Cotizacion;

/**
 *
 * @author Centro de Trabajo
 */
@Stateless
public class CotizacionFacade extends AbstractFacade<Cotizacion> implements CotizacionFacadeLocal {

    @PersistenceContext(unitName = "AdminTest-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CotizacionFacade() {
        super(Cotizacion.class);
    }
    
}
