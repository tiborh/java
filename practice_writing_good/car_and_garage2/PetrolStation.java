package car_and_garage2;

import fueltank.FuelTank;
import math.MinMaxRand;

/**
 * Petrol Station has an infinity capacity of fuel
 * when it is created fix the price of fuel
 * 
 * @author UC3M MOOC Team
 * @since 04-2016
 * 
 */
public class PetrolStation
{
    /** price of the petrol per litre */
    double price;
    /** size of the increments in litres used to fill the tank */
    double fuelQuantum;

    /** 
     * Petrol Station constructor
     * 
     * @param min minimum price (in Euro)
     * @param max maximum price (in Euro)
     * @param fuelQuantum how much to increment fuel in tank
     *
     * Precondition  min > 0.0 and max > 0.0 and min < max and fuelQuantum > 0.0
     * Postcondition min < price < max 
     * Postcondition price > 0.0
     */
    PetrolStation(double min, double max, double fuelQuantum)
    {
        MinMaxRand mmr = new MinMaxRand(min,max);
        price = mmr.getVal();
        System.err.println("Price of fuel: " + price);
        this.fuelQuantum = fuelQuantum;
    }

    /**
     * Return the price of the fuel quantum
     */
    public double getPrice() { return price; }

    private double getFuelQuantum() { return fuelQuantum; }

    /**
     * amountFuelCustomerCanBuy returns the amount of fuel the Customer can buy with "euros" euros 
     * @param amountEuros: the amount of euros the customer can spend
     * @return the amount of fuel the customer can buy
     * 
     * Precondition  amountEuros > 0
     * Postcondition returnValue >= 0
     */
    private double amountFuelCustomerCanBuy(double amountEuros){ return amountEuros / price; }

    /**
     * cost returns the cost of "liters" euros of petrol 
     * @param liters: the amount of liters to compute its cost
     * @return the cost of "liters" liters of petrol in this petrol station
     * 
     * Precondition  liters > 0
     * Postcondition returnValue >= 0
     */
    public double cost(double liters){ return liters * price; }

    /**
     * canAddMoreFuel verifies if the fill's Fuel Tank method is satisfied 
     * @param tank: the reference to the Fuel Tank
     * @return if the fill's Fuel Tank method is satisfied
     * 
     * Precondition  tank != NULL
     * Postcondition returnValue == (fuelQuantum <= tank.getCapacity() - getTankLevel())
     */
    private boolean canAddMoreFuel(FuelTank tank)
    {
        return (tank.getTankLevel() + fuelQuantum) <= tank.getTankMax();
    }

    /**
     * howMuchCostFillTank
     * @param car: the car to fill up and give the price for it
     * @return the amount of money necessary to fill the tank
     */
    public double howMuchCostFillTank(Car car)
    {
        FuelTank tank           = car.getTank();
        double litersNeeded     = tank.getTankMax() - tank.getTankLevel();
        return cost(litersNeeded);
    }

    /**
     * fillEuros the customer can buy "amountEuros" euros of fuel
     * the car's tank is filled to its maximum capacity
     * @param car: reference to the customer's car's tank
     * @param amountEuros: amount of money the customer is willing to spend
     * @return the amount of euros that the Customer did not spend
     * 
     * Precondition tank != NULL
     * Postcondition tankLevel >= initial tankLevel
     */
    public double fillEuros(Car car, double amountEuros)
    {
        FuelTank tank           = car.getTank();
        double maxAmountFuel    = amountFuelCustomerCanBuy(amountEuros);      // maximum amount of fuel the customer can buy
        System.err.println("amount to spend: " + amountEuros);
        System.err.println("amount of fuel it can buy: " + maxAmountFuel);
        double amountFilled	    = 0.0;

        for(int i = 0; i < (int) maxAmountFuel; i++)
        {
            if (canAddMoreFuel(tank))
            {
                tank.fill(fuelQuantum);
                amountFilled = amountFilled + fuelQuantum;
            } else
            {
                break;
            }
        }

        return amountEuros - cost(amountFilled);
    }

}