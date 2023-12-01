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
        int totalSubject;
        int totalScoreAvailable;
        int averagePercentage;
        int totalStudentScore = 0;
        String subject;
        int score;

        System.out.println("Enter total number of subjects.");
        totalSubject =  scanner.nextInt();
        Map<String, Integer> subjects = new HashMap<>();
        System.out.println("Enter each subject and its score.");
        for (int i = 1; i <= totalSubject; i++) {
            System.out.print("Subject "+ i + " = ");
            subject = scanner.next();
            System.out.print(subject + " score = " );
            score = scanner.nextInt();
            totalStudentScore = totalStudentScore + score;
            subjects.put(subject, score);
        }
        totalScoreAvailable = (subjects.size() * 100);
        System.out.println(totalScoreAvailable);
        System.out.println(totalStudentScore);
        averagePercentage = ((totalStudentScore/totalScoreAvailable) * 100);
        System.out.println(averagePercentage);
        System.out.println(subjects);
        for (Map.Entry<String, Integer> course : subjects.entrySet()){
            String key = course.getKey();
            int value = course.getValue();
            System.out.println("Subject = " + key + ", Score = " + value);
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
