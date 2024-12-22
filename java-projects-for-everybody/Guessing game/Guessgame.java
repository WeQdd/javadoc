import java.util.InputMismatchException; // Импорт класса для обработки некорректного ввода
import java.util.Random;
import java.util.Scanner;

public class GuessGame {

    // Константы для диапазона чисел
    private static final int MIN = 1;
    private static final int MAX = 100;

    public static void RunGuessGame(String[] args) {
        Scanner input = new Scanner(System.in);

        // Основной игровой цикл, позволяющий пользователю играть несколько раз
        while (true) {
            playGame(input);
            if(!playAgain(input)) {
                //input.close(); // Закрыть сканер после использования
                return;
            }
        }
         // Проверить, хочет ли пользователь сыграть снова

    }

    /**
     * Запускает игру, в которой пользователь должен угадать число.
     */
    private static void playGame(Scanner input) {
        Random rand = new Random();
        int randomNumber = rand.nextInt(MAX - MIN + 1) + MIN; // Генерировать случайное число в диапазоне [MIN, MAX]
        int guess;
        int numGuesses = 0;
        boolean correct = false;

        System.out.print("Guess a number between " + MIN + " and " + MAX + ":");

        while (!correct) {
            try {
                guess = input.nextInt(); // Считать пользовательский ввод
                numGuesses++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number in " + numGuesses + " guesses.");
                    correct = true;
                } else if (guess < randomNumber) {
                    System.out.print("Too low, try again:"); // Подсказка, если догадка слишком низкая
                } else {
                    System.out.print("Too high, try again:"); // Подсказка, если догадка слишком высокая
                }

            } catch (InputMismatchException e) {
                // Обработать случай, когда ввод не является допустимым числом
                System.out.print("Invalid input. Please enter a valid number between " + MIN + " and " + MAX + ".");
                input.next(); // Очистить некорректный ввод
            }
            catch (Exception e) {}
        }
    }

    /**
     * Спрашивает пользователя, хочет ли он сыграть снова.
     * @return true, если пользователь хочет сыграть снова; false в противном случае.
     */
    private static boolean playAgain(Scanner input) {
        System.out.print("Do you want to play again? (yes/no) : ");
        String response = input.next().trim().toLowerCase();
        // Считать и нормализовать ответ пользователя
        return response.equals("yes") || response.equals("y"); // Проверить, хочет ли пользователь продолжить
    }
}