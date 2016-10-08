import static java.lang.Math.*;

class Dragon {
    private String firstName = "";
    private String lastName = "";
    private int age = 0;
    
    public Dragon(String f, String l) {
        this(f, l, 0);
    }
    
    public Dragon(String f, String l, int a) {
        firstName = f;
        lastName = l;
        age = a;
    }
    
    public boolean equals(Object other) {
        if(other == null) {
            return false;
        }
        return firstName.equals(((Dragon)other).firstName) && lastName.equals(((Dragon)other).lastName) && age == ((Dragon)other).age;
    }
    
    public int hashCode() {
        return firstName.hashCode() * firstName.hashCode() + lastName.hashCode() + age;
    }
    
    public int firstNameSum() {
        int sum = 0;
        for(int i = 0; i < firstName.length(); i++) {
            sum += (int)firstName.charAt(i);
        }
        return sum;
    }
    
    public double sqrtAge() {
        return sqrt(age);
    }
    
    public String toString() {
        //Grace Hopper (7 years old)
    	return String.format(firstName + ' ' + lastName + " (" + age + " years old)");
    }
    
    public static void main(String[] args) {
        Dragon bob = new Dragon("Bob", "Smith", 6);
        System.out.println(bob.equals(null));
        System.out.println(bob == null);
        System.out.println("Go Dragons!");
        System.out.println("\t" + bob.firstName + " " + bob.lastName + ", who is " + bob.age + " years old," + " is my favorite dragon.");
        Dragon grace = new Dragon("Grace","Hopper",7);
        System.out.println(grace);
    }
}
