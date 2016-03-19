public class Circle extends Figure{
    private double radius;
    private final double PI=Math.PI;
    
    public Circle (double r, String name){
       	super(name);
       	radius=r;
    }
    
    public String toString(){
        return "I'm a circle of radius "+radius;    	
    }
    
    public double calculateArea(){
       	return PI*radius*radius;
    }
    
    public double calculatePerimeter(){
       	return 2*PI*radius;
    }
}
