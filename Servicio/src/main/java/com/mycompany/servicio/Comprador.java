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
@Table(name = "Comprador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comprador.findAll", query = "SELECT c FROM Comprador c")
    , @NamedQuery(name = "Comprador.findByCiComprador", query = "SELECT c FROM Comprador c WHERE c.ciComprador = :ciComprador")
    , @NamedQuery(name = "Comprador.findByNombre", query = "SELECT c FROM Comprador c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Comprador.findByApellidos", query = "SELECT c FROM Comprador c WHERE c.apellidos = :apellidos")
    , @NamedQuery(name = "Comprador.findByCalleDomicilio", query = "SELECT c FROM Comprador c WHERE c.calleDomicilio = :calleDomicilio")
    , @NamedQuery(name = "Comprador.findByNroDomicilio", query = "SELECT c FROM Comprador c WHERE c.nroDomicilio = :nroDomicilio")
    , @NamedQuery(name = "Comprador.findByCiudad", query = "SELECT c FROM Comprador c WHERE c.ciudad = :ciudad")})
public class Comprador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ciComprador")
    private Integer ciComprador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "calleDomicilio")
    private String calleDomicilio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nroDomicilio")
    private String nroDomicilio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ciudad")
    private String ciudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciComprador")
    private Collection<DetalleVenta> detalleVentaCollection;

    public Comprador() {
    }

    public Comprador(Integer ciComprador) {
        this.ciComprador = ciComprador;
    }

    public Comprador(Integer ciComprador, String nombre, String apellidos, String calleDomicilio, String nroDomicilio, String ciudad) {
        this.ciComprador = ciComprador;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.calleDomicilio = calleDomicilio;
        this.nroDomicilio = nroDomicilio;
        this.ciudad = ciudad;
    }

    public Integer getCiComprador() {
        return ciComprador;
    }

    public void setCiComprador(Integer ciComprador) {
        this.ciComprador = ciComprador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCalleDomicilio() {
        return calleDomicilio;
    }

    public void setCalleDomicilio(String calleDomicilio) {
        this.calleDomicilio = calleDomicilio;
    }

    public String getNroDomicilio() {
        return nroDomicilio;
    }

    public void setNroDomicilio(String nroDomicilio) {
        this.nroDomicilio = nroDomicilio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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
        hash += (ciComprador != null ? ciComprador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comprador)) {
            return false;
        }
        Comprador other = (Comprador) object;
        if ((this.ciComprador == null && other.ciComprador != null) || (this.ciComprador != null && !this.ciComprador.equals(other.ciComprador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.servicio.Comprador[ ciComprador=" + ciComprador + " ]";
    }
    
}
