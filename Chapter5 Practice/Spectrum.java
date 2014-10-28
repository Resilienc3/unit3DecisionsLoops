import java.util.Scanner;

/**
 * Write a description of class Spectrum here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spectrum
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Input a wavelength(m): ");
        double wave = s.nextDouble();
        
        if(wave > 10e-1)
        {
            System.out.println("This is a Radio Wave");
        }
        
        else if(wave >= 10e-3)
        {
            System.out.println("This is a Microwave");
        }
        else if(wave >= 7*10e-7)
        {
            System.out.println("This is an Infrared Wave");
        }
        else if(wave >= 4*10e-7)
        {
            System.out.println("This is a Visible Light Wave");
        }
        else if(wave >= 10e-8)
        {
            System.out.println("This is a Ultraviolet Wave");
        }
        else if(wave >= 10e-11)
        {
            System.out.println("This is a X-Ray Wave");
        }
        else if (wave <= 10e-11)
        {
            System.out.println("This is a Gamma Wave");
        }
    }
}
