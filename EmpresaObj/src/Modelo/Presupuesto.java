/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "presupuesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Presupuesto.findAll", query = "SELECT p FROM Presupuesto p")
    , @NamedQuery(name = "Presupuesto.findByNumdept", query = "SELECT p FROM Presupuesto p WHERE p.presupuestoPK.numdept = :numdept")
    , @NamedQuery(name = "Presupuesto.findByAno", query = "SELECT p FROM Presupuesto p WHERE p.presupuestoPK.ano = :ano")
    , @NamedQuery(name = "Presupuesto.findByCantidad", query = "SELECT p FROM Presupuesto p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "Presupuesto.findByDesglose", query = "SELECT p FROM Presupuesto p WHERE p.desglose = :desglose")})
public class Presupuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PresupuestoPK presupuestoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Cantidad")
    private Float cantidad;
    @Column(name = "Desglose")
    private String desglose;
    @JoinColumn(name = "Num_dept", referencedColumnName = "Num_dept", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Departamentos departamentos;

    public Presupuesto() {
    }

    public Presupuesto(PresupuestoPK presupuestoPK) {
        this.presupuestoPK = presupuestoPK;
    }

    public Presupuesto(short numdept, Date ano) {
        this.presupuestoPK = new PresupuestoPK(numdept, ano);
    }

    public PresupuestoPK getPresupuestoPK() {
        return presupuestoPK;
    }

    public void setPresupuestoPK(PresupuestoPK presupuestoPK) {
        this.presupuestoPK = presupuestoPK;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public String getDesglose() {
        return desglose;
    }

    public void setDesglose(String desglose) {
        this.desglose = desglose;
    }

    public Departamentos getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (presupuestoPK != null ? presupuestoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Presupuesto)) {
            return false;
        }
        Presupuesto other = (Presupuesto) object;
        if ((this.presupuestoPK == null && other.presupuestoPK != null) || (this.presupuestoPK != null && !this.presupuestoPK.equals(other.presupuestoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Presupuesto[ presupuestoPK=" + presupuestoPK + " ]";
    }
    
}
