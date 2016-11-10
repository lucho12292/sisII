/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servicio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "Balance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Balance.findAll", query = "SELECT b FROM Balance b")
    , @NamedQuery(name = "Balance.findByNroBalance", query = "SELECT b FROM Balance b WHERE b.balancePK.nroBalance = :nroBalance")
    , @NamedQuery(name = "Balance.findByIdDepartamento", query = "SELECT b FROM Balance b WHERE b.balancePK.idDepartamento = :idDepartamento")
    , @NamedQuery(name = "Balance.findByIngreso", query = "SELECT b FROM Balance b WHERE b.ingreso = :ingreso")
    , @NamedQuery(name = "Balance.findByEgreso", query = "SELECT b FROM Balance b WHERE b.egreso = :egreso")
    , @NamedQuery(name = "Balance.findByDeudas", query = "SELECT b FROM Balance b WHERE b.deudas = :deudas")})
public class Balance implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BalancePK balancePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ingreso")
    private long ingreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "egreso")
    private long egreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deudas")
    private long deudas;
    @JoinColumn(name = "idDepartamento", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Departamento departamento;

    public Balance() {
    }

    public Balance(BalancePK balancePK) {
        this.balancePK = balancePK;
    }

    public Balance(BalancePK balancePK, long ingreso, long egreso, long deudas) {
        this.balancePK = balancePK;
        this.ingreso = ingreso;
        this.egreso = egreso;
        this.deudas = deudas;
    }

    public Balance(int nroBalance, int idDepartamento) {
        this.balancePK = new BalancePK(nroBalance, idDepartamento);
    }

    public BalancePK getBalancePK() {
        return balancePK;
    }

    public void setBalancePK(BalancePK balancePK) {
        this.balancePK = balancePK;
    }

    public long getIngreso() {
        return ingreso;
    }

    public void setIngreso(long ingreso) {
        this.ingreso = ingreso;
    }

    public long getEgreso() {
        return egreso;
    }

    public void setEgreso(long egreso) {
        this.egreso = egreso;
    }

    public long getDeudas() {
        return deudas;
    }

    public void setDeudas(long deudas) {
        this.deudas = deudas;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (balancePK != null ? balancePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Balance)) {
            return false;
        }
        Balance other = (Balance) object;
        if ((this.balancePK == null && other.balancePK != null) || (this.balancePK != null && !this.balancePK.equals(other.balancePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.servicio.Balance[ balancePK=" + balancePK + " ]";
    }
    
}
