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
@Table(name = "tipotrabajo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipotrabajo.findAll", query = "SELECT t FROM Tipotrabajo t")
    , @NamedQuery(name = "Tipotrabajo.findById", query = "SELECT t FROM Tipotrabajo t WHERE t.id = :id")
    , @NamedQuery(name = "Tipotrabajo.findByNombre", query = "SELECT t FROM Tipotrabajo t WHERE t.nombre = :nombre")})
public class Tipotrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoTrabajo")
    private List<Trabajo> trabajoList;

    public Tipotrabajo() {
    }

    public Tipotrabajo(Integer id) {
        this.id = id;
    }

    public Tipotrabajo(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Trabajo> getTrabajoList() {
        return trabajoList;
    }

    public void setTrabajoList(List<Trabajo> trabajoList) {
        this.trabajoList = trabajoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipotrabajo)) {
            return false;
        }
        Tipotrabajo other = (Tipotrabajo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.Tipotrabajo[ id=" + id + " ]";
    }
    
}
