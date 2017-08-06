/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Centro de Trabajo
 */
@Entity
@Table(name = "prioridades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prioridades.findAll", query = "SELECT p FROM Prioridades p")
    , @NamedQuery(name = "Prioridades.findById", query = "SELECT p FROM Prioridades p WHERE p.id = :id")
    , @NamedQuery(name = "Prioridades.findByFecha", query = "SELECT p FROM Prioridades p WHERE p.fecha = :fecha")})
public class Prioridades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "cotizacion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cotizacion cotizacion;
    @JoinColumn(name = "numeroPrioridad", referencedColumnName = "idnumeroPrioridad")
    @ManyToOne(optional = false)
    private Numeroprioridad numeroPrioridad;

    public Prioridades() {
    }

    public Prioridades(Integer id) {
        this.id = id;
    }

    public Prioridades(Integer id, Date fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

    public Numeroprioridad getNumeroPrioridad() {
        return numeroPrioridad;
    }

    public void setNumeroPrioridad(Numeroprioridad numeroPrioridad) {
        this.numeroPrioridad = numeroPrioridad;
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
        if (!(object instanceof Prioridades)) {
            return false;
        }
        Prioridades other = (Prioridades) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.Prioridades[ id=" + id + " ]";
    }
    
}
