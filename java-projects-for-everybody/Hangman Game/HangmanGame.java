import java.util.Scanner;

/**
 * Класс HangmanGame представляет игру "Виселица", в которой пользователь должен угадать случайное слово.
 * 
 * @author [Ваше имя]
 * @version 1.0
 */
public class HangmanGame {
    /**
     * Массив слов, из которых будет выбрано случайное слово для игры.
     */
    private static final String[] WORDS = {"apple", "banana", "cherry", "date", "elderberry", "fig", "grape"};

    /**
     * Случайное слово, которое пользователь должен угадать.
     */
    private static String word;

    /**
     * Строитель строки, представляющий текущее состояние угадываемого слова.
     * Вместо неугаданных букв стоят символы подчеркивания.
     */
    private static StringBuilder guessedWord;

    /**
     * Количество оставшихся попыток.
     */
    private static int attemptsLeft;

    /**
     * Запускает игру "Виселица".
     */
    public static void play() {
        initializeGame();

        while (attemptsLeft > 0 && guessedWord.indexOf("_") != -1) {
            System.out.println("\nAttempts left: " + attemptsLeft);
            System.out.println("Word: " + guessedWord.toString());

            char guess = getGuessFromPlayer();
            checkGuess(guess);
        }

        if (guessedWord.indexOf("_") == -1) {
            System.out.println("\nCongratulations! You guessed the word: " + word);
        } else {
            System.out.println("\nGame over! You ran out of attempts. The word was: " + word);
        }
    }

    /**
     * Инициализирует игру, выбирая случайное слово и создавая начальное состояние угадываемого слова.
     */
    private static void initializeGame() {
        word = getRandomWord();
        guessedWord = new StringBuilder(word.length());

        for (int i = 0; i < word.length(); i++) {
            guessedWord.append("_");
        }

        attemptsLeft = 6;
    }

    /**
     * Возвращает случайное слово из массива WORDS.
     * 
     * @return случайное слово
     */
    private static String getRandomWord() {
        int index = (int) (Math.random() * WORDS.length);
        return WORDS[index];
    }

    /**
     * Запрашивает у пользователя букву и проверяет, является ли она допустимой.
     * 
     * @return буква, введенная пользователем
     */
    private static char getGuessFromPlayer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your guess: ");
        String input = scanner.nextLine().toLowerCase();

        while (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            System.out.println("Invalid guess. Please enter a single letter.");
            System.out.print("Enter your guess: ");
            input = scanner.nextLine().toLowerCase();
        }

        return input.charAt(0);
    }

    /**
     * Проверяет, является ли буква, введенная пользователем, частью угадываемого слова.
     * Если да, обновляет состояние угадываемого слова.
     * Если нет, уменьшает количество оставшихся попыток.
     * 
     * @param guess буква, введенная пользователем
     */
    private static void checkGuess(char guess) {
        boolean guessedCorrectly = false;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                guessedWord.setCharAt(i, guess);
                guessedCorrectly = true;
            }
        }

        if (guessedCorrectly) {
            System.out.println("Correct guess!");
        } else {
            System.out.println("Incorrect guess!");
            attemptsLeft--;
        }
    }
}