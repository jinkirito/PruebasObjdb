/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresaobj;

import Controlador.DepartamentoController;
import Modelo.Departamentos;
import java.util.List;
import other.Utils;

/**
 *
 * @author usuario
 */
public class ManageDepartamento {
    public static void menuGestion() {

        int opcionElegida = -1;
        do {
            try {
                System.out.println("\n\t\t\tGESTION DE Departamentos");

                System.out.println("\n\t1.- Listado de Departamentos.");
                System.out.println("\t2.- Añadir de Departamentos.");
                System.out.println("\t3.- Modificacion de Departamentos.");
                System.out.println("\t4.- Eliminar de Departamentos.");
                System.out.println("\t0.- Salir");
                System.out.println("\n\tElija una opcion: ");

                opcionElegida = Utils.getIntConsola(0, 4);

                switch (opcionElegida) {
                    case 0:
                        break;
                    case 1:
                        listado(true);
                        break;
                    case 2:
                        alta();
                        break;
                    case 3:
                        modificacion();
                        break;
                    case 4:
                        baja();
                        break;
                }
            } catch (Exception e) {
                System.out.println("\n\t\t\tError de acceso a datos: " + e.getMessage() + "\n");
                e.printStackTrace();
            }
        } while (opcionElegida != 0);
    }
    
     protected static void listado(boolean pausafinal){
        List<Departamentos> list = DepartamentoController.getAll();
        System.out.println("\n\tListado de Departamentos: \n");
        for (Departamentos o : list) {
            System.out.println("\t" + o.getNumdept() + " - " + o.getNombre() + ", "  + o.getLocalizacion());
        }
        if (pausafinal) {
            System.out.println("\n\tPulse 'Intro' para continuar");
            Utils.pausa();
        }
    }
     
         private static void alta(){
        System.out.println("\n\tAñadir de Departamento\n");

        Departamentos o = new Departamentos();
        System.out.print("\nIntroduzca 'Numero de Departamento' del Departamento: ");
        o.setNumdept(Utils.getShortConsola());
        Utils.pausa();
        System.out.print("\nIntroduzca 'Nombre' del Departamento: ");
        o.setNombre(Utils.getStringConsola());
        System.out.print("\nIntroduzca 'Localizacion' del Departamento: ");
        o.setLocalizacion(Utils.getStringConsola());

        DepartamentoController.almacenarNuevo(o);

        System.out.println("\n\tInsertado correctamente!. Pulse 'Intro' para continuar");
        Utils.pausa();
    }
         
         private static void modificacion(){
        System.out.println("\n\tModificacion de Departamento\n");

        Departamentos o = new Departamentos();

        
            System.out.print("\nIntroduzca 'Numero de Departamento' del Departamento ('Intro' para no modificar): ");
            o.setNumdept(Utils.getShortConsola());
            Utils.pausa();
            System.out.print("\nIntroduzca 'Nombre' del Departamento ('Intro' para no modificar): ");
            o.setNombre(Utils.getStringConsola());
            System.out.print("\nIntroduzca 'Localizacion' del Departamento ('Intro' para no modificar): ");
            o.setLocalizacion(Utils.getStringConsola());
            
            DepartamentoController.almacenarModificado(o);

            System.out.println("\n\tModificado correctamente!. Pulse 'Intro' para continuar");
            Utils.pausa();
        
    }
         
         
         private static void baja(){
        System.out.println("\n\t Baja de Departamento\n");
        Departamentos o = new Departamentos();
        System.out.print("\nIntroduzca 'Numero de Departamento' del Departamento para eliminar ('Intro' para no Borrar): ");
        o.setNumdept(Utils.getShortConsola());
        DepartamentoController.eliminar(o);
        System.out.println("\n\tEliminado correctamente!. Pulse 'Intro' para continuar");
                Utils.pausa();

      /*  if (o != null) {
            System.out.print("\nRealmente desea eliminar el registro? (S/N): ");
            String str = Utils.getStringConsola();
            if (str.equalsIgnoreCase("S")) {
                DepartamentoController.eliminar(o);
                System.out.println("\n\tEliminado correctamente!. Pulse 'Intro' para continuar");
                Utils.pausa();
            }
        }*/
    } 
         
        
}
