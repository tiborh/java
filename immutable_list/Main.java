
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    private static long test_timing(int slength) {
        ImList<Integer> ab = ImList.empty();
        for (int i = 0; i < slength; ++i) {
            ab = ab.cons(i);
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < slength; ++i) {
            ab.size();
            ab.get(i);
        }
        long endTime = System.currentTimeMillis();
        return(endTime - startTime);
    }

    public static void main(String[] argv) {
        ImList<Integer> nil = ImList.empty();   // []
        assert(nil.isEmpty());
        assert(!nil.contains(0));
        System.out.println(nil);
        assert(0 == nil.size());
        ImList<Integer> zero = nil.cons(0);     // [0]
        assert(!zero.isEmpty());
        assert(zero.contains(0));
        assert(0 == zero.get(0));
        System.out.println(zero);
        assert(1 == zero.size());
        ImList<Integer> x = nil.cons(2).cons(1).cons(0);  // [0,1,2]
        assert(3 == x.size());
        assert(x.contains(1));
        assert(2 == x.get(2));
        System.out.println("x == " + x);
        System.out.println(x.first());          // 0
        System.out.println(x.rest());           // [1,2]
        System.out.println(x.rest().first());   // 1
        System.out.println(x.rest().rest());    // [2]
        System.out.println(x.rest().rest().first()); // 2
        System.out.println(x.rest().rest().rest()); // empty
        ImList<Integer> y = x.rest().cons(4);   // [4,1,2]
        System.out.println("y == " + y);
        assert(3 == y.size());
        assert(y.contains(4));
        assert(y.contains(2));
        assert(1 == y.get(1));

        ImList<Integer> z = x.append(y);
        System.out.println("x.append(y) == " + z);
        assert(6 == z.size());
        assert(4 == z.get(3));
        assert(2 == z.get(5));

        ImList<Integer> aa = z.reverse();
        System.out.println("z.reverse() == " + aa);
        assert(6 == aa.size());
        assert(2 == aa.get(0));
        assert(0 == aa.get(5));

        ImList<Object> airports = 
            ImList.empty().cons("SFO").cons("IAD").cons("BOS");
        assert(3 == airports.size());
        assert(airports.contains("SFO"));
        assert(airports.contains("BOS"));
        assert("SFO" == airports.get(2));
        assert("BOS" == airports.get(0));
        System.out.println(airports);
        System.out.println(airports.first());
        System.out.println(airports.rest().rest());

        int num_of_tries = 100;
        int list_size = 2000;
        long sum_of_durs = 0;
        System.out.println("Speed test:");
        for (int i = 0; i < num_of_tries; ++i) {
            sum_of_durs+=test_timing(list_size);
        }
        System.out.println("list size: " + list_size);
        System.out.println("number of runs: " + num_of_tries);
        System.out.println("average execution duration: " + sum_of_durs/num_of_tries + " (milliseconds)");
    }
}

