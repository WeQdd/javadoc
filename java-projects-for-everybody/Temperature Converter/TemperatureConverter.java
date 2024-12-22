import java.util.Scanner;

/**
 * Класс для конвертации температуры из одного единицы в другой.
 */
public class TemperatureConverter {
    /**
     * Запускает программу для конвертации температуры.
     * 
     * @param args аргументы командной строки
     */
    public static void RunTemperatureConverter(String[] args) {
        Scanner input = new Scanner(System.in);
        double temperature;
        char unit;
        
        // Prompt the user to enter the temperature and its unit
        System.out.print("Enter temperature: ");
        temperature = input.nextDouble();
        System.out.print("Enter unit (C/F/K): ");
        unit = input.next().charAt(0);
        
        // Convert the temperature to other units based on the input unit
        switch (unit) {
            case 'C':
            case 'c':
                System.out.printf("%.2f C = %.2f F%n", temperature, celsiusToFahrenheit(temperature));
                System.out.printf("%.2f C = %.2f K%n", temperature, celsiusToKelvin(temperature));
                break;
            case 'F':
            case 'f':
                System.out.printf("%.2f F = %.2f C%n", temperature, fahrenheitToCelsius(temperature));
                System.out.printf("%.2f F = %.2f K%n", temperature, fahrenheitToKelvin(temperature));
                break;
            case 'K':
            case 'k':
                System.out.printf("%.2f K = %.2f C%n", temperature, kelvinToCelsius(temperature));
                System.out.printf("%.2f K = %.2f F%n", temperature, kelvinToFahrenheit(temperature));
                break;
            default:
                System.out.println("Invalid unit.");
                break;
        }
    }
    
    /**
     * Конвертирует температуру из градусов Цельсия в градусы Фаренгейта.
     * 
     * @param celsius температура в градусах Цельсия
     * @return температура в градусах Фаренгейта
     */
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
    
    /**
     * Конвертирует температуру из градусов Цельсия в килоградусы Цельсия.
     * 
     * @param celsius температура в градусах Цельсия
     * @return температура в килоградусах Цельсия
     */
    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }
    
    /**
     * Конвертирует температуру из градусов Фаренгейта в градуса Цельсия.
     * 
     * @param fahrenheit температура в градусах Фаренгейта
     * @return температура в градусах Цельсия
     */
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
    
    /**
     * Конвертирует температуру из градусов Фаренгейта в килоградуса Цельсия.
     * 
     * @param fahrenheit температура в градусах Фаренгейта
     * @return температура в килоградусах Цельсия
     */
    public static double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit + 459.67) * 5 / 9;
    }
    
    /**
     * Конвертирует температуру из килоградусов Цельсия в градуса Цельсия.
     * 
     * @param kelvin температура в кило
     */
    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }
    
    /**
     * Конвертирует температуру из килоградусов Цельсия в градуса Фаренгейта.
     * 
     * @param kelvin температура в килоградусах Цельсия
     * @return температура в градусах Фаренгейта
     */
    public static double kelvinToFahrenheit(double kelvin) {
        return (kelvin * 9 / 5) - 459.67;
    }
}

