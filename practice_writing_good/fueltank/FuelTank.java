package fueltank;

/**
 * FuelTank class
 * 
 * @author UC3M MOOC Team
 * @since 2016-04
 * 
 */
public class FuelTank
{

    private double tankMax;
    private double tankLevel;
    private double initialLevel;

    /*
     * FuelTank constructor of the class
     * 
     * @param tankMax   the capacity of the tank
     * @param tankLevel the amount of fuel in the tank 
     */
    FuelTank(double tankMax, double tankLevel)
    {
        this.tankMax   = tankMax;
        this.tankLevel = tankLevel;
        this.initialLevel = tankLevel;
    }

    protected void resetLevel() { tankLevel = initialLevel; }
    
    /*
     * Return the amount of fuel in the tank
     * 
     */
    public double getTankLevel() { return tankLevel; }

    /*
     * Return the capacity of the tank
     * 
     */
    public double getTankMax(){ return tankMax; }

    /*
     * Return true if tank level is empty, 
     * otherwise false.
     */
    public boolean empty(){ return tankLevel == 0; }

    /*
     * Return true if tank level is full, 
     * otherwise false.
     */
    public boolean full(){ return tankLevel == tankMax; }

    /*
     * Add fuel to the tank
     *
     * @param amount amount of fuel to add
     * 
     * Precondition: amount > 0.0
     * Precondition: amount<=getTankMax()-getTankLevel()
     * Postcondition: not empty()
     */
    public void fill(double amount){ tankLevel = tankLevel + amount; } 
    
    /*
     * Spend fuel to the tank
     *
     * @param amount amount of fuel to spend
     */
    public void consume(double amount){ tankLevel = tankLevel - amount; }
}