/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computelettergrades;

import java.util.Scanner;

/**
 *
 * @author AUTHOR: Matt Peter
 */
public class ComputeLetterGrades {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        
        // Declare variables
        String input;
        double la1, la2, inClassActivity1, exam1, exam2;
        double totalScore;
        
        // Enter Information
        System.out.print("Please enter your la1 score: ");
        la1 = keyboard.nextDouble();
        
        System.out.print("Please enter your la2 score: ");
        la2 = keyboard.nextDouble();
        
        System.out.print("Please enter your inClassActivity1 score: ");
        inClassActivity1 = keyboard.nextDouble();
        
        System.out.print("Please enter your exam1 score: ");
        exam1 = keyboard.nextDouble();
        
        System.out.print("Please enter your exam2 score: ");
        exam2 = keyboard.nextDouble();
        
        // Compute totalScore
        totalScore = ((la1 * .2) + (la2 * .2) + (inClassActivity1 * .1) + (exam1 * .2) + (exam2 * .3));
        
        // Print Transcript
        System.out.print("\n******** TRANSCRIPT ********\n\n");
        System.out.print("CS1110 Final Grade: ");
        
        // Determine Letter Grade / GPA
        if (totalScore >= 90) {
            System.out.print("A\n\n");
            System.out.print("You got a 4.0!  Outstanding!");
        } else if (totalScore >= 85) {
            System.out.print("BA\n\n");
            System.out.print("You got a 3.5!  Amazing!");
        } else if (totalScore >= 80) {
            System.out.print("B\n\n");
            System.out.print("You got a 3.0!  Awesome!");
        } else if (totalScore >= 75) {
            System.out.print("CB\n\n");
            System.out.print("You got a 2.5!  Great Job!");
        } else if (totalScore >= 70) {
            System.out.print("C\n\n");
            System.out.print("You got a 2.0!  Good Job!");
        } else if (totalScore >= 65) {
            System.out.print("DC\n\n");
            System.out.print("You got a 1.5.  You did okay.");
        } else if (totalScore >= 60) {
            System.out.print("D\n\n");
            System.out.print("You got a 1.0.  That's alright...... I guess.");
        } else {
            System.out.print("E\n\n");
            System.out.print("You got a 0.0.  You failed.");
        }
        
        System.out.print("\n\n****************************\n");
    }
    
}
