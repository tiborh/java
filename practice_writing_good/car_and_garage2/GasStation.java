package car_and_garage2;

public class GasStation
{
    /**
     * price is the cost of a liter
     */
    private double price;

    /** 
     * Gas Station constructor
     * @param crudePrice is the current crude price per liter
     * @param fixedCost is the fixed cost plus taxes per liter
     * 
     */
    public GasStation(double crudePrice, double fixedCost)
    {
        price = fixedCost*0.6 + crudePrice*0.4;
    }

    /**
     * Try to fill the required fuel to finish the travel, if
     * the tank has enough capacity. Otherwise, 
     * the tank will be filled up to its capacity.
     *
     * @param car is the car object that has the tank to be filled
     * @param missingKms is the missing kilometers to travel 
     * //Precondition: missingKms > 0
     *
     * @return the money amount to pay 
     */
    public double refuel(Car car, double missingKms)
    {
        double fuelNeeded = car.amountFuel(missingKms);
        double fuelToPay = 0.0;
        if (car.tank.getTankMax() < fuelNeeded)
        {
            fuelToPay = car.tank.fill();
        } else
        {
            fuelToPay = fuelNeeded - car.tank.getTankLevel();
            if (fuelToPay < 0)
                fuelToPay = 0.0;
            else
                car.tank.fill(fuelToPay);
        }
        return fuelToPay * price;
    }

}