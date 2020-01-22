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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author  Antonio Jose Adamuz Sereno
 */
@Entity
@Table(name = "empleados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e")
    , @NamedQuery(name = "Empleados.findByNumemp", query = "SELECT e FROM Empleados e WHERE e.numemp = :numemp")
    , @NamedQuery(name = "Empleados.findByNombre", query = "SELECT e FROM Empleados e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Empleados.findByTrabajo", query = "SELECT e FROM Empleados e WHERE e.trabajo = :trabajo")
    , @NamedQuery(name = "Empleados.findByFechacontrato", query = "SELECT e FROM Empleados e WHERE e.fechacontrato = :fechacontrato")
    , @NamedQuery(name = "Empleados.findBySalario", query = "SELECT e FROM Empleados e WHERE e.salario = :salario")
    , @NamedQuery(name = "Empleados.findByComision", query = "SELECT e FROM Empleados e WHERE e.comision = :comision")})
public class Empleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Num_emp")
    private Short numemp;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Trabajo")
    private String trabajo;
    @Basic(optional = false)
    @Column(name = "Fecha_contrato")
    @Temporal(TemporalType.TIMESTAMP)
    private String fechacontrato;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Salario")
    private Float salario;
    @Column(name = "Comision")
    private Float comision;
    @JoinColumn(name = "Num_dept", referencedColumnName = "Num_dept")
    @ManyToOne(fetch = FetchType.LAZY)
    private Departamentos numdept;
    @OneToMany(mappedBy = "supervisor", fetch = FetchType.LAZY)
    private List<Empleados> empleadosList;
    @JoinColumn(name = "Supervisor", referencedColumnName = "Num_emp")
    @ManyToOne(fetch = FetchType.LAZY)
    private Empleados supervisor;

    public Empleados() {
    }

    public Empleados(Short numemp) {
        this.numemp = numemp;
    }

    public Empleados(Short numemp, String nombre, String fechacontrato) {
        this.numemp = numemp;
        this.nombre = nombre;
        this.fechacontrato = fechacontrato;
    }

    public Short getNumemp() {
        return numemp;
    }

    public void setNumemp(Short numemp) {
        this.numemp = numemp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public String getFechacontrato() {
        return fechacontrato;
    }

    public void setFechacontrato(String fechacontrato) {
        this.fechacontrato = fechacontrato;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public Float getComision() {
        return comision;
    }

    public void setComision(Float comision) {
        this.comision = comision;
    }

    public Departamentos getNumdept() {
        return numdept;
    }

    public void setNumdept(Departamentos numdept) {
        this.numdept = numdept;
    }

    @XmlTransient
    public List<Empleados> getEmpleadosList() {
        return empleadosList;
    }

    public void setEmpleadosList(List<Empleados> empleadosList) {
        this.empleadosList = empleadosList;
    }

    public Empleados getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Empleados supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numemp != null ? numemp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.numemp == null && other.numemp != null) || (this.numemp != null && !this.numemp.equals(other.numemp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Empleados[ numemp=" + numemp + " ]";
    }
    
}

