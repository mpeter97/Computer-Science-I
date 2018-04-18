/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matt
 */
public class Wages {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double regularWages,       // Regular wages.
               basePay = 25,       // Base pay rate. 
               regularHours = 40,  // Hours worked less overtime.
               overtimeWages,      // Overtime wages
               overtimePay = 37.5, // Overtime pay rate
               overtimeHours = 10, // Overtime hours worked
               totalWages,         // Total wages
               vacationCost = 1500; // Cost of vacation
   
      // Calculate the regular wages.
      regularWages = basePay * regularHours;
      
      // Calculate the overtime wages.
      overtimeWages = overtimePay * overtimeHours;
      
      // Calculate the total wages.
      totalWages = regularWages + overtimeWages;
      
      // Display the total wages.
      System.out.print("Wages for this week are $");
      System.out.println(totalWages);
      
      // Display vacation problem
      System.out.println("After going on a vacation that cost $1500, "
                        + "you will need to work "
                        + (vacationCost / overtimePay) + " more hours"
                        + " in order to pay for the vacation.");
    }
    
}
