/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Departamentos;
import Modelo.Empleados;

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
    	
    private static EntityManager em = DepartamentoController.getEmf().createEntityManager();
    public static void Lista(){
     Query q1 = em.createQuery("select numemp from Empleados ", Empleados.class);
     Query q2 = em.createQuery("select nombre from Empleados ", Empleados.class);
     Query q3 = em.createQuery("select trabajo from Empleados ", Empleados.class);
     Query q4 = em.createQuery("select fechacontrato from Empleados ", Empleados.class);
     Query q5 = em.createQuery("select salario from Empleados ", Empleados.class);
     Query q6 = em.createQuery("select comision from Empleados ", Empleados.class);
     Query q7 = em.createQuery("select numdept from Empleados ", Empleados.class);
     System.out.println("Numero Empleado:"+q1.getResultList());
     System.out.println("Nombre:"+q2.getResultList());
     System.out.println("Trabajo:"+q3.getResultList());
     System.out.println("Fecha del contrato:"+q4.getResultList());
     System.out.println("Salario:"+q5.getResultList());
     System.out.println("Comision:"+q6.getResultList());
     System.out.println("Numero del departamento:"+q7.getResultList());
        
    }
    
  
    
    
    public static void Buscar(short id){
       
            	  
     Query q1 = em.createQuery("select nombre from Empleados where numemp = "+id, Empleados.class);
     Query q2 = em.createQuery("select trabajo from Empleados where numemp = "+id, Empleados.class);
     Query q3 = em.createQuery("select fechacontrato from Empleados where numemp = "+id, Empleados.class);
     Query q4 = em.createQuery("select salario from Empleados where numemp = "+id, Empleados.class);
     Query q5 = em.createQuery("select comision from Empleados where numemp = "+id, Empleados.class);
     Query q6 = em.createQuery("select numdept from Empleados  numemp = "+id, Empleados.class);
     
     System.out.println("Nombre:"+q1.getSingleResult());
     System.out.println("Trabajo:"+q2.getResultList());
     System.out.println("Fecha del contrato:"+q3.getResultList());
     System.out.println("Salario:"+q4.getResultList());
     System.out.println("Comision:"+q5.getResultList());
     System.out.println("Numero del departamento:"+q6.getResultList());
            
         
            
        
       
    }
    
    public static void almacenarNuevo(Empleados d, Departamentos ed) {

                
		
                Departamentos e= null;
              
		
		em.getTransaction().begin();
		Empleados D = new Empleados(d.getNumemp(),d.getNombre(),d.getFechacontrato());
                e = new Departamentos(ed.getNumdept());
                D.setTrabajo(d.getTrabajo());
                D.setSalario(d.getSalario());
                D.setComision(d.getComision());
                D.setNumdept(e);
		
                em.persist(D);
		em.getTransaction().commit();
                em.close();
		
		
              

    }
    
     public static void almacenarModificado(Empleados d, Departamentos ed){
        	
         
         Empleados D = new Empleados();
                D = em.find(Empleados.class, d.getNumemp());
                em.getTransaction().begin();
                D.setNombre(d.getNombre());
                D.setFechacontrato(d.getFechacontrato());
                D.setTrabajo(d.getTrabajo());
                D.setSalario(d.getSalario());
                D.setComision(d.getComision());
                D.setNumdept(ed);
                
                em.getTransaction().commit();
                em.close();
    }
     
     public static void eliminar(Empleados d){
         Empleados D = new Empleados();
         D = em.find(Empleados.class, d.getNumemp());
         em.getTransaction().begin();
         em.remove(D);
         em.getTransaction().commit();
         em.close();

    }
}
