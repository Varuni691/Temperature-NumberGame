import java.util.Scanner;

public class TemperatureConverter {

    // Conversion methods
    public static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public static double celsiusToKelvin(double c) {
        return c + 273.15;
    }

    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static double fahrenheitToKelvin(double f) {
        return (f - 32) * 5 / 9 + 273.15;
    }

    public static double kelvinToCelsius(double k) {
        return k - 273.15;
    }

    public static double kelvinToFahrenheit(double k) {
        return (k - 273.15) * 9 / 5 + 32;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Temperature Converter ===");
        System.out.println("Options: C (Celsius), F (Fahrenheit), K (Kelvin)");
        System.out.print("Enter the unit you want to convert from (C/F/K): ");
        String unit = sc.next().toUpperCase();

        System.out.print("Enter the temperature value: ");
        double temp = sc.nextDouble();

        if (unit.equals("C")) {
            System.out.printf("%.2f °C = %.2f °F%n", temp, celsiusToFahrenheit(temp));
            System.out.printf("%.2f °C = %.2f K%n", temp, celsiusToKelvin(temp));
        } else if (unit.equals("F")) {
            System.out.printf("%.2f °F = %.2f °C%n", temp, fahrenheitToCelsius(temp));
            System.out.printf("%.2f °F = %.2f K%n", temp, fahrenheitToKelvin(temp));
        } else if (unit.equals("K")) {
            System.out.printf("%.2f K = %.2f °C%n", temp, kelvinToCelsius(temp));
            System.out.printf("%.2f K = %.2f °F%n", temp, kelvinToFahrenheit(temp));
        } else {
            System.out.println("Invalid unit entered!");
        }

        sc.close();
    }
}
