/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servicio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author rodrigo
 */
@Embeddable
public class EmpleadoCargoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CIEmpleado")
    private int cIEmpleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCargo")
    private int iDCargo;

    public EmpleadoCargoPK() {
    }

    public EmpleadoCargoPK(Date fecha, int cIEmpleado, int iDCargo) {
        this.fecha = fecha;
        this.cIEmpleado = cIEmpleado;
        this.iDCargo = iDCargo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCIEmpleado() {
        return cIEmpleado;
    }

    public void setCIEmpleado(int cIEmpleado) {
        this.cIEmpleado = cIEmpleado;
    }

    public int getIDCargo() {
        return iDCargo;
    }

    public void setIDCargo(int iDCargo) {
        this.iDCargo = iDCargo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fecha != null ? fecha.hashCode() : 0);
        hash += (int) cIEmpleado;
        hash += (int) iDCargo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoCargoPK)) {
            return false;
        }
        EmpleadoCargoPK other = (EmpleadoCargoPK) object;
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        if (this.cIEmpleado != other.cIEmpleado) {
            return false;
        }
        if (this.iDCargo != other.iDCargo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.servicio.EmpleadoCargoPK[ fecha=" + fecha + ", cIEmpleado=" + cIEmpleado + ", iDCargo=" + iDCargo + " ]";
    }
    
}
