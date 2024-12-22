import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Класс для представления контакта.
 */
public class Contact {
    /**
     * Имя контакта.
     */
    private String name;

    /**
     * Номер телефона контакта.
     */
    private String phoneNumber;

    /**
     * Email контакта.
     */
    private String email;

    /**
     * Конструктор для создания нового контакта.
     * 
     * @param name имя контакта
     * @param phoneNumber номер телефона контакта
     * @param email email контакта
     */
    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    /**
     * Метод для получения имени контакта.
     * 
     * @return имя контакта
     */
    public String getName() {
        return name;
    }

    /**
     * Метод для получения номера телефона контакта.
     * 
     * @return номер телефона контакта
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Метод для получения email контакта.
     * 
     * @return email контакта
     */
    public String getEmail() {
        return email;
    }

    /**
     * Метод для установки имени контакта.
     * 
     * @param name новое имя контакта
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод для установки номера телефона контакта.
     * 
     * @param phoneNumber новый номер телефона контакта
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Метод для установки email контакта.
     * 
     * @param email новый email контакта
     */
    public void setEmail(String email) {
        this.email = email;
    }
}

/**
 * Класс для представления книги контактов.
 */
public class ContactBook {
    /**
     * Список контактов.
     */
    private List<Contact> contacts;

    /**
     * Конструктор для создания новой книги контактов.
     */
    public ContactBook() {
        this.contacts = new ArrayList<>();
    }

    /**
     * Метод для добавления нового контакта в книгу.
     * 
     * @param name имя контакта
     * @param phoneNumber номер телефона контакта
     * @param email email контакта
     */
    public void addContact(String name, String phoneNumber, String email) {
        Contact contact = new Contact(name, phoneNumber, email);
        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }

    /**
     * Метод для просмотра списка контактов.
     */
    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Contact book is empty.");
        } else {
            System.out.println("Contact List:");
            for (int i = 0; i < contacts.size(); i++) {
                Contact contact = contacts.get(i);
                System.out.println((i + 1) + ". Name: " + contact.getName() +
                        ", Phone: " + contact.getPhoneNumber() +
                        ", Email: " + contact.getEmail());
            }
        }
    }

    /**
     * Метод для редактирования контакта.
     * 
     * @param index индекс контакта в списке
     * @param name новое имя контакта
     * @param phoneNumber новый номер телефона контакта
     * @param email новый email контакта
     */
    public void editContact(int index, String name, String phoneNumber, String email) {
        if (index >= 0 && index < contacts.size()) {
            Contact contact = contacts.get(index);
            contact.setName(name);
            contact.setPhoneNumber(phoneNumber);
            contact.setEmail(email);
            System.out.println("Contact updated successfully.");
        } else {
            System.out.println("Invalid contact index.");
        }
    }

    /**
     * Метод для удаления контакта.
     * 
     * @param index индекс контакта в списке
     */
    public void deleteContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            Contact contact = contacts.remove(index);
            System.out.println("Contact deleted: " + contact.getName());
        } else {
            System.out.println("Invalid contact index.");
        }
    }
}



/**
 * Класс для запуска программы книги контактов.
 */
public class ContactBookProgram {
    /**
     * Основной метод для запуска программы.
     * 
     * @param args аргументы командной строки
     */
    public static void RunContactBook(String[] args) {
        /**
         * Создание новой книги контактов.
         */
        ContactBook contactBook = new ContactBook();

        /**
         * Создание нового сканера для чтения ввода пользователя.
         */
        Scanner scanner = new Scanner(System.in);

        /**
         * Переменная для хранения выбора пользователя.
         */
        int choice = -1;

        /**
         * Основной цикл программы.
         */
        while (choice != 0) {
            /**
             * Вывод меню программы.
             */
            System.out.println("----- Contact Book -----");
            System.out.println("1. Add a contact");
            System.out.println("2. View contacts");
            System.out.println("3. Edit a contact");
            System.out.println("4. Delete a contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            /**
             * Чтение выбора пользователя.
             */
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                System.out.println();

                /**
                 * Обработка выбора пользователя.
                 */
                switch (choice) {
                    case 1:
                        /**
                         * Добавление нового контакта.
                         */
                        System.out.print("Enter the name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter the phone number: ");
                        String phoneNumber = scanner.nextLine();
                        System.out.print("Enter the email: ");
                        String email = scanner.nextLine();
                        contactBook.addContact(name, phoneNumber, email);
                        System.out.println();
                        break;
                    case 2:
                        /**
                         * Просмотр списка контактов.
                         */
                        contactBook.viewContacts();
                        System.out.println();
                        break;
                    case 3:
                        /**
                         * Редактирование контакта.
                         */
                        System.out.print("Enter the index of the contact to edit: ");
                        int editIndex = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character
                        System.out.print("Enter the new name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter the new phone number: ");
                        String newPhoneNumber = scanner.nextLine();
                        System.out.print("Enter the new email: ");
                        String newEmail = scanner.nextLine();
                        contactBook.editContact(editIndex - 1, newName, newPhoneNumber, newEmail);
                        System.out.println();
                        break;
                    case 4:
                        /**
                         * Удаление контакта.
                         */
                        System.out.print("Enter the index of the contact to delete: ");
                        int deleteIndex = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character
                        contactBook.deleteContact(deleteIndex - 1);
                        System.out.println();
                        break;
                    case 5:
                        /**
                         * Выход из программы.
                         */
                        return;
                    default:
                        /**
                         * Обработка неверного выбора пользователя.
                         */
                        System.out.println("Invalid choice. Please try again.\n");
                }
            } else {
                /**
                 * Обработка неверного ввода пользователя.
                 */
                System.out.println("Invalid input. Please try again.\n");
                //scanner.nextLine(); // Consume invalid input
            }
        }

        /**
         * Закрытие сканера.
         */
        scanner.close();
    }
}