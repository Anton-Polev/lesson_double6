import java.util.*;

public class Student {
    private String name;
    private String group;
    private int course;
    private Map<String, Integer> grades;

    public Student(String name, String group, int course) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public void addGrade(String subject, int grade) {
        grades.put(subject, grade);
    }

    public Integer getGrade(String subject) {
        return grades.get(subject);
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) return 0;
        double sum = 0;
        for (int grade : grades.values()) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public static void removeLowAverage(List<Student> students) {
        students.removeIf(s -> s.getAverageGrade() < 3);
    }

    public void promoteIfPass() {
        if (getAverageGrade() >= 3) {
            course++;
        }
    }

    public void printGrades() {
        for (Map.Entry<String, Integer> entry : grades.entrySet()) {
            System.out.println("Предмет: " + entry.getKey() + ", Оценка: " + entry.getValue());
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        Student student1 = new Student("Студент_1", "Группа A", 1);
        student1.addGrade("Физра", 5);
        students.add(student1);

        Student student2 = new Student("Студент_2", "Группа 1A", 2);
        student2.addGrade("Физра", 4);
        students.add(student2);

        Student student3 = new Student("Студент_3", "Группа 1", 3);
        student3.addGrade("Физра", 3);
        students.add(student3);

        Student student4 = new Student("Студент_4", "Группа 2", 4);
        student4.addGrade("Физра", 2);
        students.add(student4);

        Student student5 = new Student("Студент_5", "Группа 2A", 5);
        student5.addGrade("Физра", 1);
        students.add(student5);

        removeLowAverage(students);

        for (Student student : students) {
            student.promoteIfPass();
        }

        System.out.println("Студенты на 1 курсе:");
        printStudents(new HashSet<>(students), 1);

        System.out.println("Студенты на 2 курсе:");
        printStudents(new HashSet<>(students), 2);

        System.out.println("Студенты на 3 курсе:");
        printStudents(new HashSet<>(students), 3);

        System.out.println("Студенты на 4 курсе:");
        printStudents(new HashSet<>(students), 4);

        System.out.println("Студенты на 5 курсе:");
        printStudents(new HashSet<>(students), 5);

        System.out.println("--------------------");

        System.out.println("Оценки студентов:");
        for (Student student : students) {
            System.out.println(student.getName() + ":");
            student.printGrades();
        }
    }
}
