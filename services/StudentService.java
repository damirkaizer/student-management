package services;
import models.Student;
import java.util.ArrayList;
public class StudentService {
    private ArrayList<Student> students = new ArrayList<>();
    public void addStudent(Student student) {
        students.add(student);
    }
    public void displayStudents() {
        for (Student s : students) {
            System.out.println(s);
        }
    }
    public Student searchStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }
    public void updateStudent(int id, double newGrade) {
        Student student = searchStudent(id);
        if (student != null) {
            student.setGrade(newGrade);
            System.out.println("Студенттің бағасы жаңартылды.");
        } else {
            System.out.println("Студент табылмады.");
        }
    }
    public void deleteStudent(int id) {
        students.removeIf(s -> s.getId() == id);
    }
}
