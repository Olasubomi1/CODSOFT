import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("STUDENT GRADE CALCULATOR");
        Main.calculateGrade();
    }
    private static void calculateGrade(){
        int totalCourses;
        int totalScoreAvailable;
        int averagePercentage;
        int totalStudentScore = 0;
        String course;
        int score;

        System.out.println("Enter total number of courses.");
        totalCourses =  scanner.nextInt();
        Map<String, Integer> courses = new HashMap<>();
        System.out.println("Enter each course and its score.");
        for (int i = 1; i <= totalCourses; i++) {
            System.out.print("Course "+ i + " = ");
            course = scanner.next();
            System.out.print(course + " score = " );
            score = scanner.nextInt();
            totalStudentScore = totalStudentScore + score;
            courses.put(course, score);
        }
        totalScoreAvailable = (courses.size() * 100);
        averagePercentage = ((totalStudentScore * 100/totalScoreAvailable));
        for (Map.Entry<String, Integer> currentCourse : courses.entrySet()){
            String key = currentCourse.getKey();
            int value = currentCourse.getValue();
            System.out.println("Course = " + key + ", Score = " + value);
        }
        String studentGrade = new Main().assignGrade(averagePercentage);
        System.out.println("Student Average percentage = " + averagePercentage + "%" + "\nStudent Grade = " + studentGrade);
    }
    private String assignGrade(int averagePercentage){
        if (averagePercentage >= 70) return "A";
        if (averagePercentage >= 60) return "B";
        if (averagePercentage >= 50) return "C";
        if (averagePercentage >= 45) return "D";
        if (averagePercentage >= 40) return "E";
        return "F";
    }
}
