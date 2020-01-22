/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresaobj;

import Controlador.EmpleadosController;
import Modelo.Departamentos;
import Modelo.Empleados;
import java.text.ParseException;
import java.util.List;
import other.Utils;

/**
 *
 * @author Antonio Jose Adamuz Sereno
 */
public class ManageEmpleados {

    public static void menuGestion() {

        int opcionElegida = -1;
        do {
            try {
                System.out.println("\n\t\t\tGESTION DE Empleados");

                System.out.println("\n\t1.- Listado de Empleados.");
                System.out.println("\t2.- Añadir de Empleados.");
                System.out.println("\t3.- Modificacion de Empleados.");
                System.out.println("\t4.- Eliminar de Empleados.");
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

    protected static void listado(boolean pausafinal) {
        System.out.println("\n\tListado de Empleados: \n");
        EmpleadosController.Lista();
        if (pausafinal) {
            System.out.println("\n\tPulse 'Intro' para continuar");
            Utils.pausa();
        }
    }

    private static void alta() throws ParseException {
        System.out.println("\n\tAñadir de Empleado\n");

        Empleados o = new Empleados();
        Departamentos e = new Departamentos();
        System.out.print("\nIntroduzca 'Numero de Empleado' del Empleado: ");
        o.setNumemp(Utils.getShortConsola());
        Utils.pausa();
        System.out.print("\nIntroduzca 'Nombre' del Empleado: ");
        o.setNombre(Utils.getStringConsola());
        Utils.pausa();
        System.out.print("\nIntroduzca 'Fecha del contrato' del Empleado: ");
        o.setFechacontrato(Utils.getStringConsola());
        Utils.pausa();
        System.out.print("\nIntroduzca 'trabajo' del Empleado: ");
        o.setTrabajo(Utils.getStringConsola());
        Utils.pausa();
        System.out.print("\nIntroduzca 'Salario' del Empleado: ");
        o.setSalario(Utils.getFloatConsola());
        Utils.pausa();
        System.out.print("\nIntroduzca 'Comision' del Empleado: ");
        o.setComision(Utils.getFloatConsola());
        Utils.pausa();
        System.out.print("\nIntroduzca 'Numero del departamento' del Empleado: ");
        e.setNumdept(Utils.getShortConsola());
        Utils.pausa();
        EmpleadosController.almacenarNuevo(o, e);

        System.out.println("\n\tInsertado correctamente!. Pulse 'Intro' para continuar");
        Utils.pausa();
    }

    private static void modificacion() throws ParseException {
        System.out.println("\n\tModificacion de Departamento\n");

        Empleados o = new Empleados();
        Departamentos e = new Departamentos();

        if (o != null) {
            System.out.print("\nIntroduzca 'Numero de Empleados'  ('Intro' para no modificar): ");
            Short str = Utils.getShortConsola();
            if (!str.equals("")) {
                o.setNumemp(str);
            }
            System.out.print("\nIntroduzca 'Nombre' del Empleado ('Intro' para no modificar): ");
            String str2 = Utils.getStringConsola();
            if (!str2.equals("")) {
                o.setNombre(str2);
            }
            System.out.print("\nIntroduzca 'Trabajo' del Empleado ('Intro' para no modificar): ");
            String str3 = Utils.getStringConsola();
            if (!str3.equals("")) {
                o.setTrabajo(str3);
            }
            System.out.print("\nIntroduzca 'Fecha contrato' del Empleado ('Intro' para no modificar): ");
            String str4 = Utils.getStringConsola();
            if (!str4.equals("")) {
                o.setFechacontrato(str4);
            }
            System.out.print("\nIntroduzca 'Salario' del Empleado ('Intro' para no modificar): ");
            float str5 = Utils.getFloatConsola();
            if (!str4.equals("")) {
                o.setSalario(str5);
            }
            System.out.print("\nIntroduzca 'Comision' del Empleado ('Intro' para no modificar): ");
            float str6 = Utils.getFloatConsola();
            if (!str4.equals("")) {
                o.setComision(str6);
            }
            System.out.print("\nIntroduzca 'Numero del Departamento'  ('Intro' para no modificar): ");
            Short str7 = Utils.getShortConsola();
            if (!str7.equals("")) {
                e.setNumdept(str7);

            }

            EmpleadosController.almacenarModificado(o, e);

            System.out.println("\n\tModificado correctamente!. Pulse 'Intro' para continuar");
            Utils.pausa();
        }
    }

    private static void baja() {
        System.out.println("\n\t Baja de Empleado\n");
        Empleados o = new Empleados();
        System.out.print("\nIntroduzca 'Empleado' del Departamento para eliminar ('Intro' para no Borrar): ");
        o.setNumemp(Utils.getShortConsola());
        EmpleadosController.eliminar(o);
        System.out.println("\n\tEliminado correctamente!. Pulse 'Intro' para continuar");
        Utils.pausa();
    }

}
