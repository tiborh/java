class TestImprovedMemorySensor{
    public static void main(String[] args){
        improvedMemorySensor a = new improvedMemorySensor(15.0,5);
        improvedMemorySensor b = new improvedMemorySensor(10.0,5);
        a.setValue(234.0);
        b.setValue(235.0);
        System.out.println("Actual value of sensor a: "+a.getValue());
        System.out.println("Actual value of sensor b: "+b.getValue());
        System.out.print("Memory of sensor a: ");
        a.printAllValues();
        System.out.print("Memory of sensor b: ");
        b.printAllValues();
   }
}