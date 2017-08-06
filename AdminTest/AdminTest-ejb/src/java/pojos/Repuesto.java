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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Centro de Trabajo
 */
@Entity
@Table(name = "repuesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Repuesto.findAll", query = "SELECT r FROM Repuesto r")
    , @NamedQuery(name = "Repuesto.findById", query = "SELECT r FROM Repuesto r WHERE r.id = :id")
    , @NamedQuery(name = "Repuesto.findByNombreRepuesto", query = "SELECT r FROM Repuesto r WHERE r.nombreRepuesto = :nombreRepuesto")
    , @NamedQuery(name = "Repuesto.findByCantidad", query = "SELECT r FROM Repuesto r WHERE r.cantidad = :cantidad")
    , @NamedQuery(name = "Repuesto.findByMedida", query = "SELECT r FROM Repuesto r WHERE r.medida = :medida")
    , @NamedQuery(name = "Repuesto.findByValor", query = "SELECT r FROM Repuesto r WHERE r.valor = :valor")
    , @NamedQuery(name = "Repuesto.findByEstado", query = "SELECT r FROM Repuesto r WHERE r.estado = :estado")
    , @NamedQuery(name = "Repuesto.findByFechaTerminado", query = "SELECT r FROM Repuesto r WHERE r.fechaTerminado = :fechaTerminado")})
public class Repuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreRepuesto")
    private String nombreRepuesto;
    @Column(name = "cantidad")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "medida")
    private Double medida;
    @Column(name = "valor")
    private Integer valor;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fechaTerminado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTerminado;
    @JoinColumn(name = "cotizacion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cotizacion cotizacion;

    public Repuesto() {
    }

    public Repuesto(Integer id) {
        this.id = id;
    }

    public Repuesto(Integer id, String nombreRepuesto) {
        this.id = id;
        this.nombreRepuesto = nombreRepuesto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreRepuesto() {
        return nombreRepuesto;
    }

    public void setNombreRepuesto(String nombreRepuesto) {
        this.nombreRepuesto = nombreRepuesto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getMedida() {
        return medida;
    }

    public void setMedida(Double medida) {
        this.medida = medida;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaTerminado() {
        return fechaTerminado;
    }

    public void setFechaTerminado(Date fechaTerminado) {
        this.fechaTerminado = fechaTerminado;
    }

    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
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
        if (!(object instanceof Repuesto)) {
            return false;
        }
        Repuesto other = (Repuesto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.Repuesto[ id=" + id + " ]";
    }
    
}
