import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс TodoListApp представляет собой приложение для управления списком дел.
 * 
 * @author [Ваше имя]
 */
public class TodoListApp {
    /**
     * Метод RunTodoListApp запускает приложение Todo List.
     * 
     * @param args массив строковых аргументов командной строки
     */
    public static void RunTodoListApp(String[] args) {
        /**
         * Список дел, представленный как ArrayList строк.
         */
        ArrayList<String> todoList = new ArrayList<String>();
        
        /**
         * Объект Scanner для чтения пользовательского ввода.
         */
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            /**
             * Вывод списка дел на экран.
             */
            System.out.println("====Todo List====");
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println((i+1) + ". " + todoList.get(i));
            }
            System.out.println("=================");
            
            /**
             * Вывод меню на экран.
             */
            System.out.println("1. Добавить элемент");
            System.out.println("2. Удалить элемент");
            System.out.println("3. Выход");
            System.out.print("Введите выбор: ");
            
            /**
             * Чтение пользовательского выбора.
             */
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character
            
            if (choice == 1) {
                /**
                 * Добавление нового элемента в список дел.
                 */
                System.out.print("Введите элемент для добавления: ");
                String item = scanner.nextLine();
                todoList.add(item);
                System.out.println("Элемент добавлен!");
            } else if (choice == 2) {
                /**
                 * Удаление элемента из списка дел.
                 */
                System.out.print("Введите номер элемента для удаления: ");
                int itemNum = scanner.nextInt();
                scanner.nextLine(); // consume the newline character
                if (itemNum > 0 && itemNum <= todoList.size()) {
                    todoList.remove(itemNum-1);
                    System.out.println("Элемент удален!");
                } else {
                    System.out.println("Недопустимый номер элемента.");
                }
            } else if (choice == 3) {
                /**
                 * Выход из приложения.
                 */
                break;
            } else {
                System.out.println("Недопустимый выбор. Попробуйте еще раз.");
            }
        }
        
        System.out.println("Выход из Todo List App.");
        //scanner.close();
    }
}