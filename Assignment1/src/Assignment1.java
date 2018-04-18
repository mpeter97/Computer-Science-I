/*
 * PROJECT: Assignment 1
 * AUTHOR: Matt Peter
 * DESCRIPTION: Calculate the cost of commuting from home to the CEAS building
 *              alone, with 1 other person, and with 2 other people
 */

/**
 *
 * @author Matt
 */
public class Assignment1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Given Information
        int daysPerWeek = 3;                // Days class is held per week
        int weeksPerSemester = 15;          // Weeks in a semester of class
        int averageMPG = 18;                // Average MPG of car
        int distance = 23;                  // Distance to campus (miles)
        double priceOfGas = 2.12;           // Price of gas ($)
        
        // Calculated Information
        int tripsPerSemester;               // Round trips per semester
        int milesPerTrip;                   // Miles per round trip
        int milesPerSemester;               // Miles per semester
        double gallonsPerTrip;              // Gallons used per round trip
        double costPerTrip;                 // Cost per trip
        double costPerSemester1;            // Total cost per semester (1 person)
        double costPerSemester2;            // Total cost per semester (2 people)
        double costPerSemester3;            // Total cost per semester (3 people)
        
        
        // Calculations
        tripsPerSemester = daysPerWeek * weeksPerSemester;
        milesPerTrip = distance * 2;
        milesPerSemester = tripsPerSemester * milesPerTrip;
        gallonsPerTrip = (double)(milesPerTrip / averageMPG);
        costPerTrip = priceOfGas * gallonsPerTrip;
        costPerSemester1 = costPerTrip * tripsPerSemester;
        costPerSemester2 = (costPerTrip * tripsPerSemester) / 2;
        costPerSemester3 = (costPerTrip * tripsPerSemester) / 3;
        
        // Display Information
        System.out.println("********** Welcome to RideShare **********");
        System.out.println();
        System.out.println("STARTING DATA");
        System.out.println("-------------");
        System.out.println("Class data:");
        System.out.println("\tnumber days/week the class meets:  " + daysPerWeek);
        System.out.println("\tnumber weeks in the semester:  " + weeksPerSemester);
        System.out.println("Gas data:");
        System.out.println("\tthe car's average mpg:  " + averageMPG + " miles");
        System.out.println("\tprice of gas (per gallon):  $" + priceOfGas);
        System.out.println("Journey data:");
        System.out.println("\tdistance (1-way) to CEAS/Parkview:  " + distance + " miles");
        System.out.println();
        System.out.println("RESULTS");
        System.out.println("-------");
        System.out.println("Number of round trips/semester:  " + tripsPerSemester);
        System.out.println("Total number of miles/semester:  " + milesPerSemester);
        System.out.println("Cost for 1 round-trip (for gas):  $" + costPerTrip);
        System.out.println("Total cost for the semester (for gas):  $" + costPerSemester1 + "0");
        System.out.println();
        System.out.println("For 1 person:  $" + costPerSemester1 + "0 for the semester");
        System.out.println("For 2 people sharing:  $" + costPerSemester2 + "0 per person for the semester");
        System.out.println("For 3 people sharing:  $" + costPerSemester3 + "0 per person for the semester");
        System.out.println();
        System.out.println("********** END OF REPORT ***********");
        
        
    }
    
}
