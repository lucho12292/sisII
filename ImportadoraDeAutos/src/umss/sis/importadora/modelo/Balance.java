/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umss.sis.importadora.modelo;

import java.io.Serializable;

/**
 *
 * @author rodrigo
 * @author LuisMaldonado
 */

public class Balance implements Serializable {
    
    private int nroBalance;    
    private int idDepartamento;
    private long ingreso;
    private long egreso;
    private long deudas;

    public Balance() {
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
        int hash = 5;
        hash = 79 * hash + this.nroBalance;
        hash = 79 * hash + this.idDepartamento;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Balance other = (Balance) obj;
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
        return "Balance{" + "nroBalance=" + nroBalance + ", idDepartamento=" + idDepartamento + ", ingreso=" + ingreso + ", egreso=" + egreso + ", deudas=" + deudas + '}';
    }
}
