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
 */
@Entity
@Table(name = "Empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByCIEmpleado", query = "SELECT e FROM Empleado e WHERE e.cIEmpleado = :cIEmpleado")
    , @NamedQuery(name = "Empleado.findByNombre", query = "SELECT e FROM Empleado e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Empleado.findByApellidos", query = "SELECT e FROM Empleado e WHERE e.apellidos = :apellidos")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CIEmpleado")
    private Integer cIEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Apellidos")
    private String apellidos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private Collection<Herramienta> herramientaCollection;
    @JoinColumn(name = "IdDepartamento", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Departamento idDepartamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private Collection<EmpleadoCargo> empleadoCargoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private Collection<Asistencia> asistenciaCollection;

    public Empleado() {
    }

    public Empleado(Integer cIEmpleado) {
        this.cIEmpleado = cIEmpleado;
    }

    public Empleado(Integer cIEmpleado, String nombre, String apellidos) {
        this.cIEmpleado = cIEmpleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Integer getCIEmpleado() {
        return cIEmpleado;
    }

    public void setCIEmpleado(Integer cIEmpleado) {
        this.cIEmpleado = cIEmpleado;
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

    @XmlTransient
    public Collection<Herramienta> getHerramientaCollection() {
        return herramientaCollection;
    }

    public void setHerramientaCollection(Collection<Herramienta> herramientaCollection) {
        this.herramientaCollection = herramientaCollection;
    }

    public Departamento getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Departamento idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    @XmlTransient
    public Collection<EmpleadoCargo> getEmpleadoCargoCollection() {
        return empleadoCargoCollection;
    }

    public void setEmpleadoCargoCollection(Collection<EmpleadoCargo> empleadoCargoCollection) {
        this.empleadoCargoCollection = empleadoCargoCollection;
    }

    @XmlTransient
    public Collection<Asistencia> getAsistenciaCollection() {
        return asistenciaCollection;
    }

    public void setAsistenciaCollection(Collection<Asistencia> asistenciaCollection) {
        this.asistenciaCollection = asistenciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cIEmpleado != null ? cIEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.cIEmpleado == null && other.cIEmpleado != null) || (this.cIEmpleado != null && !this.cIEmpleado.equals(other.cIEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.servicio.Empleado[ cIEmpleado=" + cIEmpleado + " ]";
    }
    
}
