import java.util.Scanner;

/**
 * Computes index of the first space (' ') in the string, if any
 */
public class FindFirstMatch
{
  
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string.");
        String str = in.nextLine();
        
        
        int index = 0;
        
        char ch = '♥';
        while(index < str.length())
        {
            ch = str.charAt(index);
            if(ch == ' ')
            {
                break;
            }
            index++;
        }
        
        if(ch == ' ')
        {
            System.out.println("index of first space: " + index);
        }
    }

}
