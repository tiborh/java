class Wallet {
    private int amount;

    public void loanTo(Wallet that) {
        // put all of this wallet's money into that wallet
        that.amount += this.amount;
        System.out.println("Amount inside loanTo : " + amount);
        amount = 0;
    }

    public int getAmount() { return amount; }
    
    public static void main(String[] args) {
        Wallet w = new Wallet();
        System.out.println("Amount when new: " + w.amount);
        w.amount = 100;
        System.out.println("Amount after value is set: " + w.amount);
        w.loanTo(w);
        System.out.println("Amount after loaning to self: " + w.amount);
    }
}
