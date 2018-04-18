// CLASS:  Query used by PROJECT:  WorldDataQuerySystem
// AUTHOR:  Matt Peter
// DESCRIPTION:  This class is used to print out results that are requested
//               by the user in the main method.  Using the UserInteraction class
//               to get the user's response to questions displayed in the console,
//               it then displays the information the user asked for by using
//               methods specific to the option, as well as methods that can
//               be used in several cases.  After figuring out what data the user
//               wants, it then prints out the resulting information to the console
//               in a user-friendly way.
//
//*****************************************************************************
package worlddataquerysystem;

import java.io.*;
import java.text.DecimalFormat;

public class Query {  
    
    // Declare and Instantiate an object for the UserInteraction and DecimalFormat classes
    // These will be able to be used throughout the Query class
    static UserInteraction UI = new UserInteraction();                  // Used to reference the UserInteraction class
    static DecimalFormat OneDecimalPlace = new DecimalFormat("#0.0");   // Used to round values to one decimal place
    static DecimalFormat Commas = new DecimalFormat("#,##0");           // Used to insert commas into large numbers
    
    
    /*
     * Input: String[], String[], int[], long[], double[], int[], int
     * Output: None
     * Description: This method is given the 6 arrays of data, along with
     *              how many pieces of data there are in all the arrays.
     *              It starts out by getting the name of a country from the
     *              user, by using the getCountry() method in the UserInteraction
     *              class.  It then uses the binarySearch() method to find the
     *              position of that country in the name array.  Once it has found
     *              that country's position, it uses that value to print out the
     *              country's name, continent, land area, population, life expectancy,
     *              and GNP, by printing the value in the same position in each
     *              of those arrays.  It then also calculates and prints out the population
     *              density and GNP per person.
     * Author: Matthew Peter
     * Date/Time: 4/11/16 1:35p
     */
    public static void showDataFor1Country (String[] name, String[] continent, int[] landArea,
                                            long[] population, double[] lifeExpectancy, int[] gnp, int n) {
        
        // Declare variables
        String country = UI.getCountry();   // Used to store the value returned by the getCountry method
        int ArrPos;                         // Used to store the position in the arrays of the country the user entered
        
        // Run the binarySearch method and store the returned value in ArrPos
        ArrPos = binarySearch (name, country, n);
        
        // Print out all of the information about the country
        System.out.println("\n---------------------------------");
        System.out.println("Country Name: " + name[ArrPos]);
        System.out.println("Continent: " + continent[ArrPos]);
        System.out.println("Land Area: " + landArea[ArrPos]);
        System.out.println("Population: " + population[ArrPos]);
        System.out.println("Life Expectancy: " + lifeExpectancy[ArrPos]);
        System.out.println("GNP (Gross National Product): " + gnp[ArrPos]);
        System.out.println("Population Density: " + Double.parseDouble(OneDecimalPlace.format(((double)population[ArrPos] / landArea[ArrPos]))));
        System.out.print("GNP per Person: ");
        if (population[ArrPos] == 0.0)
            System.out.println("0.0");
        else
            System.out.println(Double.parseDouble(OneDecimalPlace.format(((double)gnp[ArrPos] / population[ArrPos]))));
        System.out.println("---------------------------------\n");
    }
    
    /*
     * Input: String[], String, int
     * Output: int
     * Description: This method is given a String array, a String value, and an
     *              integer value as input, and returns an integer value.  It uses
     *              binary search methods to find the position of the country's
     *              name (String value that was passed) in an array of country
     *              names (String array that was passed).  When the country's
     *              position in the array is found, that position value is returned.
     * Author: Matthew Peter
     * Date/Time: 4/11/16 1:23p
     */
    private static int binarySearch (String[] allNames, String specificName, int n) {
        
        // Declare and Instantiate variables
        String temp;                        // Used to store name of the country that is currently being compared
        int currentArrPos = n / 2;          // Used to store the current position in the array that is being checked
        int difference = n / 4;             // Used to check how much will be added or subtracted from the array position (binary search)
        boolean countryFound = false;       // Used to signify if the country has been located
        
        // Enter into a do-while loop that uses binary search methods to locate the country
        do {
            temp = allNames[currentArrPos].toUpperCase();
            
            // If the current position is lower than the country's, increase the position, and vice versa
            if (temp.compareTo(specificName) < 0)
                currentArrPos += difference;
            else if (temp.compareTo(specificName) > 0)
                currentArrPos -= difference;
            else
                countryFound = true;
            
            // Convert the amount subtracted/added to a double to get a more accurate value
            difference = (int)Math.round((double)difference / 2.0);
            
        } while (countryFound == false);
        
        // Return the country's position in the array
        return currentArrPos;
    }
    
    /*
     * Input: String[], String[], int
     * Output: None
     * Description: This method is given 2 String arrays and an integer value
     *              as input, and returns nothing.  It goes through all the countries
     *              in the name array, comparing their continent to the one returned
     *              by the getContinent() method in the UserInteraction class.
     *              If the continents match, the country's name is printed out
     *              on the console.  Otherwise, nothing is printed, and the method 
     *              moves on to the next country  in the name array.
     * Author: Matthew Peter
     * Date/Time: 4/11/16 1:48p
     */
    public static void showAllCountriesInContinent(String[] name, String[] continent, int n) {
        // Declare and Instantiate a String to the value returned by getContinent
        String chosenContinent = UI.getContinent();
        
        System.out.println("\n---------------------------------");
        
        // Print out the names of all the countries that have a continent equal to the value of chosenContinent
        for (int i = 0; i < n; i++) {
            if (continent[i].toUpperCase().equals(chosenContinent))
                System.out.println(name[i]);
        }
        
        System.out.println("---------------------------------\n");
    }
    
    /*
     * Input: String[], String[], double[], int
     * Output: None
     * Description: This method is given 2 String arrays, a double array, and
     *              an integer value as input, and returns nothing.  It simply
     *              finds the highest value in the lifeExpectancy array by using
     *              the findMax() method, the lowest value that isn't 0.0 in the
     *              lifeExpectancy array by using the findMin() method, and computes
     *              the average value in the lifeExpectancy array (not including
     *              0.0 values) using the findAve() method.  It then prints out
     *              all this information to the console.
     * Author: Matthew Peter
     * Date/Time: 4/11/16 1:52p
     */
    public static void showLifeExpStats(String[] name, String[] continent, double[] lifeExpectancy, int n) {
        // Find the maximum, minimum, and average value in the lifeExpectancy array
        int max = findMax(lifeExpectancy, n);
        int min = findMin(lifeExpectancy, n);
        double ave = findAve(lifeExpectancy, n);
        
        // Print out the Life Expectancy Stats
        System.out.println("\n---------------------------------");
        System.out.println("Life Expectancy Stats:");
        System.out.println("Max: Country: " + name[max] + ", Continent: " + continent[max] + ", Stat: " + lifeExpectancy[max]);
        System.out.println("Min: Country: " + name[min] + ", Continent: " + continent[min] + ", Stat: " + lifeExpectancy[min]);
        System.out.println("Average: " + ave);
        System.out.println("---------------------------------\n");
    }
    
    /*
     * Input: String[], String[], int[], int
     * Output: None
     * Description: This method is given 2 String arrays, an integer array, and
     *              an integer value as input, and returns nothing.  It starts off
     *              by calling the getAllOrContinent() method in the UserInteraction
     *              class to find out if the user wants the land area stats for a
     *              specific continent, or for the whole world.  Depending on what
     *              is chosen, it then finds the highest value in the landArea array by using
     *              the findMax() method, the lowest value that isn't 0.0 in the
     *              landArea array by using the findMin() method, and computes the average
     *              value in the landArea array (not including 0.0 values) using the
     *              findAve() method, all of this while making sure to only use the data
     *              for a specific continent, if one is chosen.  It then prints out all
     *              this information to the console.
     * Author: Matthew Peter
     * Date/Time: 4/11/16 1:54p
     */
    public static void showLandAreaStats(String[] name, String[] continent, int[] landArea, int n) {
        // Declare and Instantiate a String to the value returned by getAllOrContinent
        String allOrContinent = UI.getAllOrContinent();
        
        // Declare variables used to store the maximum, minimum, and average values
        int max;
        int min;
        double ave;
        
        // If the value of the String allOrContinent is "ALL", find the values based on all the countries
        if (allOrContinent.equals("ALL")) {
            max = findMax(landArea, n);
            min = findMin(landArea, n);
            ave = findAve(landArea, n);
        // Otherwise, find the values based on the continent chosen
        } else {
            max = findMax(landArea, continent, allOrContinent, n);
            min = findMin(landArea, continent, allOrContinent, n);
            ave = findAve(landArea, continent, allOrContinent, n);
        }
        
        // Print out the Land Area Stats
        System.out.println("\n---------------------------------");
        System.out.println("Land Area Stats:");
        System.out.println("Continent: " + allOrContinent);
        System.out.println("Max: Country: " + name[max] + ", Continent: " + continent[max] + ", Stat: " + landArea[max]);
        System.out.println("Min: Country: " + name[min] + ", Continent: " + continent[min] + ", Stat: " + landArea[min]);
        System.out.println("Average: " + ave);
        System.out.println("---------------------------------\n");
    }
    
    /*
     * Input: String[], String[], long[], int
     * Output: None
     * Description: This method is given 2 String arrays, a long array, and
     *              an integer value as input, and returns nothing.  It simply
     *              finds the highest value in the population array by using
     *              the findMax() method, the lowest value that isn't 0 in the
     *              population array by using the findMin() method, and computes
     *              the average value in the population array (not including
     *              0 values) using the findAve() method.  It then prints out
     *              all this information to the console.
     * Author: Matthew Peter
     * Date/Time: 4/11/16 1:58p
     */
    public static void showPopStats(String[] name, String[] continent, long[] population, int n) {
        // Find the maximum, minimum, and average value in the population array
        int max = findMax(population, n);
        int min = findMin(population, n);
        double ave = findAve(population, n);
        
        // Print out the Population Stats
        System.out.println("\n---------------------------------");
        System.out.println("Population Stats:");
        System.out.println("Max: Country: " + name[max] + ", Continent: " + continent[max] + ", Stat: " + population[max]);
        System.out.println("Min: Country: " + name[min] + ", Continent: " + continent[min] + ", Stat: " + population[min]);
        System.out.println("Average: " + ave);
        System.out.println("---------------------------------\n");
    }
    
    /*
     * Input: String[], String[], int[], int
     * Output: None
     * Description: This method is given 2 String arrays, an int array, and
     *              an integer value as input, and returns nothing.  It simply
     *              finds the highest value in the snp array by using the findMax()
     *              method, the lowest value that isn't 0 in the gnp array by using
     *              the findMin() method, and computes the average value in the gnp
     *              array (not including 0 values) using the findAve() method.
     *              It then prints out all this information to the console.
     * Author: Matthew Peter
     * Date/Time: 4/11/16 2:01p
     */
    public static void showGnpStats(String[] name, String[] continent, int[] gnp, int n) {
        // Find the maximum, minimum, and average value in the gnp array
        int max = findMax(gnp, n);
        int min = findMin(gnp, n);
        double ave = findAve(gnp, n);
        
        // Print out the GNP Stats
        System.out.println("\n---------------------------------");
        System.out.println("GNP Stats:");
        System.out.println("Max: Country: " + name[max] + ", Continent: " + continent[max] + ", Stat: " + gnp[max]);
        System.out.println("Min: Country: " + name[min] + ", Continent: " + continent[min] + ", Stat: " + gnp[min]);
        System.out.println("Average: " + ave);
        System.out.println("---------------------------------\n");
    }
    
    /*
     * Input: String[], String[], long[], int[], int
     * Output: None
     * Description: This method is given 2 String arrays, a long array, an int array, 
     *              and an integer value as input, and returns nothing.  It starts off
     *              by creating a new array named populationDensity that is the same size
     *              as all of the other arrays.  It then figures out the population density
     *              for all the countries using the population and landArea arrays, marking
     *              values in the populationDensity array as 0.0 if either the population or
     *              land area value is 0.  After figuring out the population density for all the
     *              countries that have one, it simply finds the highest value in the
     *              populationDensity array by using the findMax() method, the lowest value
     *              that isn't 0 in the populationDensity array by using the findMin() method,
     *              and computes the average value in the populationDensity array (not
     *              including 0 values) using the findAve() method.  It then prints out
     *              all this information to the console.
     * Author: Matthew Peter
     * Date/Time: 4/11/16 2:07p
     */
    public static void showPopDensityStats(String[] name, String[] continent, long[] population, int[] landArea, int n) {
        // Declare and Instantiate a double array with n values
        double[] populationDensity = new double[n];
        
        // Find and format the population density for all the countries (setting the end value to 0.0 if either value is already 0)
        for (int i = 0; i < n; i++) {
            if (landArea[i] == 0.0 || population[i] == 0) {
                populationDensity[i] = 0.0;
            } else {
                populationDensity[i] = (double)population[i] / landArea[i];
                populationDensity[i] = Double.parseDouble(OneDecimalPlace.format(populationDensity[i]));
            }
        }
        
        // Find the maximum, minimum, and average value in the newly created populationDensity array
        int max = findMax(populationDensity, n);
        int min = findMin(populationDensity, n);
        double ave = findAve(populationDensity, n);
        
        // Print out the Population Density Stats
        System.out.println("\n---------------------------------");
        System.out.println("Population Density Stats:");
        System.out.println("Max: Country: " + name[max] + ", Continent: " + continent[max] + ", Stat: " + populationDensity[max]);
        System.out.println("Min: Country: " + name[min] + ", Continent: " + continent[min] + ", Stat: " + populationDensity[min]);
        System.out.println("Average: " + ave);
        System.out.println("---------------------------------\n");
    }
    
    /*
     * Input: String[], String[], int[], long[], int
     * Output: None
     * Description: This method is given 2 String arrays, an int array, a long array, 
     *              and an integer value as input, and returns nothing.  It starts off
     *              by creating a new array named gnpPerCapita that is the same size
     *              as all of the other arrays.  It then figures out the GNP per Capita
     *              for all the countries using the gnp and population arrays, marking
     *              values in the gnpPerCapita array as 0.0 if either the gnp or
     *              population value is 0.  After figuring out the GNP per Capita for all the
     *              countries that have one, it simply finds the highest value in the
     *              gnpPerCapita array by using the findMax() method, the lowest value
     *              that isn't 0 in the gnpPerCapita array by using the findMin() method,
     *              and computes the average value in the gnpPerCapita array (not including
     *              0 values) using the findAve() method.  It then prints out all this
     *              information to the console.
     * Author: Matthew Peter
     * Date/Time: 4/11/16 2:11p
     */
    public static void showGnpPerCapitaStats(String[] name, String[] continent, int[] gnp, long[] population, int n) {
        // Declare and Instantiate a double array with n values
        double[] gnpPerCapita = new double[n];
        
        // Find and format the GNP per Capita for all the countries (setting the end value to 0.0 if either value is already 0)
        for (int i = 0; i < n; i++) {
            if (gnp[i] == 0.0 || population[i] == 0) {
                gnpPerCapita[i] = 0.0;
            } else {
                gnpPerCapita[i] = (double)gnp[i] / population[i];
                //gnpPerCapita[i] = Double.parseDouble(OneDecimalPlace.format(gnpPerCapita[i]));
            }
        }
        
        // Find the maximum, minimum, and average value in the newly created gnpPerCapita array
        int max = findMax(gnpPerCapita, n);
        int min = findMin(gnpPerCapita, n);
        double ave = findAve(gnpPerCapita, n);
        
        // Print out the GNP per Capita Stats
        System.out.println("\n---------------------------------");
        System.out.println("GNP per Capita Stats:");
        System.out.println("Max: Country: " + name[max] + ", Continent: " + continent[max] + ", Stat: " + gnpPerCapita[max]);
        System.out.println("Min: Country: " + name[min] + ", Continent: " + continent[min] + ", Stat: " + gnpPerCapita[min]);
        System.out.println("Average: " + ave);
        System.out.println("---------------------------------\n");
    }
    
    /*
     * Input: String[], String[], int[], long[], double[], int[], int
     * Output: None
     * Description: This method is given all 6 arrays, has well as an int
     *              value that tells how many values there are in all of the
     *              arrays.  It starts of by declaring and instantiating a
     *              PrintWriter object that will be used to print to the file
     *              "Log.txt".  It also declares and instantiates an integer
     *              array that will used to be store the length of the longest
     *              value in each of the arrays (this will be used to align all
     *              of the values on the text document.  Next, a for loop is used
     *              to go through all of the data in each of the arrays and find
     *              the longest value in each of them.  Finally, all of the data
     *              is printed out on a text document with all of it aligned correctly,
     *              and commas placed where they are needed.
     * Author: Matthew Peter
     * Date/Time: 4/11/16 2:16p
     */
    public static void doReport(String[] name, String[] continent, int[] landArea,
                                long[] population, double[] lifeExpectancy, int[] gnp, int n) throws IOException {
        // Declarea and Instantiate a PrintWriter object and an integer array
        PrintWriter pw = new PrintWriter("Log.txt");    // Will print to file called "Log.txt"
        int[] maxLengths = {0, 0, 0, 0, 0, 0};          // Will be used to align the data into columns
        
        // Go through all of the data in each of the categories and find the value with the greatest length (figuring in commas as well)
        for (int i = 0; i < n; i++) {
            if (name[i].length() > maxLengths[0])
                maxLengths[0] = name[i].length();
            if (continent[i].length() > maxLengths[1])
                maxLengths[1] = continent[i].length();
            if (((int)Math.log10((double)landArea[i])) + ((int)((Math.log10((double)landArea[i])) / 3.0)) > maxLengths[2])
                maxLengths[2] = ((int)Math.log10((double)landArea[i])) + ((int)((Math.log10((double)landArea[i])) / 3.0));
            if (((int)Math.log10((double)population[i])) + ((int)((Math.log10((double)population[i])) / 3.0)) > maxLengths[3])
                maxLengths[3] = ((int)Math.log10((double)population[i])) + ((int)((Math.log10((double)population[i])) / 3.0));
            if (((int)Math.log10(lifeExpectancy[i])) > maxLengths[4])
                maxLengths[4] = ((int)Math.log10(lifeExpectancy[i]));
            if (((int)Math.log10((double)gnp[i])) + ((int)((Math.log10((double)gnp[i])) / 3.0)) > maxLengths[5])
                maxLengths[5] = ((int)Math.log10((double)gnp[i])) + ((int)((Math.log10((double)gnp[i])) / 3.0));
        }
        
        // Print out a heading for the data to the "Log.txt" file
        pw.print(" NAME");
        for (int s = 0; s < maxLengths[0] + 5; s++)
                pw.print(" ");
        pw.print("CONTINENT");
        for (int s = 0; s < maxLengths[1] - 3; s++)
                pw.print(" ");
        pw.print("LAND AREA");
        for (int s = 0; s < maxLengths[2] + 2; s++)
                pw.print(" ");
        pw.print("POPULATION");
        for (int s = 0; s < maxLengths[3] - 6; s++)
                pw.print(" ");
        pw.print("LIFE EXPECT.");
        for (int s = 0; s < maxLengths[4] + 6; s++)
                pw.print(" ");
        pw.println("GNP");
        for (int s = 0; s < (maxLengths[0] + maxLengths[1] + maxLengths[2]
                                           + maxLengths[3] + maxLengths[4] + maxLengths[5] + 47); s++)
                pw.print("-");
        pw.println();
        
        // Print out all of the data to the "Log.txt" file
        //  String values are Left-justified, while integer/decimal values are Right-justfied
        for (int i = 0; i < n; i++) {
            
            // Print out the country's name
            pw.print(name[i]);
            for (int s = 0; s < maxLengths[0] - name[i].length() + 8; s++)
                pw.print(" ");
            
            // Print out the continent of the country
            pw.print(continent[i]);
            for (int s = 0; s < maxLengths[1] - continent[i].length() + 8; s++)
                pw.print(" ");
            
            // Print out the land area of the country
            for (int s = 0; s < maxLengths[2] - (((int)Math.log10((double)landArea[i]))
                                    + ((int)((Math.log10((double)landArea[i])) / 3.0))); s++)
                pw.print(" ");
            pw.print(Commas.format(landArea[i]));
            for (int s = 0; s < 8; s++)
                pw.print(" ");
            
            // Print out the population of the country
            if (population[i] > 0) {
                for (int s = 0; s < maxLengths[3] - (((int)Math.log10((double)population[i]))
                                        + ((int)((Math.log10((double)population[i])) / 3.0))); s++)
                    pw.print(" ");
            } else {
                for (int s = 0; s < maxLengths[3]; s++)
                    pw.print(" ");
            }
            pw.print(Commas.format(population[i]));
            for (int s = 0; s < 8; s++)
                pw.print(" ");
            
            // Print out the life expectancy of the country
            if (lifeExpectancy[i] > 0.0) {
                for (int s = 0; s < maxLengths[4] - ((int)Math.log10(lifeExpectancy[i])); s++)
                    pw.print(" ");
            } else {
                for (int s = 0; s < maxLengths[4]; s++)
                    pw.print(" ");
            }
            pw.print(lifeExpectancy[i]);
            for (int s = 0; s < 8; s++)
                pw.print(" ");
            
            // Print out the GNP of the country
            if (gnp[i] > 0) {
                for (int s = 0; s < maxLengths[5] - (((int)Math.log10((double)gnp[i]))
                                        + ((int)((Math.log10((double)gnp[i])) / 3.0))); s++)
                    pw.print(" ");
            } else {
                for (int s = 0; s < maxLengths[5]; s++)
                    pw.print(" ");
            }
            pw.println(Commas.format(gnp[i]));
        }
        
        // Close the PrintWriter
        pw.close();
    }
    
    /*
     * Input: double[], int
     * Output: int
     * Description: This method is given a double array, and an int value.
     *              It simply goes through all of the values in the double
     *              array that is given, and returns the position of the
     *              highest value in the array.
     * Author: Matthew Peter
     * Date/Time: 4/11/16 2:18p
     */
    private static int findMax(double[] arr, int n) {
        int position = -1;
        double max = 0.0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
                position = i;
            }
        }
        
        return position;
    }
    
    /*
     * Input: double[], int
     * Output: int
     * Description: This method is given a double array, and an int value.
     *              It simply goes through all of the values in the double
     *              array that is given, and returns the position of the
     *              lowest value in the array that isn't 0.0.
     * Author: Matthew Peter
     * Date/Time: 4/11/16 2:18p
     */
    private static int findMin(double[] arr, int n) {
        int position = -1;
        double min = 1000000000.0;
        for (int i = 0; i < n; i++) {
            if (arr[i] < min && arr[i] != 0.0) {
                min = arr[i];
                position = i;
            }
        }
        
        return position;
    }
    
    /*
     * Input: double[], int
     * Output: double
     * Description: This method is given a double array, and an int value.
     *              It simply goes through and sums up all of the values
     *              in the array while keeping track of how many of those values
     *              aren't 0.0.  Once all of the values have been checked, the
     *              sum is divided by that number of nonzero values, and the
     *              result is rounded to one decimal place and returned.
     * Author: Matthew Peter
     * Date/Time: 4/11/16 2:20p
     */
    private static double findAve(double[] arr, int n) {
        double average;
        double sum = 0.0;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (arr[i] != 0.0)
                count++;
        }
        average = (double)sum / count;
        average = Double.parseDouble(OneDecimalPlace.format(average));
        
        return average;
    }
    
    /*
     * Input: int[], String[], String, int
     * Output: int
     * Description: This method is given an integer array, a String array,
     *              a String value, and an int value. It goes through all the
     *              values in the String array, making sure that its value
     *              equals the condition String value that is passed, and then
     *              figures out which of these values in the String array has
     *              the highest corresponding value in the integer array.  It then
     *              returns the position of this value.
     * Author: Matthew Peter
     * Date/Time: 4/11/16 2:24p
     */
    private static int findMax(int[] arr1, String[] arr2, String condition, int n) {
        int position = -1;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (arr2[i].toUpperCase().equals(condition)) {
                if (arr1[i] > max) {
                    max = arr1[i];
                    position = i;
                }
            }
        }
        
        return position;
    }
    
    /*
     * Input: int[], String[], String, int
     * Output: int
     * Description: This method is given an integer array, a String array,
     *              a String value, and an int value. It goes through all the
     *              values in the String array, making sure that its value
     *              equals the condition String value that is passed, and then
     *              figures out which of these values in the String array has
     *              the lowest corresponding value in the integer array that isn't
     *              0.  It then returns the position of this value.
     * Author: Matthew Peter
     * Date/Time: 4/11/16 2:25p
     */
    private static int findMin(int[] arr1, String[] arr2, String condition, int n) {
        int position = -1;
        int min = 1000000000;
        for (int i = 0; i < n; i++) {
            if (arr2[i].toUpperCase().equals(condition)) {
                if (arr1[i] < min && arr1[i] != 0) {
                    min = arr1[i];
                    position = i;
                }
            }
        }
        
        return position;
    }
    
    /*
     * Input: int[], String[], String, int
     * Output: double
     * Description: This method is given an integer array, a String array,
     *              a String value, and an int value. It goes through all the
     *              values in the String array, making sure that its value
     *              equals the condition String value that is passed, and then
     *              sums the corresponding values in the integer array, as long
     *              as the value isn't 0.  It then figures out the average of
     *              all of these int values by dividing the sum by the number
     *              of positive values there were (which is kept track of by the
     *              count variable.  This average value is then returned after
     *              it has been rounded to one decimal place.
     * Author: Matthew Peter
     * Date/Time: 4/11/16 2:27p
     */
    private static double findAve(int[] arr1, String[] arr2, String condition, int n) {
        double average;
        int sum = 0;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (arr2[i].toUpperCase().equals(condition)) {
                sum += arr1[i];
                if (arr1[i] != 0)
                    count++;
            }
        }
        
        average = (double)sum / count;
        average = Double.parseDouble(OneDecimalPlace.format(average));
        
        return average;
    }
    
    /*
     * Input: long[], int
     * Output: int
     * Description: This method is given a long array, and an int value.
     *              It simply goes through all of the values in the long
     *              array that is given, and returns the position of the
     *              highest value in the array.
     * Author: Matthew Peter
     * Date/Time: 4/11/16 2:28p
     */
    private static int findMax(long[] arr, int n) {
        int position = -1;
        long max = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
                position = i;
            }
        }
        
        return position;
    }
    
    /*
     * Input: long[], int
     * Output: int
     * Description: This method is given a long array, and an int value.
     *              It simply goes through all of the values in the long
     *              array that is given, and returns the position of the
     *              lowest value in the array that isn't 0.
     * Author: Matthew Peter
     * Date/Time: 4/11/16 2:29p
     */
    private static int findMin(long[] arr, int n) {
        int position = -1;
        long min = 1000000000;
        for (int i = 0; i < n; i++) {
            if (arr[i] < min && arr[i] != 0) {
                min = arr[i];
                position = i;
            }
        }
        
        return position;
    }
    
    /*
     * Input: long[], int
     * Output: double
     * Description: This method is given a long array, and an int value.
     *              It simply goes through and sums up all of the values
     *              in the array while keeping track of how many of those values
     *              aren't 0.  Once all of the values have been checked, the
     *              sum is divided by that number of nonzero values, and the
     *              result is rounded to one decimal place and returned.
     * Author: Matthew Peter
     * Date/Time: 4/11/16 2:30p
     */
    private static double findAve(long[] arr, int n) {
        double average;
        long sum = 0;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (arr[i] != 0)
                count++;
        }
        
        average = (double)sum / count;
        average = Double.parseDouble(OneDecimalPlace.format(average));
        
        return average;
    }
    
    /*
     * Input: int[], int
     * Output: int
     * Description: This method is given a integer array, and an int value.
     *              It simply goes through all of the values in the integer
     *              array that is given, and returns the position of the
     *              highest value in the array.
     * Author: Matthew Peter
     * Date/Time: 4/11/16 2:30p
     */
    private static int findMax(int[] arr, int n) {
        int position = -1;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
                position = i;
            }
        }
        
        return position;
    }
    
    /*
     * Input: int[], int
     * Output: int
     * Description: This method is given a integer array, and an int value.
     *              It simply goes through all of the values in the integer
     *              array that is given, and returns the position of the
     *              lowest value in the array that isn't 0.
     * Author: Matthew Peter
     * Date/Time: 4/11/16 2:31p
     */
    private static int findMin(int[] arr, int n) {
        int position = -1;
        int min = 1000000000;
        for (int i = 0; i < n; i++) {
            if (arr[i] < min && arr[i] != 0) {
                min = arr[i];
                position = i;
            }
        }
        
        return position;
    }
    
    /*
     * Input: int[], int
     * Output: double
     * Description: This method is given a integer array, and an int value.
     *              It simply goes through and sums up all of the values
     *              in the array while keeping track of how many of those values
     *              aren't 0.  Once all of the values have been checked, the
     *              sum is divided by that number of nonzero values, and the
     *              result is rounded to one decimal place and returned.
     * Author: Matthew Peter
     * Date/Time: 4/11/16 2:31p
     */
    private static double findAve(int[] arr, int n) {
        double average;
        int sum = 0;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (arr[i] != 0)
                count++;
        }
        
        average = (double)sum / count;
        average = Double.parseDouble(OneDecimalPlace.format(average));
        
        return average;
    }
    
}
