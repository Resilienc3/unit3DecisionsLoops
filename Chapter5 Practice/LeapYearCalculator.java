import java.util.Scanner;

/**
 * Write a description of class LeapYearCalculator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LeapYearCalculator
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Input a year (AD only): ");
        int year = s.nextInt();
        int yearMod4 = year%4;
        int yearMod400 = year%400;
        int yearMod100 = year%100;
       
        if (yearMod4 == 0 && ((yearMod400 == 0) || ((yearMod100 != 0) || year < 1582)))
        {
            System.out.println("This is a leap year");
        }
        else
        {
            System.out.println("This is not a leap year");
        }
    }
}
