package day04;

import java.util.Scanner;

// Class for Circle Calculations
class Circle {
    private static final double _pi = Math.PI; // Using final for a constant

    private double _radius;

    // Constructor
    public Circle(double radius) {
        _radius = radius;
    }

    // Method to calculate area
    public double getArea() {
        return _pi * Math.pow(_radius, 2);
    }

    // Method to calculate circumference
    public double getCircumference() {
        return 2 * _pi * _radius;
    }

    // Method to display results
    public void printCircleInfo() {
        System.out.printf("Der Kreis mit dem Radius %.2f cm hat eine Fläche von %.2f cm² und einen Umfang von %.2f cm.%n",
        		_radius, getArea(), getCircumference());
    }
}

// Class for Temperature Conversion
class TemperatureConverter {
    private static final double _multiplaier = 9.0 / 5.0;
    private static final double _offset = 32.0;

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * _multiplaier) + _offset;
    }
}

// Main class
public class Aufgaben2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("\n=== Hauptmenü ===");
            System.out.println("1: Kreisberechnung");
            System.out.println("2: Temperaturumrechnung");
            System.out.println("3: Beenden");
            System.out.print("Wählen Sie eine Option: ");

            int choice = getValidInteger(scanner);

            switch (choice) {
                case 1:
                    berechneKreis(scanner);
                    break;
                case 2:
                    temperaturUmrechnung(scanner);
                    break;
                case 3:
                    keepRunning = false;
                    System.out.println("Programm beendet.");
                    break;
                default:
                    System.out.println("Ungültige Wahl! Bitte wählen Sie 1, 2 oder 3.");
            }
        }

        scanner.close();
    }

    // Methode zur Kreisberechnung mit Benutzereingabe
    public static void berechneKreis(Scanner scanner) {
        System.out.println("\n=== Kreisberechnung ===");
        System.out.print("Geben Sie den Radius des Kreises ein: ");
        double radius = getValidDouble(scanner);

        Circle kreis = new Circle(radius);
        kreis.printCircleInfo();
    }

    // Methode zur Temperaturumrechnung
    public static void temperaturUmrechnung(Scanner scanner) {
        System.out.println("\n=== Temperaturumrechnung ===");

        boolean continueConversion = true;
        while (continueConversion) {
            System.out.print("Geben Sie die Temperatur in °C ein: ");
            double celsius = getValidDouble(scanner);
            double fahrenheit = TemperatureConverter.celsiusToFahrenheit(celsius);
            System.out.printf("Die Temperatur %.1f°C entspricht %.1f°F.%n", celsius, fahrenheit);

            // Asking user if they want to continue
            System.out.print("Möchten Sie eine weitere Temperatur umrechnen? (ja/nein): ");
            String response = scanner.next().trim().toLowerCase();
            continueConversion = response.equals("ja");
        }
    }

    // Methode zur sicheren Ganzzahleneingabe
    public static int getValidInteger(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Fehler: Bitte geben Sie eine gültige Zahl ein.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    // Methode zur sicheren Kommazahleneingabe
    public static double getValidDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("Fehler: Bitte geben Sie eine gültige Zahl ein.");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}

