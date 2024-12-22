import java.util.Scanner;

/**
 * Класс menu представляет собой главное меню приложения.
 * 
 * @author [Ваше имя]
 */
public class menu {
    /**
     * Метод main запускает главное меню приложения.
     * 
     * @param args массив строковых аргументов командной строки
     */
    public static void main(String[] args) {

        /**
         * Переменная Menu для хранения выбора пользователя.
         */
        char Menu;

        /**
         * Переменная temp для хранения временного значения.
         */
        String temp = "";

        /**
         * Строка printmenu для вывода меню на экран.
         */
        String printmenu = "\nApplication Menu\n\n1 - Address Book App\n2 - Calculator App\n3 - Contact Book App\n4 - File Encryption App\n5 - Guess Game App\n6 - Hang Man App\n7 - Library Management System App\n8 - Quiz Application App\n9 - Bank Account Management System App\nA - Student Grade Calculator App\nB - Temperature Converter App\nC - TicTacToe App\nD - To Do List App\nE - Exit";

        /**
         * Объекты для запуска различных приложений.
         */
        AddressBook addressBook = new AddressBook();
        Calculator calculator = new Calculator();
        ContactBookProgram contactBook = new ContactBookProgram();
        FileEncryptionDecryption fileEncryptionDecryption = new FileEncryptionDecryption();
        GuessGame guessGame = new GuessGame();
        HangmanGame hangmanGame = new HangmanGame();
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem();
        QuizApplication quizApplication = new QuizApplication();
        BankAccountManagementSystem bankAccountManagementSystem = new BankAccountManagementSystem();
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator();
        TemperatureConverter temperatureConverter = new TemperatureConverter();
        TicTacToe ticTacToe = new TicTacToe();
        //TodoListApp todoListApp = new TodoListApp();

        /**
         * Переменная quit для управления циклом while.
         */
        boolean quit = false;

        /**
         * Цикл while для вывода меню и обработки выбора пользователя.
         */
        while (!quit) {
            Menu = ' ';
            Scanner input = new Scanner(System.in);

            /**
             * Вывод меню на экран.
             */
            System.out.println(printmenu);
            System.out.print("\nEnter your choice: ");

            /**
             * Чтение выбора пользователя.
             */
            if (input.hasNext()) {
                temp = input.next();
                Menu = temp.charAt(0);
                input.nextLine();
            }

            /**
             * Обработка выбора пользователя.
             */
            switch (Menu) {
                case '1':
                    addressBook.RunAddressBook(args);
                    break;
                case '2':
                    calculator.RunCalculator(args);
                    break;
                case '3':
                    //input.close();
                    contactBook.RunContactBook(args);
                    break;
                case '4':
                    fileEncryptionDecryption.RunFileEncryptionDecryption(args);
                    break;
                case '5':
                    //input.close();
                    guessGame.RunGuessGame(args);
                    break;
                case '6':
                    hangmanGame.play();
                    break;
                case '7':
                    libraryManagementSystem.RunLibraryManagementSystem(args);
                    break;
                case '8':
                    quizApplication.RunQuizApplication(args);
                    break;
                case '9':
                    bankAccountManagementSystem.RunBankAccountManagementSystem(args);
                    break;
                case 'A':
                    studentGradeCalculator.RunStudentGradeCalculator(args);
                    break;
                case 'B':
                    temperatureConverter.RunTemperatureConverter(args);
                    break;
                case 'C':
                    ticTacToe.RunTicTacToe(args);
                    break;
                case 'D':
                    TodoListApp.RunTodoListApp(args);
                    break;
                case 'E':
                    input.close();
                    quit = true;
                    break;

            }
        }

    }

}