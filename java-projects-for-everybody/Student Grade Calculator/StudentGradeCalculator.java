import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Класс для расчета среднего балла студентов.
 */
public class StudentGradeCalculator {

    /**
     * Запускает программу для расчета среднего балла студентов.
     * 
     * @param args аргументы командной строки
     */
    public static void RunStudentGradeCalculator(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        /**
         * Список имен студентов.
         */
        List<String> studentNames = new ArrayList<>();

        /**
         * Список баллов студентов.
         */
        List<Double> studentGrades = new ArrayList<>();

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            String name = scanner.next();
            studentNames.add(name);

            System.out.print("Enter the grade of student " + (i + 1) + ": ");
            double grade = scanner.nextDouble();
            studentGrades.add(grade);
        }

        /**
         * Рассчитывает средний балл студентов.
         * 
         * @param grades список баллов студентов
         * @return средний балл
         */
        double average = calculateAverage(studentGrades);

        System.out.println("\nStudent Grade Report:");
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println(studentNames.get(i) + ": " + studentGrades.get(i));
        }

        System.out.println("\nAverage Grade: " + average);
    }

    /**
     * Рассчитывает средний балл студентов.
     * 
     * @param grades список баллов студентов
     * @return средний балл
     */
    private static double calculateAverage(List<Double> grades) {
        double sum = 0.0;
        for (Double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
}