/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servicio;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author rodrigo
 * @author LuisMaldonado
 */
@Entity
@Table(name = "Vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v")
    , @NamedQuery(name = "Vehiculo.findByNroMotor", query = "SELECT v FROM Vehiculo v WHERE v.nroMotor = :nroMotor")
    , @NamedQuery(name = "Vehiculo.findByChasis", query = "SELECT v FROM Vehiculo v WHERE v.chasis = :chasis")})
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nroMotor")
    private Integer nroMotor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "chasis")
    private String chasis;
    @JoinColumn(name = "modelo", referencedColumnName = "idModelo")
    @ManyToOne(optional = false)
    private Modelo modelo;
    @JoinColumn(name = "tipo", referencedColumnName = "idTipoVehiculo")
    @ManyToOne(optional = false)
    private TipoVehiculo tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "auto")
    private Collection<DetalleVenta> detalleVentaCollection;

    public Vehiculo() {
    }

    public Vehiculo(Integer nroMotor) {
        this.nroMotor = nroMotor;
    }

    public Vehiculo(Integer nroMotor, String chasis) {
        this.nroMotor = nroMotor;
        this.chasis = chasis;
    }

    public Integer getNroMotor() {
        return nroMotor;
    }

    public void setNroMotor(Integer nroMotor) {
        this.nroMotor = nroMotor;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public TipoVehiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<DetalleVenta> getDetalleVentaCollection() {
        return detalleVentaCollection;
    }

    public void setDetalleVentaCollection(Collection<DetalleVenta> detalleVentaCollection) {
        this.detalleVentaCollection = detalleVentaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroMotor != null ? nroMotor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.nroMotor == null && other.nroMotor != null) || (this.nroMotor != null && !this.nroMotor.equals(other.nroMotor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.servicio.Vehiculo[ nroMotor=" + nroMotor + " ]";
    }
    
}
