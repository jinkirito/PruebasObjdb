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
public class EmpleadosController {
    private static final String TABLE_NAME = "empleados";
    private static  EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/empleados.odb");	
    private static EntityManager em = emf.createEntityManager();
    public static List<Empleados> getAll(){
        List<Empleados> list = new ArrayList<Empleados>();
       
	    
       
            Query q1 = em.createQuery("select * from Empleados ", Empleados.class);
           // d = new Departamentos();
       
        return list;
    }
    
    public static void almacenar(Empleados d) {
        if (d.getNumdept() != null) { // Solo modificar
            almacenarModificado(d);
        } else { // Crear nuevo objeto en la BBDD
            almacenarNuevo(d);
        }
    }
    
    
    public static Empleados get(short id){
       
        Empleados d = null;
            		
	   
       
            Query q1 = em.createQuery("select * from Empleados numemp = "+id, Empleados.class);
            d = new Empleados();
            d.setNumemp(id);
            
        return d;
       
    }
    
    private static void almacenarNuevo(Empleados d) {

                
		
                Departamentos e= null;
                Presupuesto p=null;
		
		em.getTransaction().begin();
		Empleados D = new Empleados(d.getNumemp(),d.getNombre(),d.getFechacontrato());
                e = new Departamentos(e.getNumdept());
               
                d.setNumdept(e);
		
                em.persist(D);
		em.getTransaction().commit();
		
		
              

    }
    
     private static void almacenarModificado(Empleados d){
        	
         
         
         Query q1 = em.createQuery("update Empleados set Nombre = " +d.getNombre()+ ", set fechacontrato = " +d.getFechacontrato()+ "where Num_dept = "+d.getNumemp(), Empleados.class);
         d = new Empleados();
         
    }
     
     public static void eliminar(Empleados d){

        

    }
}
