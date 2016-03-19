import comp102x.Canvas;

public class Lab04GradedTask2
{
   public static void testCase1() {    
       Canvas canvas = new Canvas(480, 960);
       Choice choice1 = new Choice(0); //Rock
       choice1.draw(canvas, 0, 480, 0); 
   }
   
   public static void testCase2() {    
       Canvas canvas = new Canvas(480, 960);
       Choice choice1 = new Choice(1); //paper
       choice1.draw(canvas, 0, 480, 90); 
   }
   
   public static void testCase3() {    
       Canvas canvas = new Canvas(480, 960);
       Choice choice1 = new Choice(2); //scissors
       choice1.draw(canvas, 0, 480, 270); 
   }
   
   public static void testCase4() {    
       Canvas canvas = new Canvas(480, 960);
       Choice choice1 = new Choice(3); //wrong choice
       choice1.draw(canvas, 20, 480, 180); 
   }
      
   public static void main() {
       testCase1();
       testCase2();
       testCase3();
       testCase4();
    }
}
