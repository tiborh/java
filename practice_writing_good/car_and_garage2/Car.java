package car_and_garage2;

import fueltank.FuelTank;

public class Car
{
    /** tank of the car with attribs of capacity and current level */
    FuelTank tank;
    /** litre/km */
    double consumption;	
  
    /**
     * Constructor for Car
     * 
     * @param tank the tank of the car of type FuelTank
     * @param consumption the fuel consumption of the car (litre/km)
     */
    Car(FuelTank tank, double consumption)
    {
        this.tank=tank; 
        this.consumption=consumption;
    }

    /**
     * In order to give access to fueltank accessor methods but not access
     * to change the values of the tank of the car
     * @return a copy of the fuel tank
     */
    public FuelTank getTank() { return tank.clone(); }
    
    /**
     * How many kms the car can run on a given amount of fuel?
     * @param amountFuel the amount of fuel available
     * @return number of kilometers
     */
    public double amountKilometers (double amountFuel)
    {
        return amountFuel / consumption;
    }	

    /**
     * How much fuel is needed for the car to run a given number of kms?
     * @param km number of kilometres to run
     * @return litres of fuel needed
     */
    public double amountFuel (double km)
    {
        return km * consumption;
    }		
 
    /**
     * how much fuel do you need to fill into the tank of the car
     * to travel a given number of kilometres, 
     * 
     * <li>if the tank capacity is smaller than the fuel needed, 
     *   the amount is given to fill it up full
     * <li>if the tank has more than needed, zero is returned
     * 
     * @param km number of kilometres to travel
     * @return the number of litres to fill the tank up with
     */
    public double travel (double km)
    {
        double amountFuelNeeded=amountFuel(km);	
        double amountFuelAvailable=tank.getTankLevel();
        if (amountFuelNeeded > amountFuelAvailable)
        { 
            tank.consume(amountFuelAvailable);
            return amountKilometers(amountFuelNeeded - amountFuelAvailable);
        } else 
        {
            tank.consume(amountFuelNeeded); 
            return 0.0;
        }
    }	
}
