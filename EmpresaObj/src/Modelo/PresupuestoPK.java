/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author usuario
 */
@Embeddable
public class PresupuestoPK implements Serializable {

    public static PresupuestoPK get(java.sql.Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Basic(optional = false)
    @Column(name = "Num_dept")
    private short numdept;
    @Basic(optional = false)
    @Column(name = "Ano")
    @Temporal(TemporalType.DATE)
    private Date ano;

    public PresupuestoPK() {
    }

    public PresupuestoPK(short numdept, Date ano) {
        this.numdept = numdept;
        this.ano = ano;
    }

    public short getNumdept() {
        return numdept;
    }

    public void setNumdept(short numdept) {
        this.numdept = numdept;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numdept;
        hash += (ano != null ? ano.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PresupuestoPK)) {
            return false;
        }
        PresupuestoPK other = (PresupuestoPK) object;
        if (this.numdept != other.numdept) {
            return false;
        }
        if ((this.ano == null && other.ano != null) || (this.ano != null && !this.ano.equals(other.ano))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PresupuestoPK[ numdept=" + numdept + ", ano=" + ano + " ]";
    }
    
}

