import comp102x.IO;
/**
 * A bank account has a balance and an owner
 * who can make deposits to and withdrawals
 * from the account
 */
public class bank_account {
    // instance variables - replace the example below with your own
    private double balance = 0.0;
    private String owner = "Joe Doe";

    /**
     * Constructor for objects of class bank_account (initialised with default values)
     */
    public bank_account(){}
    
    /**
     * Constructor for objects of class bank_account
     * @param   initial_balance   the initial balance of the owner
     * @param   name              the name of the owner
     */ 
    public bank_account(double initial_balance, String name) {
        balance = initial_balance;
        owner = name;
    }

    /**
     * Add deposited amount to balance
     * @param   deposited      the deposited amount
     */
    public void deposit(double deposited) {
        balance += deposited;
    }

    /**
     * Add deposited amount to balance
     * @param   withdrawn      the withdrawn amount
     */
    public void withdraw(double withdrawn) {
        balance -= withdrawn;
    }

    /**
     * Return the balance as number
     * @return  the current balance of the account
     */
    public double get_balance() {
        return balance;
    }
    
    /**
     * Return data as a concatenated string
     * @return  the owner and the balance as a string
     */
    public String get_data() {
        return(owner + ": " + get_balance());
    }
}
