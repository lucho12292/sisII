/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umss.sis.importadora.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rodrigo
 * @author LuisMaldonado
 */
@Entity
@Table(name = "Herramienta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Herramienta.findAll", query = "SELECT h FROM Herramienta h")
    , @NamedQuery(name = "Herramienta.findByIdHerramienta", query = "SELECT h FROM Herramienta h WHERE h.idHerramienta = :idHerramienta")
    , @NamedQuery(name = "Herramienta.findByEstado", query = "SELECT h FROM Herramienta h WHERE h.estado = :estado")})
public class Herramienta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idHerramienta")
    private Integer idHerramienta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @JoinColumn(name = "empleado", referencedColumnName = "CIEmpleado")
    @ManyToOne(optional = false)
    private Empleado empleado;

    public Herramienta() {
    }

    public Herramienta(Integer idHerramienta) {
        this.idHerramienta = idHerramienta;
    }

    public Herramienta(Integer idHerramienta, int estado) {
        this.idHerramienta = idHerramienta;
        this.estado = estado;
    }

    public Integer getIdHerramienta() {
        return idHerramienta;
    }

    public void setIdHerramienta(Integer idHerramienta) {
        this.idHerramienta = idHerramienta;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHerramienta != null ? idHerramienta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Herramienta)) {
            return false;
        }
        Herramienta other = (Herramienta) object;
        if ((this.idHerramienta == null && other.idHerramienta != null) || (this.idHerramienta != null && !this.idHerramienta.equals(other.idHerramienta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.servicio.Herramienta[ idHerramienta=" + idHerramienta + " ]";
    }
    
}
