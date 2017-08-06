/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import javax.ejb.Local;
import pojos.Repuesto;

/**
 *
 * @author Centro de Trabajo
 */
@Local
public interface RepuestoFacadeLocal {

    void create(Repuesto repuesto);

    void edit(Repuesto repuesto);

    void remove(Repuesto repuesto);

    Repuesto find(Object id);

    List<Repuesto> findAll();

    List<Repuesto> findRange(int[] range);

    int count();
    
}
