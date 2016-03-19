
/**
 * Basic sensor example to Beginner's Java Course
 * 
 * @author University of Madrid
 * @version 0.01
 */
class BasicSensor{
    private double value;

    public BasicSensor(double value){
        this.value = value;
    }

    public void setValue(double value){
        this.value = value;
    }
    
    public double getValue(){
        return value;
    }

    public void clearValue(){
        this.value = 0;
    }
}
