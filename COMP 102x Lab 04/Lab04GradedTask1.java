import comp102x.IO;

public class Lab04GradedTask1
{
   public static void testCase1() {
       Choice choice1 = new Choice(0); // Rock
       Choice choice2 = new Choice(1); // Paper
       int result = choice1.compareWith(choice2); // -1
       IO.outputln("Rock vs Paper (-1): " + result);
   }
   
   public static void testCase2() {
       Choice choice1 = new Choice(1); // Paper
       Choice choice2 = new Choice(2); // Scissors
       int result = choice1.compareWith(choice2); // -1
       IO.outputln("Paper vs Scissors (-1): " + result);
   }
   
   public static void testCase3() {
       Choice choice1 = new Choice(2); // Scissors
       Choice choice2 = new Choice(0); // Rock
       int result = choice1.compareWith(choice2); // -1
       IO.outputln("Scissors vs Rock (-1): " + result);
   }
   
   public static void testCase4() {
       Choice choice1 = new Choice(0);
       Choice choice2 = new Choice(0); // Rock
       int result = choice1.compareWith(choice2); // -1
       IO.outputln("Rock vs Rock (0): " + result);
   }
   
   public static void testCase5() {
       Choice choice1 = new Choice(0); // Rock
       Choice choice2 = new Choice(2); // Scissors
       int result = choice1.compareWith(choice2); // -1
       IO.outputln("Rock vs Scissors (1): " + result);
   }
   
   public static void main() {
       testCase1();
       testCase2();
       testCase3();
       testCase4();
       testCase5();
    }
}
