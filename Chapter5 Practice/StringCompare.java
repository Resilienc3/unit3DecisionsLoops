public class StringCompare
{
    public static void main(String[] args)
    {
        String word1 = "catalog";
        String word2 = "cat";
        
        if(word1.compareTo("aaa") > 0)
        {
            System.out.println("yay");
        }
        if (word1.equals(word2))
        {
            System.out.println("word");
        }
        if (word1.compareTo(word2)<0)
        {
            System.out.println("<");
        }
        if(word1.substring(0,3).equals(word2.substring(0,3)))
        {
            System.out.println("Supstring");
        }
    }
}