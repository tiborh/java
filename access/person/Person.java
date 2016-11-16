package person;

class Person implements Comparable {
    private Wallet w;

    public Person() { w = new Wallet(); }    
    public Person(int amount) { w = new Wallet(amount); }    
    public int getNetWorth() { return w.getAmount(); }
    public boolean isBroke() { return w.getAmount() == 0; }    
    public String toString() { return "worth: " + getNetWorth(); }
    
    public int compareTo(Object other) {
        assert(w != null);
        assert(other != null);
        if (this.getNetWorth() == ((Person) other).getNetWorth())
            return 0;
        else if (this.getNetWorth() < ((Person) other).getNetWorth())
            return -1;
        else if (this.getNetWorth() > ((Person) other).getNetWorth())
            return 1;
        else
            return Integer.MIN_VALUE;
    }
}
