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
public class DepartamentoController{
    private static final String TABLE_NAME = "departamentos";
    private static  EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/departamentos.odb");	
    private static EntityManager em = emf.createEntityManager();
    
    public static void Lista(){
     Query q1 = getEm().createQuery("select numdept from Departamentos ", Departamentos.class);
     Query q2 = getEm().createQuery("select nombre from Departamentos ", Departamentos.class);
     Query q3 = getEm().createQuery("select localizacion from Departamentos ", Departamentos.class);
     System.out.println("Numero departamento:"+q1.getResultList());
     System.out.println("Nombre:"+q2.getResultList());
     System.out.println("Localizacion:"+q3.getResultList());
    }
    
  
    
    
    public static void Buscar(short id){
       
     Query q1 = em.createQuery("select nombre from Departamentos where numdept = "+id, Departamentos.class);
     Query q2 = em.createQuery("select localizacion from Departamentos where numdept = "+id, Departamentos.class);
     Query q3 = em.createQuery("select empleadosList from Departamentos where numdept = "+id, Departamentos.class);
     
     
     System.out.println("Nombre:"+q1.getSingleResult());
     System.out.println("Localizacion:"+q2.getResultList());
     System.out.println("Lista de Empleados:"+q3.getResultList());
    
       
    }
    
    public static void almacenarNuevo(Departamentos d) {

		getEm().getTransaction().begin();
		Departamentos D = new Departamentos(d.getNumdept(), d.getNombre());
		D.setLocalizacion(d.getLocalizacion());
                getEm().persist(D);
		getEm().getTransaction().commit();
                em.close();
    }
    
     public static void almacenarModificado(Departamentos d){
        	Departamentos D = new Departamentos();
                D = getEm().find(Departamentos.class, d.getNumdept());
                getEm().getTransaction().begin();
                D.setNombre(d.getNombre());
                D.setLocalizacion(d.getLocalizacion());
                getEm().getTransaction().commit();
                em.close();
         
    }
     
     public static void eliminar(Departamentos d){
         Departamentos D = new Departamentos();
         D = getEm().find(Departamentos.class, d.getNumdept());
         getEm().getTransaction().begin();
         getEm().remove(D);
         getEm().getTransaction().commit();
         em.close();
        

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

