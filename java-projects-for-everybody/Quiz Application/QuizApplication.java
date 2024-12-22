import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Представляет вопрос в викторине.
 */
class Question {
    /**
     * Текст вопроса.
     */
    private String questionText;

    /**
     * Вариант ответа A.
     */
    private String optionA;

    /**
     * Вариант ответа B.
     */
    private String optionB;

    /**
     * Вариант ответа C.
     */
    private String optionC;

    /**
     * Вариант ответа D.
     */
    private String optionD;

    /**
     * Правильный ответ.
     */
    private String correctAnswer;

    /**
     * Конструктор вопроса.
     *
     * @param questionText текст вопроса
     * @param optionA вариант ответа A
     * @param optionB вариант ответа B
     * @param optionC вариант ответа C
     * @param optionD вариант ответа D
     * @param correctAnswer правильный ответ
     */
    public Question(String questionText, String optionA, String optionB, String optionC, String optionD, String correctAnswer) {
        this.questionText = questionText;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
    }

    /**
     * Возвращает текст вопроса.
     *
     * @return текст вопроса
     */
    public String getQuestionText() {
        return questionText;
    }

    /**
     * Возвращает вариант ответа A.
     *
     * @return вариант ответа A
     */
    public String getOptionA() {
        return optionA;
    }

    /**
     * Возвращает вариант ответа B.
     *
     * @return вариант ответа B
     */
    public String getOptionB() {
        return optionB;
    }

    /**
     * Возвращает вариант ответа C.
     *
     * @return вариант ответа C
     */
    public String getOptionC() {
        return optionC;
    }

    /**
     * Возвращает вариант ответа D.
     *
     * @return вариант ответа D
     */
    public String getOptionD() {
        return optionD;
    }

    /**
     * Проверяет, является ли переданный ответ правильным.
     *
     * @param answer ответ для проверки
     * @return true, если ответ совпадает с правильным ответом, false в противном случае
     */
    public boolean isCorrectAnswer(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }
}


/**
 * Представляет викторину.
 */
public class QuizApplication {
    /**
     * Путь к файлу с вопросами.
     */
    private static final String QUESTIONS_FILE = "questions.txt";
    /**
     * Баллов за правильный ответ.
     */
    private static final int SCORE_PER_QUESTION = 10;

    /**
     * Список вопросов.
     */
    private List<Question> questions;

    
    private int score;

    /**
     * Загружает вопросы из файла.
     * 
     * @throws FileNotFoundException если файл не найден
     */
    public void loadQuestions() throws FileNotFoundException {
        File file = new File(QUESTIONS_FILE);
        Scanner scanner = new Scanner(file);
    
        questions = new ArrayList<>();
    
        int lineCount = 1;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
    
            if (line.startsWith("Question:")) {
                String questionText = extractContent(line);
                String optionAText = extractContent(scanner.nextLine());
                String optionBText = extractContent(scanner.nextLine());
                String optionCText = extractContent(scanner.nextLine());
                String optionDText = extractContent(scanner.nextLine());
                String correctAnswer = extractContent(scanner.nextLine());
    
                Question question = new Question(questionText, optionAText, optionBText, optionCText, optionDText, correctAnswer);
                questions.add(question);
            } else {
                System.out.println("Invalid question format at line " + lineCount);
            }
    
            lineCount++;
        }
    
        scanner.close();
    }
    
    /**
     * Извлекает содержимое строки, удаляя все, что находится до двоеточия.
     * 
     * @param line строка, из которой нужно извлечь содержимое
     * @return содержимое строки
     */
    private String extractContent(String line) {
        int colonIndex = line.indexOf(":");
        if (colonIndex != -1) {
            return line.substring(colonIndex + 1).trim();
        } else {
            System.out.println("Invalid format in line: " + line);
            return "";
        }
    }

    /**
     * Начинает викторину.
     */
    public void startQuiz() {
        score = 0;

        System.out.println("Welcome to the Quiz Application!\n");

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + question.getQuestionText());
            System.out.println("A. " + question.getOptionA());
            System.out.println("B. " + question.getOptionB());
            System.out.println("C. " + question.getOptionC());
            System.out.println("D. " + question.getOptionD());

            String userAnswer = getUserAnswer();

            if (question.isCorrectAnswer(userAnswer)) {
                System.out.println("Correct!\n");
                score += SCORE_PER_QUESTION;
            } else {
                System.out.println("Incorrect!\n");
            }
        }

        System.out.println("Quiz Summary:");
        System.out.println("Total Questions: " + questions.size());
        System.out.println("Correct Answers: " + (score / SCORE_PER_QUESTION));
        System.out.println("Incorrect Answers: " + ((questions.size() * SCORE_PER_QUESTION - score) / SCORE_PER_QUESTION));
        System.out.println("Score: " + score + "%\n");

        System.out.println("Thank you for playing!");
    }

    /**
     * Получает ответ пользователя.
     * 
     * @return ответ пользователя
     */
    private String getUserAnswer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your Answer: ");
        return scanner.nextLine().toUpperCase();
    }

    /**
     * Запускает викторину.
     * 
     * @param args аргументы командной строки
     */
    public static void RunQuizApplication(String[] args) {
        QuizApplication quiz = new QuizApplication();

        try {
            quiz.loadQuestions();
            quiz.startQuiz();
        } catch (FileNotFoundException e) {
            System.out.println("Failed to load questions from file: " + QUESTIONS_FILE);
        }
    }
}
