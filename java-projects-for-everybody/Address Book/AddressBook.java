import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс для представления адресной книги.
 */
public class AddressBook {
    /**
     * Список контактов в адресной книге.
     */
    static ArrayList<ContactAddress> contacts = new ArrayList<ContactAddress>();
     /**
     * Сканер для чтения пользовательского ввода.
     */
    static Scanner input = new Scanner(System.in);


    /**
     * Основной метод для запуска адресной книги.
     * 
     * @param args аргументы командной строки
     */
    public static void RunAddressBook(String[] args) {
        // реализация метода
        int choice;
        do {
            System.out.println("ADDRESS BOOK");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch(choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting Address Book...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while(choice != 5);
    }

    /**
     * Добавляет новый контакт в адресную книгу.
     */
    public static void addContact() {
        // реализация метода
        System.out.print("Enter name: ");
        String name = input.next();
        System.out.print("Enter address: ");
        String address = input.next();
        System.out.print("Enter phone number: ");
        String phone = input.next();
        System.out.print("Enter email: ");
        String email = input.next();
        ContactAddress c = new ContactAddress(name, address, phone, email);
        contacts.add(c);
        System.out.println("Contact added successfully!");
    }

    /**
     * Выводит все контакты в адресной книге.
     */
    public static void viewContacts() {
        // реализация метода
        if(contacts.size() == 0) {
            System.out.println("No contacts found!");
            return;
        }
        for(int i=0; i<contacts.size(); i++) {
            System.out.println("Contact " + (i+1) + ":");
            System.out.println(contacts.get(i));
        }
    }

    /**
     * Ищет контакт в адресной книге по имени.
     */
    public static void searchContact() {
        // реализация метода
        System.out.print("Enter name to search: ");
        String name = input.next();
        boolean found = false;
        for(ContactAddress c : contacts) {
            if(c.getName().equals(name)) {
                System.out.println("Contact details:");
                System.out.println(c);
                found = true;
                break;
            }
        }
        if(!found) {
            System.out.println("Contact not found!");
        }
    }

    /**
     * Удаляет контакт из адресной книги по имени.
     */
    public static void deleteContact() {
        // реализация метода
        System.out.print("Enter name to delete: ");
        String name = input.next();
        boolean found = false;
        for(ContactAddress c : contacts) {
            if(c.getName().equals(name)) {
                contacts.remove(c);
                System.out.println("Contact deleted successfully!");
                found = true;
                break;
            }
        }
        if(!found) {
            System.out.println("Contact not found!");
        }
    }
}

/**
 * Класс для представления адреса контакта.
 */
class ContactAddress {
    /**
     * Имя контакта.
     */
    private String name;
    /**
     * Адрес контакта.
     */
    private String address;
    /**
     * Номер телефона контакта.
     */
    private String phone;
    /**
     * Электронная почта контакта.
     */
    private String email;

    /**
     * Конструктор для создания нового адреса контакта.
     * 
     * @param name    имя контакта
     * @param address адрес контакта
     * @param phone   номер телефона контакта
     * @param email   электронная почта контакта
     */
    public ContactAddress(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    /**
     * Возвращает имя контакта.
     * 
     * @return имя контакта
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает адрес контакта.
     * 
     * @return адрес контакта
     */
    public String getAddress() {
        return address;
    }

    /**
     * Возвращает номер телефона контакта.
     * 
     * @return номер телефона контакта
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Возвращает электронную почту контакта.
     * 
     * @return электронная почта контакта
     */
    public String getEmail() {
        return email;
    }

    /**
     * Возвращает строковое представление адреса контакта.
     * 
     * @return строковое представление адреса контакта
     */
    public String toString() {
        return "Name: " + name + "\nAddress: " + address
                + "\nPhone: " + phone + "\nEmail: " + email;
    }
}

