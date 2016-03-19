import java.util.List;
import java.util.LinkedList;
/**
 * BasicSensor extended with memory
 * 
 * @author University of Madrid
 * @version 0.01
 */
class MemorySensor extends BasicSensor{
    private int memoryPositions;
    private LinkedList<Double> memory;
    
    public MemorySensor(double value, int memoryPositions)
    {
        super(value);
        this.memoryPositions = memoryPositions;
        memory = new LinkedList<Double>();
    } 
    
    public void addValue(double newValue)
    {
        Double temp = super.getValue();
        memory.add(temp);
        super.setValue(newValue);
        if (memory.size() > memoryPositions)
            memory.pop();
    }
        
    public Double[] getOldValues()
    {
        Double[] out = new Double[memoryPositions];
        return memory.toArray(out);
    }
}
