package day04;

import java.util.Scanner;

public class AufgabeRechteck {

    static float rechnenFlaeche(float a, float b) {  
        return a * b;
    }

    static float rechnenUmfang(float a, float b) {  
    	return 2 * (a + b);
    }

    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        System.out.println("Eingeben X (in cm):");
        float a = scn.nextFloat();
        System.out.println("Eingeben Y (in cm):");
        float b = scn.nextFloat();
        
        System.out.println("Fläche: " + rechnenFlaeche(a, b));  
        System.out.println("Umfang: " + rechnenUmfang(a, b));  

        scn.close();  
    }
}
