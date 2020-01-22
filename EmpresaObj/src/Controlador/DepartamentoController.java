/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Departamentos;
import Modelo.Empleados;
import Modelo.Presupuesto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author  Antonio Jose Adamuz Sereno
 */
public class DepartamentoController{
    private static final String TABLE_NAME = "departamentos";
    private static  EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/departamentos.odb");	
    private static EntityManager em = emf.createEntityManager();
    public static List<Departamentos> getAll(){
        List<Departamentos> list = new ArrayList<Departamentos>();
       
	    
       
            Query q1 = getEm().createQuery("select * from Departamentos ", Departamentos.class);
           // d = new Departamentos();
       
        return list;
    }
    
  
    
    
    public static Departamentos get(short id){
       
        Departamentos d = null;
            		
	   
       
            Query q1 = getEm().createQuery("select * from Departamentos Num_dept = "+id, Departamentos.class);
            d = new Departamentos();
            d.setNumdept(id);
            
        return d;
       
    }
    
    public static void almacenarNuevo(Departamentos d) {

                
		
                Empleados e= null;
                Presupuesto p=null;
		
		getEm().getTransaction().begin();
		Departamentos D = new Departamentos(d.getNumdept(), d.getNombre());
              //  e = new Empleados(e.getNumemp(),e.getNombre(),e.getFechacontrato());
               // p = new Presupuesto(p.getPresupuestoPK());
                //d.setPresupuestoList((List<Presupuesto>) p);
              //  d.setEmpleadosList((List<Empleados>) e);
		D.setLocalizacion(d.getLocalizacion());
                getEm().persist(D);
		getEm().getTransaction().commit();
		
		
              

    }
    
     public static void almacenarModificado(Departamentos d){
        	Departamentos D = new Departamentos();
                D = getEm().find(Departamentos.class, d.getNumdept());
                getEm().getTransaction().begin();
                D.setNombre(d.getNombre());
                D.setLocalizacion(d.getLocalizacion());
                getEm().getTransaction().commit();
         
    }
     
     public static void eliminar(Departamentos d){
         Departamentos D = new Departamentos();
         D = getEm().find(Departamentos.class, d.getNumdept());
         getEm().getTransaction().begin();
         getEm().remove(D);
         getEm().getTransaction().commit();
        

    }

    /**
     * @return the emf
     */
    public static EntityManagerFactory getEmf() {
        return emf;
    }

    /**
     * @return the em
     */
    public static EntityManager getEm() {
        return em;
    }
    
    
    
}

