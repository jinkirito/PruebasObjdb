/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresaobj;

import other.Utils;

/**
 *
 * @author  Antonio Jose Adamuz Sereno
 */
public class EmpresaObj {

    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {

        int opcionElegida;
        do {
            System.out.println("\n\t\t\tGESTION DE Empresa\n");

            System.out.println("\t1.- Gestion de Departamentos.");
            System.out.println("\t2.- Gestion de Empleados.");
           // System.out.println("\t3.- Gestion de Presupuestos.");
            System.out.println("\t0.- Salir");
            System.out.println("\n\tElija una opcion: ");

            opcionElegida = Utils.getIntConsola(0, 5);

            switch (opcionElegida) {
                case 0:
                    System.out.println("\nAdios!");
                    break;
                case 1:
                    ManageDepartamento.menuGestion();
                    break;
                case 2:
                    ManageEmpleados.menuGestion();
                    break;
                case 3:
                 //   ManagePresupuestos.menuGestion();
                    break;
            }
        } while (opcionElegida != 0);
    }

    
}
