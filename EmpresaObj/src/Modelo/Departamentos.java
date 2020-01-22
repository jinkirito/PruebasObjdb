/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "departamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamentos.findAll", query = "SELECT d FROM Departamentos d")
    , @NamedQuery(name = "Departamentos.findByNumdept", query = "SELECT d FROM Departamentos d WHERE d.numdept = :numdept")
    , @NamedQuery(name = "Departamentos.findByNombre", query = "SELECT d FROM Departamentos d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "Departamentos.findByLocalizacion", query = "SELECT d FROM Departamentos d WHERE d.localizacion = :localizacion")})
public class Departamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Num_dept")
    private Short numdept;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Localizacion")
    private String localizacion;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "departamentos", fetch = FetchType.LAZY)
    //private List<Presupuesto> presupuestoList;
    @OneToMany(mappedBy = "numdept", fetch = FetchType.LAZY)
    private List<Empleados> empleadosList;

    public Departamentos() {
    }

    public Departamentos(Short numdept) {
        this.numdept = numdept;
    }

    public Departamentos(Short numdept, String nombre) {
        this.numdept = numdept;
        this.nombre = nombre;
    }

    public Departamentos(Short numemp, String nombre, Date fechacontrato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Short getNumdept() {
        return numdept;
    }

    public void setNumdept(Short numdept) {
        this.numdept = numdept;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

   // @XmlTransient
  //  public List<Presupuesto> getPresupuestoList() {
  //      return presupuestoList;
  //  }

  //  public void setPresupuestoList(List<Presupuesto> presupuestoList) {
  //      this.presupuestoList = presupuestoList;
  //  }

    @XmlTransient
    public List<Empleados> getEmpleadosList() {
        return empleadosList;
    }

    public void setEmpleadosList(List<Empleados> empleadosList) {
        this.empleadosList = empleadosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numdept != null ? numdept.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamentos)) {
            return false;
        }
        Departamentos other = (Departamentos) object;
        if ((this.numdept == null && other.numdept != null) || (this.numdept != null && !this.numdept.equals(other.numdept))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Departamentos[ numdept=" + numdept + " ]";
    }
    
}

