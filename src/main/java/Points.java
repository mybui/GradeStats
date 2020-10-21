/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MimiHMB
 */
import java.util.ArrayList;

public class Points {
    private ArrayList<Integer> points;
    private ArrayList<Integer> grades;
    
    public Points() {
        this.points = new ArrayList<Integer>();
        this.grades = new ArrayList<Integer>();
    }
    
    public int sum() {
        int sum = 0;
        for (int i: this.points) {
            if (i > 0) {
                sum += i;
            }    
        }
        return sum;
    }
    
    public ArrayList<Integer> passStats() {
        ArrayList<Integer> pass = new ArrayList<Integer>();
        int sum_pass = 0;
        int count_pass = 0;
        for (int i: this.points) {
            if (i >= 50) {
                sum_pass += i;
                count_pass += 1;
            }
        }
        pass.add(sum_pass);
        pass.add(count_pass);
        
        return pass;
    }
    
    public void add(int point) {
        if ((0 <= point) && (point <= 100)) {
            this.points.add(point);
            this.grades.add(pointsToGrade(point));
        }
    }
    
    public double averagePoint() {
        return (this.sum() * 1.0 / this.points.size());
    }
    
    public double averagePassingGrade() {
        return (this.passStats().get(0) * 1.0 / this.passStats().get(1));
    }
    
    public double passPercentage() {
        return (this.passStats().get(1) * 1.0 / this.points.size() * 100.0);
    }
    
    public static int pointsToGrade(int points) {
        int grade = 0;
        if (points < 50) {
            grade = 0;
        } else if (points < 60) {
            grade = 1;
        } else if (points < 70) {
            grade = 2;
        } else if (points < 80) {
            grade = 3;
        } else if (points < 90) {
            grade = 4;
        } else {
            grade = 5;
        }

        return grade;
    }
    
    public int numberOfGrades(int grade) {
        int count = 0;
        for (int received : this.grades) {
            if (received == grade) {
                count++;
            }
        }

        return count;
    }
        
    public void printGradeDistribution() {
        int grade = 5;
        while (grade >= 0) {
            int stars = this.numberOfGrades(grade);
            System.out.print(grade + ": ");
            printsStars(stars);
            System.out.println("");

            grade = grade - 1;
        }
        
    }

    public static void printsStars(int stars) {
        while (stars > 0) {
            System.out.print("*");
            stars--;
        }
    }
}
