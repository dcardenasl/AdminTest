/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Centro de Trabajo
 */
@Entity
@Table(name = "numeroprioridad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Numeroprioridad.findAll", query = "SELECT n FROM Numeroprioridad n")
    , @NamedQuery(name = "Numeroprioridad.findByIdnumeroPrioridad", query = "SELECT n FROM Numeroprioridad n WHERE n.idnumeroPrioridad = :idnumeroPrioridad")
    , @NamedQuery(name = "Numeroprioridad.findByNombrePrioridad", query = "SELECT n FROM Numeroprioridad n WHERE n.nombrePrioridad = :nombrePrioridad")})
public class Numeroprioridad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idnumeroPrioridad")
    private Integer idnumeroPrioridad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombrePrioridad")
    private String nombrePrioridad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroPrioridad")
    private List<Prioridades> prioridadesList;

    public Numeroprioridad() {
    }

    public Numeroprioridad(Integer idnumeroPrioridad) {
        this.idnumeroPrioridad = idnumeroPrioridad;
    }

    public Numeroprioridad(Integer idnumeroPrioridad, String nombrePrioridad) {
        this.idnumeroPrioridad = idnumeroPrioridad;
        this.nombrePrioridad = nombrePrioridad;
    }

    public Integer getIdnumeroPrioridad() {
        return idnumeroPrioridad;
    }

    public void setIdnumeroPrioridad(Integer idnumeroPrioridad) {
        this.idnumeroPrioridad = idnumeroPrioridad;
    }

    public String getNombrePrioridad() {
        return nombrePrioridad;
    }

    public void setNombrePrioridad(String nombrePrioridad) {
        this.nombrePrioridad = nombrePrioridad;
    }

    @XmlTransient
    public List<Prioridades> getPrioridadesList() {
        return prioridadesList;
    }

    public void setPrioridadesList(List<Prioridades> prioridadesList) {
        this.prioridadesList = prioridadesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnumeroPrioridad != null ? idnumeroPrioridad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Numeroprioridad)) {
            return false;
        }
        Numeroprioridad other = (Numeroprioridad) object;
        if ((this.idnumeroPrioridad == null && other.idnumeroPrioridad != null) || (this.idnumeroPrioridad != null && !this.idnumeroPrioridad.equals(other.idnumeroPrioridad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.Numeroprioridad[ idnumeroPrioridad=" + idnumeroPrioridad + " ]";
    }
    
}
