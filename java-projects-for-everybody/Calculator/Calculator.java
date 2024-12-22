import java.util.Scanner;

/**
 * Класс для представления калькулятора.
 */
public class Calculator {

    /**
     * Основной метод для запуска калькулятора.
     * 
     * @param args аргументы командной строки
     */
    public static void RunCalculator(String[] args) {
        // реализация метода
    }

    /**
     * Метод для запуска калькулятора.
     * 
     * Этот метод запрашивает у пользователя два числа и оператор, а затем выполняет арифметическую операцию.
     * 
     * @param args аргументы командной строки
     */
    public static void RunCalculator(String[] args) {
        Scanner input = new Scanner(System.in);
        double num1, num2, result;
        char operator;

        /**
         * Запрашивает у пользователя первое число.
         */
        System.out.print("Enter the first number: ");
        num1 = input.nextDouble();

        /**
         * Запрашивает у пользователя второе число.
         */
        System.out.print("Enter the second number: ");
        num2 = input.nextDouble();

        /**
         * Запрашивает у пользователя оператор.
         */
        System.out.print("Enter an operator (+, -, *, /): ");
        operator = input.next().charAt(0);

        /**
         * Выполняет арифметическую операцию в зависимости от оператора.
         */
        switch (operator) {
            case '+':
                /**
                 * Сложение двух чисел.
                 */
                result = num1 + num2;
                System.out.println(num1 + " + " + num2 + " = " + result);
                break;
            case '-':
                /**
                 * Вычитание двух чисел.
                 */
                result = num1 - num2;
                System.out.println(num1 + " - " + num2 + " = " + result);
                break;
            case '*':
                /**
                 * Умножение двух чисел.
                 */
                result = num1 * num2;
                System.out.println(num1 + " * " + num2 + " = " + result);
                break;
            case '/':
                /**
                 * Деление двух чисел.
                 * 
                 * Если второе число равно нулю, выводит сообщение об ошибке.
                 */
                if (num2 == 0) {
                    System.out.println("Error: Division by zero");
                } else {
                    result = num1 / num2;
                    System.out.println(num1 + " / " + num2 + " = " + result);
                }
                break;
            default:
                /**
                 * Если оператор неверный, выводит сообщение об ошибке.
                 */
                System.out.println("Invalid operator");
                break;
        }
    }
}