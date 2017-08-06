/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import javax.ejb.Local;
import pojos.Tipotrabajo;

/**
 *
 * @author Centro de Trabajo
 */
@Local
public interface TipotrabajoFacadeLocal {

    void create(Tipotrabajo tipotrabajo);

    void edit(Tipotrabajo tipotrabajo);

    void remove(Tipotrabajo tipotrabajo);

    Tipotrabajo find(Object id);

    List<Tipotrabajo> findAll();

    List<Tipotrabajo> findRange(int[] range);

    int count();
    
}
