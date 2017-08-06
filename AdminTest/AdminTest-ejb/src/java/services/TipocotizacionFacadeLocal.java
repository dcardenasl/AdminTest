/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import javax.ejb.Local;
import pojos.Tipocotizacion;

/**
 *
 * @author Centro de Trabajo
 */
@Local
public interface TipocotizacionFacadeLocal {

    void create(Tipocotizacion tipocotizacion);

    void edit(Tipocotizacion tipocotizacion);

    void remove(Tipocotizacion tipocotizacion);

    Tipocotizacion find(Object id);

    List<Tipocotizacion> findAll();

    List<Tipocotizacion> findRange(int[] range);

    int count();
    
}
