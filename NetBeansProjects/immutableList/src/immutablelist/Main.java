/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package immutablelist;

/**
 *
 * @author etibhar
 */
public class Main {
    public static void main(String[] argv) {
        ImList<Integer> nil = ImList.empty();   // []
        System.out.println(nil);
        ImList<Integer> zero = nil.cons(0);     // [0]
        System.out.println(zero);
        ImList<Integer> x = nil.cons(2).cons(1).cons(0);  // [0,1,2]
        System.out.println(x.first());          // 0
        System.out.println(x.rest());           // [1,2]
        System.out.println(x.rest().first());   // 1
        System.out.println(x.rest().rest());    // [2]
        System.out.println(x.rest().rest().first()); // 2
        System.out.println(x.rest().rest().rest()); // empty
        ImList<Integer> y = x.rest().cons(4);   // [4,1,2]
        System.out.println(y);
        
        ImList<Object> airports = 
                ImList.empty().cons("SFO").cons("IAD").cons("BOS");
        System.out.println(airports);
        System.out.println(airports.first());
        System.out.println(airports.rest().rest());
    }
}
