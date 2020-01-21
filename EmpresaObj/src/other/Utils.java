/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author  Antonio Jose Adamuz Sereno
 */
public class Utils {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	private static Scanner scanner = null;
	
	
	/**
	 * 
	 * @param minimo
	 * @param maximo
	 * @return
	 */
	public static int getIntConsola(int minimo, int maximo) {
		boolean numeroValido = false;
		int numero = 0;
		
		do {
			try {
				numero = Integer.parseInt (getScanner().nextLine());
				if (numero >= minimo && numero <= maximo) {
					numeroValido = true;
				}
			} catch (Exception e) {}
			if (!numeroValido) {
				System.out.println("Número incorrecto. Debe introducir valor entre " + minimo + " y " + maximo);
			}
		} while (!numeroValido);
		
		return numero;
	}

	
	
	/**
	 * 
	 * @param minimo
	 * @param maximo
	 * @return
	 */
	public static int getIntConsola(int minimo) {
		boolean numeroValido = false;
		int numero = 0;
		
		do {
			try {
				numero = Integer.parseInt (getScanner().nextLine());
				if (numero >= minimo) {
					numeroValido = true;
				}
			} catch (Exception e) {}
			if (!numeroValido) {
				System.out.println("Número incorrecto. Debe introducir valor mayor que " + minimo);
			}
		} while (!numeroValido);
		
		return numero;
	}

	
	
	/**
	 * 
	 * @param minimo
	 * @param maximo
	 * @return
	 */
	public static String getStringConsola() {
		return getScanner().nextLine();
	}
        
        public static Short getShortConsola(){
            return getScanner().nextShort();
        }

	
	
	/**
	 * 
	 * @param minimo
	 * @param maximo
	 * @return
	 */
	public static void pausa() {
		getScanner().nextLine();
	}


	
	public static Scanner getScanner () {
		if (scanner == null) {
			scanner = new Scanner(System.in);
		}
		return scanner;
	}
	
	
	public static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}

    public static short getShortConsola(int i) {
        i = Short.parseShort(getScanner().nextLine());
       return getScanner().nextShort();
    }

    public static Float getFloatConsola() {
        return getScanner().nextFloat();
    }

    public static Date getDateConsola() throws ParseException {
        Date parsed = sdf.parse(Utils.getStringConsola());
            java.sql.Date sql = new java.sql.Date(parsed.getTime());
            return sql;
    }
}
