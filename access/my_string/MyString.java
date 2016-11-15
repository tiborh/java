package my_string;

/** MyString represents an immutable sequence of characters. */
public class MyString {
    private final char[] internal;

    public MyString() {
        internal = null;
    }    
    
    public MyString(char[] starter) {
        internal = new char[starter.length];
        for(int i = 0; i < starter.length; ++i)
            internal[i] = starter[i];
    }
    
    //////////////////// Example of a creator operation ///////////////    
    /**
     * Constructor with boolean
     * 
     * @param b a boolean value to be represented as string
     */ 
    public MyString(boolean b) {
        if (b == true)
            internal = new char[]{'t','r','u','e'};
        else
            internal = new char[]{'f','a','l','s','e'};
    }
    

    /** @param b a boolean value
     *  @return string representation of b, either "true" or "false" 
        */
    public static MyString valueOf(boolean b) {
        return new MyString(b);
    }
     
    //////////////////// Examples of observer operations ///////////////
    /** @return number of characters in this string */
    public int length() {
        return internal.length;
    }

    /** @param i character position (requires 0 <= i < string length)
     *  @return character at position i */
    public char charAt(int i) {
        assert(i >= 0);
        assert(i < internal.length);
        return internal[i];
    }

    //////////////////// Example of a producer operation ///////////////    
    /** Get the substring between start (inclusive) and end (exclusive).
     *  @param start starting index
     *  @param end ending index.  Requires 0 <= start <= end <= string length.
     *  @return string consisting of charAt(start)...charAt(end-1) */
    public MyString substring(int start, int end) {
        assert(start>=0);
        assert(end<=internal.length);
        assert(end > start);
        char[] outArray = new char[end - start];
        for (int i = start; i < end; ++i)
            outArray[i-start] = internal[i];
        return new MyString(outArray);
    }
    
    public String toString() {
        return new String(internal);
    }
}
