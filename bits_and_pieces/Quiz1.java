import comp102x.IO;
  
public class Quiz1 {
        private int x;

        public Quiz1(int x) {
            // x = x would result in 0 "zero"  in the instance, local variable
            System.out.println("instance variable: " + this.x);
            this.x = x; // changes the ??? variable
        }

        public static void main(String[] args) {    
            Quiz1 q1 = new Quiz1(10);
            IO.outputln(q1.x);
            Quiz1 q2 = new Quiz1(5);
        }
}