import java.util.Arrays;
/**
 * A test class to test BasicSensor class
 * 
 * @author University of Madrid
 * @version 0.01
 */
class TestSensor{
    public static void testBasicSensor()
    {
        BasicSensor a = new BasicSensor(0.0);
        BasicSensor b = new BasicSensor(10.0);

        System.out.print("("+a.getValue()+", "+b.getValue()+")");
        a.clearValue();
        b.clearValue();
        a.setValue(100.0);
        System.out.println(" ("+a.getValue()+", "+b.getValue()+")");
    }

    public static void testMemorySensor()
    {
        MemorySensor a = new MemorySensor(15.0, 3);
        MemorySensor b = new MemorySensor(10.0, 0);  // behaves like Basic Sensor

        // compatibility with Basic Sensor
        System.out.println("New values("+a.getValue()+", "+b.getValue()+")");
        System.out.println("Memory values: "+Arrays.toString(a.getOldValues())+", "+Arrays.toString(b.getOldValues()));
        a.clearValue();
        b.clearValue();
        a.setValue(100.0);
        System.out.println("After clear and set ("+a.getValue()+", "+b.getValue()+")");
        System.out.println("Memory values: "+Arrays.toString(a.getOldValues())+", "+Arrays.toString(b.getOldValues()));
        a.clearValue();
        
        // new feature:
        Double[] test = {1.1, 1.2, 1.3, 1.4, 1.5};
        System.out.println("looped through with: " + Arrays.toString(test));
        for (Double item : test)
        {
            a.addValue(item);
            b.addValue(item);
        }
        System.out.println("Current values("+a.getValue()+", "+b.getValue()+")");
        System.out.println("Old values: "+Arrays.toString(a.getOldValues())+", "+Arrays.toString(b.getOldValues()));
    }

    
    public static void main(String[] args){
        System.out.println("\nTesting Basic Sensor:\n");
        testBasicSensor();
        System.out.println("\nTesting Memory Sensor:\n");
        testMemorySensor();
    }
}
