package my_string;


/** My_String represents an immutable sequence of characters. */
public interface My_String { 

    // We'll skip this creator operation for now
    /** @param b a boolean value
      *  @return string representation of b, either "true" or "false" */
    public static My_String valueOf(boolean b) {
        return new FastMyString(true);
    }

    /** @return number of characters in this string */
    public int length();

    /** @param i character position (requires 0 <= i < string length)
     *  @return character at position i */
    public char charAt(int i);

    /** Get the substring between start (inclusive) and end (exclusive).
     *  @param start starting index
     *  @param end ending index.  Requires 0 <= start <= end <= string length.
     *  @return string consisting of charAt(start)...charAt(end-1) */
    public My_String substring(int start, int end);
}