// CLASS:  UserInteraction used by PROJECT:  WorldDataQuerySystem
// AUTHOR:  Matt Peter
// DESCRIPTION:  This class came already completed and simpley contains
//               several methods that are used to ask questions and get
//               responses from the user.  It allows the user to ask for
//               different types of information, which the Query class then
//               finds and prints to the console.
//
//*****************************************************************************
package worlddataquerysystem;

import java.util.Scanner;

public class UserInteraction {
    
        static Scanner keyboard = new Scanner(System.in);
    
        public static void introMessage() {
            System.out.println("WORLD DATA QUERY SYSTEM");
            System.out.println("***********************\n");
        }
        //*********************************************************************
        public static void endingMessage() {
            System.out.println("\n<< EXITING WORLD DATA QUERY SYSTEM >>");
        }
        //*********************************************************************
        public static int mainMenu() {
            
            System.out.println("What data would you like?");
            System.out.println("  1.  data about a particular country");
            System.out.println("  2.  names of countries in a specified continent");
            System.out.println("  3.  stats about life expectancy");
            System.out.println("  4.  stats about land area");
            System.out.println("  5.  stats about population");
            System.out.println("  6.  stats about gnp");
            System.out.println("  7.  stats about population density");
            System.out.println("  8.  stats about gnp per capita");
            System.out.println("OR -1 TO QUIT");
            System.out.print("ENTER OPTION, 1-8 (or -1 to quit):  ");
            
            String userData = keyboard.nextLine();
            int option = Integer.parseInt(userData);
            return option;
        }
        //*********************************************************************
        public static String getCountry()
        {
            System.out.print("Enter country name:  ");
            String userData = keyboard.nextLine();
            return userData.toUpperCase();
        }
        //*********************************************************************
        public static String getContinent()
        {
             System.out.print("Enter continent code:" +
                "\n\t1=Africa, 2=Antarctica, 3=Asia, 4=Europe," +
                "\n\t5=North America, 6=Oceania, 7=South America:  ");
            int continentCode = Integer.parseInt(keyboard.nextLine());
            String continent;
            switch (continentCode)
            {
                case 1:
                    continent = "AFRICA";
                    break;
                case 2:
                    continent = "ANTARCTICA";
                    break;
                case 3:
                    continent = "ASIA";
                    break;
                case 4:
                    continent = "EUROPE";
                    break;
                case 5:
                    continent = "NORTH AMERICA";
                    break;
                case 6:
                    continent = "OCEANIA";
                    break;
                case 7:
                    continent = "SOUTH AMERICA";
                    break;
                default:
                    System.out.println("*** Invalid continent - using default:"
                            + "  Europe");
                    continent = "EUROPE";                   
            }
            return continent;
        }
        //*********************************************************************
        public static String getAllOrContinent()
        {
            System.out.println("Do these stats for ALL countries " +
                   "or a single continent?");
            System.out.print("\tenter 1 for ALL or 2 for a single continent:  ");
            int option = Integer.parseInt(keyboard.nextLine());
            if (option == 2)
                return getContinent();
            else
                return "ALL";
        }
        //*********************************************************************
}
