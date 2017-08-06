/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import javax.ejb.Local;
import pojos.Trabajo;

/**
 *
 * @author Centro de Trabajo
 */
@Local
public interface TrabajoFacadeLocal {

    void create(Trabajo trabajo);

    void edit(Trabajo trabajo);

    void remove(Trabajo trabajo);

    Trabajo find(Object id);

    List<Trabajo> findAll();

    List<Trabajo> findRange(int[] range);

    int count();
    
}
