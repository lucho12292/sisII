/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servicio;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rodrigo
 */
@Entity
@Table(name = "DetalleVenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleVenta.findAll", query = "SELECT d FROM DetalleVenta d")
    , @NamedQuery(name = "DetalleVenta.findByNroDetalle", query = "SELECT d FROM DetalleVenta d WHERE d.nroDetalle = :nroDetalle")
    , @NamedQuery(name = "DetalleVenta.findByTipoVenta", query = "SELECT d FROM DetalleVenta d WHERE d.tipoVenta = :tipoVenta")})
public class DetalleVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nroDetalle")
    private Integer nroDetalle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "tipoVenta")
    private String tipoVenta;
    @JoinColumn(name = "ciComprador", referencedColumnName = "ciComprador")
    @ManyToOne(optional = false)
    private Comprador ciComprador;
    @JoinColumn(name = "auto", referencedColumnName = "nroMotor")
    @ManyToOne(optional = false)
    private Vehiculo auto;

    public DetalleVenta() {
    }

    public DetalleVenta(Integer nroDetalle) {
        this.nroDetalle = nroDetalle;
    }

    public DetalleVenta(Integer nroDetalle, String tipoVenta) {
        this.nroDetalle = nroDetalle;
        this.tipoVenta = tipoVenta;
    }

    public Integer getNroDetalle() {
        return nroDetalle;
    }

    public void setNroDetalle(Integer nroDetalle) {
        this.nroDetalle = nroDetalle;
    }

    public String getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public Comprador getCiComprador() {
        return ciComprador;
    }

    public void setCiComprador(Comprador ciComprador) {
        this.ciComprador = ciComprador;
    }

    public Vehiculo getAuto() {
        return auto;
    }

    public void setAuto(Vehiculo auto) {
        this.auto = auto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroDetalle != null ? nroDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleVenta)) {
            return false;
        }
        DetalleVenta other = (DetalleVenta) object;
        if ((this.nroDetalle == null && other.nroDetalle != null) || (this.nroDetalle != null && !this.nroDetalle.equals(other.nroDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.servicio.DetalleVenta[ nroDetalle=" + nroDetalle + " ]";
    }
    
}
