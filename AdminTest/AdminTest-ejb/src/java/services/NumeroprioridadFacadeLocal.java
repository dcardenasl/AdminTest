/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import javax.ejb.Local;
import pojos.Numeroprioridad;

/**
 *
 * @author Centro de Trabajo
 */
@Local
public interface NumeroprioridadFacadeLocal {

    void create(Numeroprioridad numeroprioridad);

    void edit(Numeroprioridad numeroprioridad);

    void remove(Numeroprioridad numeroprioridad);

    Numeroprioridad find(Object id);

    List<Numeroprioridad> findAll();

    List<Numeroprioridad> findRange(int[] range);

    int count();
    
}
