/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import javax.ejb.Local;
import pojos.Prioridades;

/**
 *
 * @author Centro de Trabajo
 */
@Local
public interface PrioridadesFacadeLocal {

    void create(Prioridades prioridades);

    void edit(Prioridades prioridades);

    void remove(Prioridades prioridades);

    Prioridades find(Object id);

    List<Prioridades> findAll();

    List<Prioridades> findRange(int[] range);

    int count();
    
}
