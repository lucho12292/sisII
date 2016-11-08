/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servicio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rodrigo
 * @author LuisMaldonado
 */
@Entity
@Table(name = "EmpleadoCargo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpleadoCargo.findAll", query = "SELECT e FROM EmpleadoCargo e")
    , @NamedQuery(name = "EmpleadoCargo.findByFecha", query = "SELECT e FROM EmpleadoCargo e WHERE e.empleadoCargoPK.fecha = :fecha")
    , @NamedQuery(name = "EmpleadoCargo.findByCIEmpleado", query = "SELECT e FROM EmpleadoCargo e WHERE e.empleadoCargoPK.cIEmpleado = :cIEmpleado")
    , @NamedQuery(name = "EmpleadoCargo.findByIDCargo", query = "SELECT e FROM EmpleadoCargo e WHERE e.empleadoCargoPK.iDCargo = :iDCargo")})
public class EmpleadoCargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpleadoCargoPK empleadoCargoPK;
    @JoinColumn(name = "CIEmpleado", referencedColumnName = "CIEmpleado", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empleado empleado;
    @JoinColumn(name = "IDCargo", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cargo cargo;

    public EmpleadoCargo() {
    }

    public EmpleadoCargo(EmpleadoCargoPK empleadoCargoPK) {
        this.empleadoCargoPK = empleadoCargoPK;
    }

    public EmpleadoCargo(Date fecha, int cIEmpleado, int iDCargo) {
        this.empleadoCargoPK = new EmpleadoCargoPK(fecha, cIEmpleado, iDCargo);
    }

    public EmpleadoCargoPK getEmpleadoCargoPK() {
        return empleadoCargoPK;
    }

    public void setEmpleadoCargoPK(EmpleadoCargoPK empleadoCargoPK) {
        this.empleadoCargoPK = empleadoCargoPK;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleadoCargoPK != null ? empleadoCargoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoCargo)) {
            return false;
        }
        EmpleadoCargo other = (EmpleadoCargo) object;
        if ((this.empleadoCargoPK == null && other.empleadoCargoPK != null) || (this.empleadoCargoPK != null && !this.empleadoCargoPK.equals(other.empleadoCargoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.servicio.EmpleadoCargo[ empleadoCargoPK=" + empleadoCargoPK + " ]";
    }
    
}
