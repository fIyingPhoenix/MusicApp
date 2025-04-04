package day03;
import java.util.Scanner;

public class Console {
    static Scanner scanner = new Scanner(System.in);

    public static int Addition(int number1, int number2) {
        return number1 + number2;
    }

    private static int Subtraction(int number1, int number2) {
        return number1 - number2;
    }

    private static int Multiplication(int number1, int number2) {
        return number1 * number2;
    }

    private static int Division(int number1, int number2) {
        if (number2 == 0) {
           System.out.println("Error: Division by zero!");
           return 0; 
        }
        return number1 / number2;
    }

    private static int Calculation(String operation, int number1, int number2) {
        switch (operation) {
            case "+":
                return Addition(number1, number2);
            case "-":
                return Subtraction(number1, number2);
            case "/":
                return Division(number1, number2);
            case "*":
                return Multiplication(number1, number2);
            default:
                System.out.println("Invalid operation");
                return 0;
        }
    }

    private static void StartCalculator() {

        System.out.println("Enter the first number:");
        int number1 = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Enter operation (+, -, *, /): ");
        String operation = scanner.nextLine();

        System.out.println("Enter the second number: ");
        int number2 = scanner.nextInt();

        System.out.println("Result: " + Calculation(operation, number1, number2));  	
    }

    public static void main(String[] args) {
    	
    	System.out.println("Siple Calculator!");
    	while(true) {

    		 StartCalculator();
    		 
    	     scanner.nextLine();

    	     System.out.println("Continue (Y/n): ");
    	     String contin = scanner.nextLine();
    	     if(contin.contains("n")) {
    	    	 break;
    	     }
    	}
    	
    }
}
