/*
 * AUTHOR: Matt Peter
 * CLASS: CS 1110 MW 4:00-5:15 PM
 * TIME LAST EDITED: 3/16/2016 3:58 PM
 * DESCRIPTION: This program asks the user to enter how many years worth of 
 *              humidity percentage data they want, randomly generates data
 *              for each month in that number of years, and then prints out
 *              calculated results.  These results include the minimum, maximum
 *              median, mode(s), and mean of the data for each year, as well as for
 *              all of the data from all of the years.
 */
package humidityhelper;

import java.util.*;
import java.text.DecimalFormat;

/**
 *
 * @author Matt Peter
 */
public class HumidityHelper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Declare a Random number generator and DecimalFormat
        Random rand = new Random();
        DecimalFormat formatter = new DecimalFormat("00.00");
        
        // Declare and instantiate variables needed
        double overallMean = 0.0, overallMedian = 0.0, overallMaximum = 0.0, overallMinimum = 0.0;  // Holds calculations based on all data
        double yearMean, yearMedian, yearMaximum, yearMinimum;                                      // Holds calculations based on yearly data
        int nYears = 0;                                                                             // Contains total number of years
        int currentYear;                                                                            // Keeps track of current year
        double[] overallModes;                                                                      // Holds modes for all data
        double[] yearModes;                                                                         // Holds modes for yearly data
        boolean overallModesExist = false;                                                          // Tells whether or not there are any modes for all data
        boolean modesExist;                                                                         // Tells whether or not there are any modes for yearly data
        double[] humidityData;                                                                      // Holds the randomly generated data
        
        // Ask for the number of years over which data will be displayed
        System.out.print("Enter the number of years you would like data for: ");
        
        // Check to make sure value entered is valid
        nYears = isValidInput();
        
        // Allocate enough space for the arrays to hold all of the data
        overallModes = new double[nYears * 12];
        humidityData = new double[nYears * 12];
        
        // Start with Year 1
        currentYear = 1;
        
        // Print a title for the data
        System.out.println("\nMonthly Humidity Statistics for YetToBeNamedCity in percentages");
        System.out.println("----------------------------------------------------------------");
        
        // Enter into a do-while loop that generates and prints all of the yearly data
        do {
            // Instantiate/Reset values of locally used variables
            yearMean = 0.0;
            yearMedian = 0.0;
            yearMaximum = 0.0;
            yearMinimum = 0.0;
            yearModes = new double[6];
            modesExist = false;
            
            // Generate random data for current year
            for (int i = 0; i < 12; i++) {
                humidityData[(12 * (currentYear - 1)) + i] = (int)(rand.nextDouble() * 10000.0) / 100.0;
            }
            
            // Use the sortArray method to sort the yearly data
            humidityData = sortArray(humidityData, currentYear, false);

            // Find the minimum, maximum, median, mode(s), and mean for the current year
            yearMinimum = findMinimum(humidityData, currentYear, false);
            yearMaximum = findMaximum(humidityData, currentYear, false);
            yearMedian = findMedian(humidityData, currentYear, false);
            yearModes = findModes(humidityData, currentYear, false);
            yearMean = findMean(humidityData, currentYear, false);
            
            // Print out calculated values
            System.out.print("Year " + currentYear + ": ");
            System.out.print("Minimum: " + formatter.format(yearMinimum) + "   ");
            System.out.print("Maximum: " + formatter.format(yearMaximum) + "   ");
            System.out.print("Median: " + formatter.format(yearMedian) + "   ");
            System.out.print("Mode(s): ");
            
            // For modes, if some exist, print them out, otherwise, print out the word "None"
            for (int k = 0; k < 6; k++) {
                if (yearModes[k] != -1) {
                    System.out.print(formatter.format(yearModes[k]) + "  ");
                    modesExist = true;
                }
            }
            
            if (modesExist == false)
                System.out.print("None   ");
            
            System.out.println("Mean: " + formatter.format(yearMean));
            
            // Increase the current year by 1
            currentYear++;
            
        } while (currentYear <= nYears);
        
        // Use the sortArray method to sort all of the data
        humidityData = sortArray(humidityData, nYears, true);
        
        // Find the minimum, maximum, median, mode(s), and mean for all of the data
        overallMinimum = findMinimum(humidityData, nYears, true);
        overallMaximum = findMaximum(humidityData, nYears, true);
        overallMedian = findMedian(humidityData, nYears, true);
        overallModes = findModes(humidityData, nYears, true);
        overallMean = findMean(humidityData, nYears, true);
        
        // Print out calculated values
        System.out.println("\nOver a time span of " + nYears * 12 + " months, the humidity statistics are:");
        System.out.print("        Minimum: " + formatter.format(overallMinimum) + "   ");
        System.out.print("Maximum: " + formatter.format(overallMaximum) + "   ");
        System.out.print("Median: " + formatter.format(overallMedian) + "   ");
        System.out.print("Mode(s): ");
        
        // For modes, if some exist when comparing all of the data, print them out, otherwise, print out the word "None"
        for (int k = 0; k < nYears * 6; k++) {
            if (overallModes[k] != -1) {
                System.out.print(formatter.format(overallModes[k]) + "  ");
                overallModesExist = true;
            }
        }
        
        if (overallModesExist == false)
            System.out.print("None   ");
        
        System.out.println("Mean: " + formatter.format(overallMean) + "\n\n");
    }
    
    /*
     * INPUT: double[], int, boolean
     * OUTPUT: double
     * DESCRIPTION: This method takes in an array that holds humidity data, the current year,
     *              and a boolean that tells whether it is calculating data for a specific
     *              year (false) or for all of the data (true).  Depending on whether this
     *              boolean is true or false, it figures out the minimum value of the already 
     *              sorted data, rounds it to 2 decimal places, and returns that value to the
     *              main method.
     * AUTHOR: Matthew Peter
     * TIME LAST EDITED: 3/16/2016 9:27 AM
     */
    public static double findMinimum (double[] humidData, int year, boolean overall) {
        double minimum;
        
        if (overall == false)
            minimum = humidData[12 * (year - 1)];
        else
            minimum = humidData[0];
        
        minimum = (double)Math.round(minimum * 100) / 100;
        return minimum;
    }
    
    /*
     * INPUT: double[], int, boolean
     * OUTPUT: double
     * DESCRIPTION: This method takes in an array that holds humidity data, the current year,
     *              and a boolean that tells whether it is calculating data for a specific
     *              year (false) or for all of the data (true).  Depending on whether this
     *              boolean is true or false, it figures out the maximum value of the already 
     *              sorted data, rounds it to 2 decimal places, and returns that value to the
     *              main method.
     * AUTHOR: Matthew Peter
     * TIME LAST EDITED: 3/16/2016 3:23 PM
     */
    public static double findMaximum (double[] humidData, int year, boolean overall) {
        double maximum;
        
        if (overall == false)
            maximum = humidData[(12 * year) - 1];
        else
            maximum = humidData[(12 * year) - 1];
        
        maximum = (double)Math.round(maximum * 100) / 100;
        return maximum;
    }
    
    /*
     * INPUT: double[], int, boolean
     * OUTPUT: double
     * DESCRIPTION: This method takes in an array that holds humidity data, the current year,
     *              and a boolean that tells whether it is calculating data for a specific
     *              year (false) or for all of the data (true).  It takes the two values that
     *              are at the center of all the ordered data and finds the average of those
     *              two values (this is because you have an even number of values, the median
     *              becomes the average of two of the values).  It then rounds this value to 
     *              2 decimal places, and returns that value to the main method.
     * AUTHOR: Matthew Peter
     * TIME LAST EDITED: 3/16/2016 3:25 PM
     */
    public static double findMedian (double[] humidData, int year, boolean overall) {
        double median;
        
        if (overall == false)
            median = (humidData[(12 * year) - 7] + humidData[(12 * year) - 6]) / 2.0;
        else
            median = (humidData[((12 * year) / 2) - 1] + humidData[(12 * year) / 2]) / 2.0;
        
        median = (double)Math.round(median * 100) / 100;
        return median;
    }
    
    /*
     * INPUT: double[], int, boolean
     * OUTPUT: double[]
     * DESCRIPTION: This method takes in an array that holds humidity data, the current year,
     *              and a boolean that tells whether it is calculating data for a specific
     *              year (false) or for all of the data (true).  It goes through all of the data,
     *              and since the data has already been ordered, if one of the values occurs
     *              multiple times, it counts how many times it occurs, and stores that value
     *              in an array at the position where it started.  Another for loop then goes
     *              through and finds the largest number of times that a value occurs.  If more
     *              than one value occurs that number of times, it keeps track of all the values.
     *              It then rounds those values to 2 decimal places and returns them to the main method.
     * AUTHOR: Matthew Peter
     * TIME LAST EDITED: 3/16/2016 3:28 PM
     */
    public static double[] findModes (double[] humidData, int year, boolean overall) {
        
        if (overall == false) {
            // Declare variables
            double mostInst = 1;                    // Keeps track of the most occurences a specific value has had
            double[] modes = new double[6];         // Holds all the final modes
            double[] tempModes = new double[6];     // Temporarily holds modes unless a number that occurs more is found
            int[] numInstArr = new int[12];         // Holds the number of instances of each value
            int currentModesStart = -1;             // Keeps track of where a streak of the same value (modes) starts
            int modesArraySpot = 0;                 // Allows for multiple modes to be stored
            
            // Assume to start that each number occurs once
            for (int a = 0; a < 12; a++)
                numInstArr[a] = 1;
            
            // Assume to start that there are no modes
            for (int b = 0; b < 6; b++) {
                tempModes[b] = -1;
                modes[b] = -1;
            }
            
            // Figure out how many times each value occurs
            for (int i = 12 * (year - 1); i < 12 * year - 1; i++) {
                if (humidData[i] == humidData[i + 1] && currentModesStart == -1) {
                    currentModesStart = i % 12;
                    numInstArr[currentModesStart]++;
                } else if (humidData[i] == humidData[i + 1] && currentModesStart != -1) {
                    numInstArr[currentModesStart]++;
                } else {
                    currentModesStart = -1;
                }
            }
            
            // Find which value(s) occur the most
            for (int j = 0; j < 12; j++) {
                if (numInstArr[j] > mostInst) {
                    tempModes[0] = humidData[12 * (year - 1) + j];
                    for (int l = 1; l < 6; l++)
                        tempModes[l] = -1;
                    mostInst = numInstArr[j];
                    modesArraySpot = 1;
                } else if (numInstArr[j] == mostInst && mostInst != 1) {
                    tempModes[modesArraySpot] = humidData[12 * (year - 1) + j];
                    modesArraySpot++;
                }
            }
            
            // Round the modes to 2 decimal places and return
            for (int m = 0; m < 6; m++) {
                if (tempModes[m] != -1) {
                    modes[m] = (double)Math.round(tempModes[m] * 100) / 100;
                } else {
                    modes[m] = -1;
                }       
            }
            
            return modes;
            
        } else {
            // Same as finding yearly modes, just with using all of the data instead of just 12 values
            double mostInst = 1;
            double[] modes = new double[year * 6];
            double[] tempModes = new double[year * 6];
            int[] numInstArr = new int[year * 12];
            int currentModesStart = -1;
            int modesArraySpot = 0;

            for (int a = 0; a < year * 12; a++)
                numInstArr[a] = 1;
            
            for (int b = 0; b < year * 6; b++) {
                tempModes[b] = -1;
                modes[b] = -1;
            }           

            for (int i = 0; i < 12 * year - 1; i++) {
                if (humidData[i] == humidData[i + 1] && currentModesStart == -1) {
                    currentModesStart = i % 12;
                    numInstArr[currentModesStart]++;
                } else if (humidData[i] == humidData[i + 1] && currentModesStart != -1) {
                    numInstArr[currentModesStart]++;
                } else {
                    currentModesStart = -1;
                }
            }

            for (int j = 0; j < 12 * year; j++) {
                if (numInstArr[j] > mostInst) {
                    tempModes[0] = humidData[j];
                    for (int l = 1; l < 6 * year; l++)
                        tempModes[l] = -1;
                    mostInst = numInstArr[j];
                    modesArraySpot = 1;
                } else if (numInstArr[j] == mostInst && mostInst != 1) {
                    tempModes[modesArraySpot] = humidData[j];
                    modesArraySpot++;
                }
            }

            for (int m = 0; m < 6 * year; m++) {
                if (tempModes[m] != -1)
                    modes[m] = (double)Math.round(tempModes[m] * 100) / 100;
                else
                    modes[m] = -1;
            }
            
            return modes;
        }
        
        
    }
    
    /*
     * INPUT: double[], int, boolean
     * OUTPUT: double
     * DESCRIPTION: This method takes in an array that holds humidity data, the current year,
     *              and a boolean that tells whether it is calculating data for a specific
     *              year (false) or for all of the data (true).  It sums up all of the data
     *              in either the specified section of the array, or the entire array, and divides
     *              by either 12 if it is a specific year, or the total number of months in the
     *              array if it is figuring out the mean of the entire length of time. It then rounds
     *              the calculated mean value to 2 decimal places and returns it to the main method.
     * AUTHOR: Matthew Peter
     * TIME LAST EDITED: 3/16/2016 3:31 PM
     */
    public static double findMean (double[] humidData, int year, boolean overall) {
        
        // Declare variables
        double mean;            // The calculated mean
        double sum = 0.0;       // The sum of all of the values being used
        
        if (overall == false) {
            // Yearly: Adds up 12 values and divides by 12
            for (int i = 12 * (year - 1); i < 12 * year; i++)
                sum += humidData[i];

            mean = sum / 12.0;
        } else {
            // Overall: Adds up all the values and divides by the (number of years) * 12
            for (int i = 0; i < year * 12; i++)
                sum += humidData[i];
            
            mean = sum / (12.0 * year);
        }

        mean = (double)Math.round(mean * 100) / 100;
        return mean;
    }
    
    /*
     * INPUT: double[], int, boolean
     * OUTPUT: double[]
     * DESCRIPTION: This method takes in an array that holds humidity data, the current year,
     *              and a boolean that tells whether it is calculating data for a specific
     *              year (false) or for all of the data (true).  It starts at the first value
     *              of the given array, and compares that to every other value in the array
     *              to find the smallest value.  If a smaller value is found in the array,
     *              the values being compared are switched around.  A temporary variable is
     *              used to store one of the values while the other one is being placed in the
     *              position of the first one.  The temporary variable's value is then placed
     *              in the original position of the second value.  This process is continued
     *              until all of the values are in order from smallest to largest.  The sorted
     *              array is then returned to the main method.
     * AUTHOR: Matthew Peter
     * TIME LAST EDITED: 3/16/2016 3:36 PM
     */
    public static double[] sortArray (double [] humidData, int year, boolean overall) {
        
        // Declare variables
        double smallest;        // Holds the smallest value of the group being looked through
        int posOfSmallest = 0;  // Keeps track of the position in the array of smallest
        double temp;            // Used to switch 2 values
        
        if (overall == false) {
            
            for (int i = 0; i < 12; i++) {
                // Reset smallest to allow for new smallest value
                smallest = 1000.0;
                
                // Find the smallest
                for (int j = (12 * (year - 1)) + i; j < 12 * year; j++) {
                    if (humidData[j] < smallest) {
                        smallest = humidData[j];
                        posOfSmallest = j;
                    }
                }
                
                // Switch the values
                temp = humidData[(12 * (year - 1)) + i];
                humidData[(12 * (year - 1)) + i] = humidData[posOfSmallest];
                humidData[posOfSmallest] = temp;

            }
        } else {
            
            for (int i = 0; i < year * 12; i++) {
                // Reset smallest to allow for new smallest value
                smallest = 1000.0;
                
                // Find the smallest
                for (int j = i; j < year * 12; j++) {
                    if (humidData[j] < smallest) {
                        smallest = humidData[j];
                        posOfSmallest = j;
                    }
                }
                
                // Switch the values
                temp = humidData[i];
                humidData[i] = humidData[posOfSmallest];
                humidData[posOfSmallest] = temp;
                
            }
        }
        
        return humidData;
    }
    
    /*
     * INPUT: none
     * OUTPUT: int
     * DESCRIPTION: This method checks to make sure the input that the user enters is acceptable
     *              by asking for a new value when the entry is not an integer, or the integer
     *              does not fit in the range of 2 to 80.  When an acceptable value is entered,
     *              it is returned to the main method.
     * AUTHOR: Matthew Peter
     * TIME LAST EDITED: 3/16/2016 3:25 PM
     */
    public static int isValidInput () {
        
        // Declare a Scanner
        Scanner kbrd = new Scanner(System.in);
        
        // Declare needed variables
        int input = 0;              // Stores the input
        boolean valid = false;      // States whether or not the input is valid
        
        do {
                if (kbrd.hasNextInt()) {
                    // If the user entered a number, store that in amountBet and clear any extra input
                    input = kbrd.nextInt();
                    kbrd.nextLine();
                        if (input <= 1 || input > 80) {
                            // If the amount entered cannot be rounded to $0.01 or greater, ask the user to enter a different amount
                            System.out.print("Number of years must be in the range 2 to 80. Please enter another value: ");
                            valid = false;
                        } else {
                            // Otherwise, the amount entered is acceptable
                            valid = true;
                        }
                } else {
                    // If the user did not enter a number, ask the user to enter a different amount
                    System.out.print("Number of years must be in the range 2 to 80. Please enter another value: ");
                    kbrd.nextLine();
                    valid= false;
                }
            } while (valid == false);
        
        return input;
    }
    
}

