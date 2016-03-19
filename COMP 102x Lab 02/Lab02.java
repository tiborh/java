import comp102x.IO;

public class Lab02
{
    
    public static void multiply()
    {
        // Please write your code after this line
        System.out.print("Enter an integer, x: ");
        int input_number_x = IO.inputInteger( );
        System.out.print("Enter an integer, y: ");
        int input_number_y = IO.inputInteger( );
        System.out.println("Answer: " + input_number_x * input_number_y);
        
        
        
        
    }
    
    public static void calculateTriangleArea()
    {
        // Please write your code after this line
        System.out.print("Enter the width of the triangle: ");
        int triangle_width = IO.inputInteger( );
        System.out.print("Enter the height of the triangle: ");
        int triangle_height = IO.inputInteger( );
        System.out.println("The triangle area = " + ((float)triangle_width * triangle_height / 2));
        
        
        
        
    }
    
    public static void solveQuadraticEquation()
    {
        // Please write your code after this line
        System.out.print("Enter a: ");
        int a = IO.inputInteger( );
        System.out.print("Enter b: ");
        int b = IO.inputInteger( );
        System.out.print("Enter c: ");
        int c = IO.inputInteger( );
        System.out.println("First Solution = " + ((-b + Math.sqrt(Math.pow(b,2) - 4*a*c))/(2*a)));
        System.out.println("Second Solution = " + ((-b - Math.sqrt(Math.pow(b,2) - 4*a*c))/(2*a)));
        
        
        
    }
    
    public static void main(String[] args)
    {
        multiply();
        calculateTriangleArea();
        solveQuadraticEquation();
    }
}
