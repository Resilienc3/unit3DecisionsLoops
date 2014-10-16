import java.util.Scanner;
public class CircleOverlap
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);

      System.out.print("Input the radius of the first circle: ");
      double radius1 = in.nextDouble(); 
      System.out.print("Input the x-center of the first circle: ");
      double xcenter1 = in.nextDouble();
      System.out.print("Input the y-center of the first circle: ");
      double ycenter1 = in.nextDouble();
      System.out.print("Input the radius of the second circle: ");
      double radius2 = in.nextDouble(); 
      System.out.print("Input the x-center of the second circle: ");
      double xcenter2 = in.nextDouble();
      System.out.print("Input the y-center of the second circle: ");
      double ycenter2 = in.nextDouble();

      // Your work goes here
      double circle1xreachleft = xcenter1 - radius1;
      double circle1xreachright = xcenter1 + radius1;
      double circle2xreachleft = xcenter2 - radius2;
      double circle2xreachright = xcenter2 + radius2;
      double circle1yreach = ycenter1 + radius1;
      double circle1yreachdown = ycenter1 - radius1;
      double circle2yreach = ycenter2 + radius2;
      double circle2yreachdown = ycenter2 - radius2; 
      if (circle1xreachright> circle2xreachright && circle1xreachleft > circle2xreachleft && circle1yreach > circle2yreach && circle1yreachdown >circle2yreachdown)
      {
          System.out.println("They are mutually contained");

        }
      else if (circle1xreachleft >circle2xreachleft)
      {
          System.out.println("They are overlapping");

        }
     
      else if (circle1xreachright < circle2xreachleft)
      {
          System.out.println("They are disjoint");
        }
   }
}