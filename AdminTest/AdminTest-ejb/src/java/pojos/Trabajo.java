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
@Table(name = "trabajo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trabajo.findAll", query = "SELECT t FROM Trabajo t")
    , @NamedQuery(name = "Trabajo.findById", query = "SELECT t FROM Trabajo t WHERE t.id = :id")
    , @NamedQuery(name = "Trabajo.findByNombreTrabajo", query = "SELECT t FROM Trabajo t WHERE t.nombreTrabajo = :nombreTrabajo")
    , @NamedQuery(name = "Trabajo.findByCantidad", query = "SELECT t FROM Trabajo t WHERE t.cantidad = :cantidad")
    , @NamedQuery(name = "Trabajo.findByMedida", query = "SELECT t FROM Trabajo t WHERE t.medida = :medida")
    , @NamedQuery(name = "Trabajo.findByValor", query = "SELECT t FROM Trabajo t WHERE t.valor = :valor")
    , @NamedQuery(name = "Trabajo.findByEstado", query = "SELECT t FROM Trabajo t WHERE t.estado = :estado")
    , @NamedQuery(name = "Trabajo.findByFechaTerminado", query = "SELECT t FROM Trabajo t WHERE t.fechaTerminado = :fechaTerminado")})
public class Trabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreTrabajo")
    private String nombreTrabajo;
    @Column(name = "cantidad")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "medida")
    private Double medida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private int valor;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fechaTerminado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTerminado;
    @JoinColumn(name = "cotizacion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cotizacion cotizacion;
    @JoinColumn(name = "trabajadorTerminado", referencedColumnName = "id")
    @ManyToOne
    private Usuario trabajadorTerminado;
    @JoinColumn(name = "tipoTrabajo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tipotrabajo tipoTrabajo;

    public Trabajo() {
    }

    public Trabajo(Integer id) {
        this.id = id;
    }

    public Trabajo(Integer id, String nombreTrabajo, int valor) {
        this.id = id;
        this.nombreTrabajo = nombreTrabajo;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreTrabajo() {
        return nombreTrabajo;
    }

    public void setNombreTrabajo(String nombreTrabajo) {
        this.nombreTrabajo = nombreTrabajo;
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

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
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

    public Usuario getTrabajadorTerminado() {
        return trabajadorTerminado;
    }

    public void setTrabajadorTerminado(Usuario trabajadorTerminado) {
        this.trabajadorTerminado = trabajadorTerminado;
    }

    public Tipotrabajo getTipoTrabajo() {
        return tipoTrabajo;
    }

    public void setTipoTrabajo(Tipotrabajo tipoTrabajo) {
        this.tipoTrabajo = tipoTrabajo;
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
        if (!(object instanceof Trabajo)) {
            return false;
        }
        Trabajo other = (Trabajo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.Trabajo[ id=" + id + " ]";
    }
    
}
