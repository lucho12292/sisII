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
 * @author LuisMaldonado
 */
@Embeddable
public class AsistenciaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CIEmpleado")
    private int cIEmpleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDEstado")
    private int iDEstado;

    public AsistenciaPK() {
    }

    public AsistenciaPK(Date fecha, int cIEmpleado, int iDEstado) {
        this.fecha = fecha;
        this.cIEmpleado = cIEmpleado;
        this.iDEstado = iDEstado;
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

    public int getIDEstado() {
        return iDEstado;
    }

    public void setIDEstado(int iDEstado) {
        this.iDEstado = iDEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fecha != null ? fecha.hashCode() : 0);
        hash += (int) cIEmpleado;
        hash += (int) iDEstado;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsistenciaPK)) {
            return false;
        }
        AsistenciaPK other = (AsistenciaPK) object;
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        if (this.cIEmpleado != other.cIEmpleado) {
            return false;
        }
        if (this.iDEstado != other.iDEstado) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.servicio.AsistenciaPK[ fecha=" + fecha + ", cIEmpleado=" + cIEmpleado + ", iDEstado=" + iDEstado + " ]";
    }
    
}
