import java.util.Stack;
public class week10_task1
{
    public static int f(String input) {
  
        Stack<Character> stack = new Stack<Character>();
  
        int n = 0;
        
        for (int i = 0; i < input.length(); i++) {    
            if (input.charAt(i) == 'd')
                stack.push('d');
            else if (input.charAt(i) == 'b') {    
                if (!stack.empty() && stack.pop() == 'd') n++;
            }
        }  
  
        return n;
    }

    public static void main(String[] argv)
    {
        System.out.println(f("bdbdbd"));
        System.out.println(f("dddbbb"));
        System.out.println(f("buddy"));
    }
}
