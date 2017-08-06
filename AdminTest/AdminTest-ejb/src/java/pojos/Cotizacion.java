/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Centro de Trabajo
 */
@Entity
@Table(name = "cotizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cotizacion.findAll", query = "SELECT c FROM Cotizacion c")
    , @NamedQuery(name = "Cotizacion.findById", query = "SELECT c FROM Cotizacion c WHERE c.id = :id")
    , @NamedQuery(name = "Cotizacion.findByFechaInicio", query = "SELECT c FROM Cotizacion c WHERE c.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Cotizacion.findByFecharTermino", query = "SELECT c FROM Cotizacion c WHERE c.fecharTermino = :fecharTermino")
    , @NamedQuery(name = "Cotizacion.findByEstadoTrabajo", query = "SELECT c FROM Cotizacion c WHERE c.estadoTrabajo = :estadoTrabajo")
    , @NamedQuery(name = "Cotizacion.findByEstadoPago", query = "SELECT c FROM Cotizacion c WHERE c.estadoPago = :estadoPago")
    , @NamedQuery(name = "Cotizacion.findByValorTotal", query = "SELECT c FROM Cotizacion c WHERE c.valorTotal = :valorTotal")
    , @NamedQuery(name = "Cotizacion.findByDescuento", query = "SELECT c FROM Cotizacion c WHERE c.descuento = :descuento")})
public class Cotizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fechaInicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "fecharTermino")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharTermino;
    @Size(max = 45)
    @Column(name = "estadoTrabajo")
    private String estadoTrabajo;
    @Size(max = 45)
    @Column(name = "estadoPago")
    private String estadoPago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorTotal")
    private Double valorTotal;
    @Column(name = "descuento")
    private Double descuento;
    @JoinColumn(name = "clienteMecanico", referencedColumnName = "id")
    @ManyToOne
    private Cliente clienteMecanico;
    @JoinColumn(name = "clienteEmpresa", referencedColumnName = "id")
    @ManyToOne
    private Cliente clienteEmpresa;
    @JoinColumn(name = "clienteDue\u00f1o", referencedColumnName = "id")
    @ManyToOne
    private Cliente clienteDueño;
    @JoinColumn(name = "tipoCotizacion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tipocotizacion tipoCotizacion;
    @JoinColumn(name = "usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "vehiculo", referencedColumnName = "id")
    @ManyToOne
    private Vehiculo vehiculo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cotizacion")
    private List<Trabajo> trabajoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cotizacion")
    private List<Repuesto> repuestoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cotizacion")
    private List<Prioridades> prioridadesList;

    public Cotizacion() {
    }

    public Cotizacion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFecharTermino() {
        return fecharTermino;
    }

    public void setFecharTermino(Date fecharTermino) {
        this.fecharTermino = fecharTermino;
    }

    public String getEstadoTrabajo() {
        return estadoTrabajo;
    }

    public void setEstadoTrabajo(String estadoTrabajo) {
        this.estadoTrabajo = estadoTrabajo;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Cliente getClienteMecanico() {
        return clienteMecanico;
    }

    public void setClienteMecanico(Cliente clienteMecanico) {
        this.clienteMecanico = clienteMecanico;
    }

    public Cliente getClienteEmpresa() {
        return clienteEmpresa;
    }

    public void setClienteEmpresa(Cliente clienteEmpresa) {
        this.clienteEmpresa = clienteEmpresa;
    }

    public Cliente getClienteDueño() {
        return clienteDueño;
    }

    public void setClienteDueño(Cliente clienteDueño) {
        this.clienteDueño = clienteDueño;
    }

    public Tipocotizacion getTipoCotizacion() {
        return tipoCotizacion;
    }

    public void setTipoCotizacion(Tipocotizacion tipoCotizacion) {
        this.tipoCotizacion = tipoCotizacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @XmlTransient
    public List<Trabajo> getTrabajoList() {
        return trabajoList;
    }

    public void setTrabajoList(List<Trabajo> trabajoList) {
        this.trabajoList = trabajoList;
    }

    @XmlTransient
    public List<Repuesto> getRepuestoList() {
        return repuestoList;
    }

    public void setRepuestoList(List<Repuesto> repuestoList) {
        this.repuestoList = repuestoList;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cotizacion)) {
            return false;
        }
        Cotizacion other = (Cotizacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.Cotizacion[ id=" + id + " ]";
    }
    
}
