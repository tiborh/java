public class Scope1 {

    private int c = 1;
    private int a = 2;
    
//     step 3:
//     class c = 5 * 2 = 10
//     a = 3 + 4 = 7
//     b = 4 + 1 = 5
//     output: "One: 7,5,10"
//     return 5
    public int one (int a, int b) {
    
        c = a * 2;
        a = 3 + b;
        b = b + 1;

        System.out.println("One: " + a + "," + b + "," + c);
        return b;
    }

//     step 2: one(5,4)
//     class c = 5
//     local a = 4
//     class a = 5
//     output: "Two: 4,5,5
//     return 4
    public int two (int a, int b) {
    
        c = one (b, a);
        this.a = a + 1;
        System.out.println("Two: " + a + "," + b + "," + c);
        return a;
   }
   
//     step 1: 
//     in s: instance c = 1, instance a = 2
//     local a = 4
//     local b = 5
//     b = s.two(4, 5); (= 4)
//     output: "Main: 5,4,5
    public static void main(String[ ] args) {
    
        Scope1 s = new Scope1();
        int a = 4; 
        int b = 5;

        b = s.two (a, b);
        System.out.println("Main: " + s.a + "," + b + "," + s.c);
   }
}

