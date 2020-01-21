/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Departamentos;
import Modelo.Empleados;
import Modelo.Presupuesto;
import Modelo.PresupuestoPK;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author usuario
 */
public class PresupuestoController {
    private static final String TABLE_NAME = "Presupuesto";
    private static  EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/Presupuesto.odb");	
    private static EntityManager em = emf.createEntityManager();
    public static List<Presupuesto> getAll(){
        List<Presupuesto> list = new ArrayList<Presupuesto>();
       
	    
       
            Query q1 = em.createQuery("select * from Presupuesto ", Presupuesto.class);
           // d = new Departamentos();
       
        return list;
    }
    
  /*  public static void almacenar(PresupuestoPK d) {
        if (d.getNumdept() != null) { // Solo modificar
            almacenarModificado(d);
        } else { // Crear nuevo objeto en la BBDD
            almacenarNuevo(d);
        }
    }
    */
    
    public static Presupuesto get(short id){
       
        Presupuesto d = null;
        PresupuestoPK d2 = null;
        d2 = new PresupuestoPK();
        d2.setNumdept(id);
	   
       
            Query q1 = em.createQuery("select * from Presupuesto presupuestoPK.numdept = "+id, Presupuesto.class);
            d = new Presupuesto();
            d.setPresupuestoPK(d2);
            
        return d;
       
    }
    
    private static void almacenarNuevo(PresupuestoPK d) {

                
		
                Departamentos e= null;
                Empleados p=null;
                PresupuestoPK d2 = null;
		
		em.getTransaction().begin();
		Presupuesto D = new Presupuesto(d2.getNumdept(),d2.getAno());
                e = new Departamentos(e.getNumdept());
               
              //  d.setNumdept(e);
		
                em.persist(D);
		em.getTransaction().commit();
		
		
              

    }
    
   /*  private static void almacenarModificado(Empleados d){
        	
         
         
         Query q1 = em.createQuery("update Empleados set Nombre = " +d.getNombre()+ ", set fechacontrato = " +d.getFechacontrato()+ "where Num_dept = "+d.getNumemp(), Empleados.class);
         d = new Empleados();
         
    }
     
     public static void eliminar(Empleados d){

        

    }*/
}
