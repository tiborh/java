class improvedMemorySensor extends BasicSensor{
    private int memoryPositions;
    private double memory[];
    
    public improvedMemorySensor(double value, int memoryPositions){
        super(value);
        this.memoryPositions = memoryPositions;
        memory = new double[memoryPositions];
        memory[0] = value;
    }
    
    public double[] getOldValues(){
        return memory;
    }

    //The problem lies here: only memory is set, not the value inherited
    public void setValue(double value){
        for(int i = memoryPositions -1 ; i >= 1;i--){
            memory[i] = memory[i-1];
        }
        memory[0] = value;
        super.setValue(value);
    }            
    
    void printAllValues(){
        System.out.print("(");
        for (int i=0; i < memoryPositions-1; i++){
            System.out.print(memory[i]+ ", ");
        }
        System.out.println(memory[memoryPositions-1]+ ")");       
    }
}