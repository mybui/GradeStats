
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter points totals, -1 stops:");
        Points points = new Points();
        
        while (true) {
            int point = Integer.valueOf(scanner.nextLine());
            
            if (point == -1) {
                break;
            }
            
            points.add(point);
        }
        
        System.out.println("Point average (all): " + points.averagePoint());
        System.out.println("Point average (passing): " + points.averagePassingGrade());
        System.out.println("Pass percentage: " + points.passPercentage());
        System.out.println("Grade distribution:");
        points.printGradeDistribution();
    }
}
