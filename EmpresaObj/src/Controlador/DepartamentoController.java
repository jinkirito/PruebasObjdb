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
       
	    
       
            Query q1 = em.createQuery("select * from Departamentos ", Departamentos.class);
           // d = new Departamentos();
       
        return list;
    }
    
    public static void almacenar(Departamentos d) {
        if (d.getNumdept() != null) { // Solo modificar
            almacenarModificado(d);
        } else { // Crear nuevo objeto en la BBDD
            almacenarNuevo(d);
        }
    }
    
    
    public static Departamentos get(short id){
       
        Departamentos d = null;
            		
	   
       
            Query q1 = em.createQuery("select * from Departamentos Num_dept = "+id, Departamentos.class);
            d = new Departamentos();
            d.setNumdept(id);
            
        return d;
       
    }
    
    private static void almacenarNuevo(Departamentos d) {

                
		
                Empleados e= null;
                Presupuesto p=null;
		
		em.getTransaction().begin();
		Departamentos D = new Departamentos(d.getNumdept(), "hola");
                //e = new Empleados(e.getNumemp(),e.getNombre(),e.getFechacontrato());
               // p = new Presupuesto(p.getPresupuestoPK());
                //d.setPresupuestoList((List<Presupuesto>) p);
                //d.setEmpleadosList((List<Empleados>) e);
		
                em.persist(D);
		em.getTransaction().commit();
		
		
              

    }
    
     private static void almacenarModificado(Departamentos d){
        	
         
         
         Query q1 = em.createQuery("update Departamentos set Nombre = "+d.getNombre()+"where Num_dept = "+d.getNumdept(), Departamentos.class);
         d = new Departamentos();
         
    }
     
     public static void eliminar(Departamentos d){

        

    }
    
    
    
}

