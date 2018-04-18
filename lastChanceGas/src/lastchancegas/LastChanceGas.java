/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lastchancegas;

import javax.swing.JOptionPane;
import java.lang.Math;

/**
 *
 * @author Matt Peter
 */
public class LastChanceGas {

    /**
     * @param args This program takes your vehicle's name and type (checking to 
     *             make sure that the type is valid), your vehicle's MPG, and the
     *             percentage of gas your vehicle has left in it and uses the information
     *             to calculate whether or not you will be able to reach the next
     *             gas station that is 200 miles from your current location
     */
    public static void main(String[] args) {
        
        // Instantiate all the variables and set some to specific values
        String vehicleName, vehicleType = "", input, plural = "";
        double distance, gaugeReading, tankCapacity;
        int gallonsNeeded, mpg = 0;
        int carMPG = 32;
        int suvMPG = 25;
        int truckMPG = 15;
        
        // Ask for information
        vehicleName = JOptionPane.showInputDialog("Please enter your vehicle's name (Ford, Toyota, GM, etc.): ");
        
        input = JOptionPane.showInputDialog("Please enter your vehicle's type (Car, SUV, or Truck): ");
        
        // check if Vehicle Type is valid
        if (input.trim().equalsIgnoreCase("Car")) {
            vehicleType = input;
            mpg = carMPG;
        }
        else if (input.trim().equalsIgnoreCase("SUV")) {
            vehicleType = input;
            mpg = suvMPG;
        }
        else if (input.trim().equalsIgnoreCase("Truck")) {
            vehicleType = input;
            mpg = truckMPG;
        }
        else {
            JOptionPane.showMessageDialog(null, "The vehicle type you entered is not compatible with this program." + 
                                                "\nWe cannot calculate the amount of gas you need.");
            System.exit(0);
        } 
        
        // Ask for more information
        input = JOptionPane.showInputDialog("Please enter your vehicle's fuel tank capacity (in gallons): ");
        tankCapacity = Double.parseDouble(input);
        
        input = JOptionPane.showInputDialog("Please enter the approximate percentage of fuel you have left in your tank: ");
        gaugeReading = Integer.parseInt(input);
        
        // Calculate the distance
        distance = ((gaugeReading / 100) * tankCapacity * mpg);
        
        
        // Display Information
        System.out.println("*****LAST CHANCE GAS*****");
        System.out.println("Vehicle Name: " + vehicleName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Tank Capacity: " + tankCapacity);
        System.out.println("Gauge Reading: " + gaugeReading);
        System.out.println();
        
        // Calculate if you have enough fuel
        if (distance >= (200 + mpg)) {
            System.out.println("It is safe to proceed!");
        }
        else if (distance >= 200) {
            System.out.println("Your " + vehicleName + " " + vehicleType + " barely has enough gas."
                                + "\nEither put at least 1 gallon in the tank or proceed with caution!");
        }
        else {
            gallonsNeeded = (int)Math.ceil((200 - distance) / mpg);
            if (gallonsNeeded > 1) {
                plural = "s";
            }
            System.out.println("You should put at least " + gallonsNeeded + " gallon" + plural
                                + " in your " + vehicleName + " " + vehicleType);
        }
        
        System.out.println("************************");
        
        System.exit(0);
    }
    
}
