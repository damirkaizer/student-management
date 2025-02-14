import models.Student;
import services.StudentService;
import java.util.Scanner;
public class StudentManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentService service = new StudentService();
        while (true) {
            System.out.println("\n1. Студент қосу");
            System.out.println("2. Барлық студенттерді көру");
            System.out.println("3. Студент іздеу");
            System.out.println("4. Студенттің бағасын жаңарту");
            System.out.println("5. Студентті өшіру");
            System.out.println("0. Шығу");
            System.out.print("Таңдау: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Аты: ");
                    String name = scanner.nextLine();
                    System.out.print("Курсы: ");
                    String course = scanner.nextLine();
                    System.out.print("Бағасы: ");
                    double grade = scanner.nextDouble();
                    service.addStudent(new Student(id, name, course, grade));
                    break;
                case 2:
                    service.displayStudents();
                    break;
                case 3:
                    System.out.print("Іздейтін студенттің ID-сін енгізіңіз: ");
                    Student student = service.searchStudent(scanner.nextInt());
                    System.out.println(student != null ? student : "Студент табылмады.");
                    break;
                case 4:
                    System.out.print("Жаңартатын студенттің ID-сін енгізіңіз: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Жаңа бағасын енгізіңіз: ");
                    service.updateStudent(updateId, scanner.nextDouble());
                    break;
                case 5:
                    System.out.print("Өшіру үшін ID енгізіңіз: ");
                    service.deleteStudent(scanner.nextInt());
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Қате таңдау!");
            }
        }
    }
}
