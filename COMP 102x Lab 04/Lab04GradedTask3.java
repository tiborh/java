import comp102x.IO;

public class Lab04GradedTask3
{
   public static void testCase1()
   {    
       Computer computer = new Computer();
       int result;
       for(int i = 0; i < 10; i++) {
           computer.makeChoice();
           result = computer.getChoice().getType(); 
           IO.outputln("Choice #" + i + ": " + result);
        }
   }
}
