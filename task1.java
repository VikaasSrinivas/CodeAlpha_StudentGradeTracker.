import java.util.*;

class Student {
    String name;
    int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double getAverage() {
        int sum = 0;
        for (int mark : marks) sum += mark;
        return (double) sum / marks.length;
    }

    int getHighest() {
        return Arrays.stream(marks).max().orElse(0);
    }

    int getLowest() {
        return Arrays.stream(marks).min().orElse(0);
    }

    void displayReport() {
        System.out.println("Name: " + name);
        System.out.println("Marks: " + Arrays.toString(marks));
        System.out.println("Average: " + getAverage());
        System.out.println("Highest: " + getHighest());
        System.out.println("Lowest: " + getLowest());
    }
}

public class GradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name of student: ");
            String name = sc.next();
            System.out.print("Enter number of subjects: ");
            int subjects = sc.nextInt();
            int[] marks = new int[subjects];
            for (int j = 0; j < subjects; j++) {
                System.out.print("Enter mark for subject " + (j + 1) + ": ");
                marks[j] = sc.nextInt();
            }
            students.add(new Student(name, marks));
        }

        System.out.println("\n--- Student Summary Report ---");
        for (Student s : students) {
            s.displayReport();
            System.out.println();
        }
        sc.close();
    }
}

