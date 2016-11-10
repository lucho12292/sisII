/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umss.sis.importadora.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author rodrigo
 * @author LuisMaldonado
 */
@Embeddable
public class BalancePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "nroBalance")
    private int nroBalance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDepartamento")
    private int idDepartamento;

    public BalancePK() {
    }

    public BalancePK(int nroBalance, int idDepartamento) {
        this.nroBalance = nroBalance;
        this.idDepartamento = idDepartamento;
    }

    public int getNroBalance() {
        return nroBalance;
    }

    public void setNroBalance(int nroBalance) {
        this.nroBalance = nroBalance;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) nroBalance;
        hash += (int) idDepartamento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BalancePK)) {
            return false;
        }
        BalancePK other = (BalancePK) object;
        if (this.nroBalance != other.nroBalance) {
            return false;
        }
        if (this.idDepartamento != other.idDepartamento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.servicio.BalancePK[ nroBalance=" + nroBalance + ", idDepartamento=" + idDepartamento + " ]";
    }
    
}
