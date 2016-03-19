import java.util.Arrays;

public class exam_tasks
{
    public static void printHourglass(int size, char symbol) {
        for (int i = size; i >= 1; i-=2)
        {
            for (int j = 0; j < ((i == size) ? 0 : (size - i) / 2); j++)
                System.out.print(" ");
            for (int j = 0; j < i; j++)
                System.out.print("" + symbol);
            for (int j = 0; j < ((i == size) ? 0 : (size - i) / 2); j++)
                System.out.print(" ");
            //System.out.print("|");
            System.out.println();
        }
        for (int i = 3; i <= size; i+=2)
        {
            for (int j = 0; j < ((i == size) ? 0 : (size - i) / 2); j++)
                System.out.print(" ");
            for (int j = 0; j < i; j++)
                System.out.print("" + symbol);
            for (int j = 0; j < ((i == size) ? 0 : (size - i) / 2); j++)
                System.out.print(" ");
            //System.out.print("|");
            System.out.println();
        }
    }
 
    public static String decipher(String cipher) {
        String decipher = "";
        
        if (cipher.equals(decipher))
            return "no cipher";
        if (cipher.length() % 6 != 0)
            return "invalid cipher";
        
        for (int i = 0; i < cipher.length(); i+=6)
        {
            decipher += decipherChar(cipher.substring(i,i+6));
            //System.out.println(decipher);
        }
            
        return decipher;
    }
    
    /**
     * This method decodes a 6-character input String into a single character.
     * The first and second halves of the input String are compared lexicographically.
     * The middle character of the smaller half is then returned.
     * In case of equal halves, a space character is returned.
     * 
     * @param inputStr The 6-character String to be decoded.
     * @return The decoded character.
     */ 
    public static char decipherChar(String inputStr) {
            // implementation not shown here
            if (inputStr.length() != 6) {
                System.out.println("incorrect length, exiting...");
                System.exit(1);
            }
            return inputStr.charAt(inputStr.length() - 1);
    }

    
    public static int sumOfProduct(int[] arr1, int[] arr2, int n)
    {
        if (n == 0)
            return 0;
        else
            return arr1[0] * arr2[0] + sumOfProduct(Arrays.copyOfRange(arr1,1,arr1.length),Arrays.copyOfRange(arr2,1,arr2.length),n-1);
    }
    
    public static void transpose(int[][] arr)
    {
        int[][] temp_arr = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++)
            for(int j = 0; j < arr[i].length; j++)
                temp_arr[i][j] = arr[j][i];
        printArray(temp_arr);
        System.out.println();
        System.arraycopy(temp_arr,0,arr,0,arr.length);
    }

    public static void printArray(int[][] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }

    public static void printArray(int[] arr)
    {
        for(int j = 0; j < arr.length; j++)
            System.out.print(arr[j] + " ");
        System.out.println();
    }

    
    public static void main(String[] argv)
    {
        int[][] test_array = { { 11, 12, 13, 14 },
                               { 21, 22, 23, 24 },
                               { 31, 32, 33, 34 },
                               { 41, 42, 43, 44 } };
    
        //System.out.println(Arrays.deepToString(test_array));
        printArray(test_array);
        System.out.println();
        transpose(test_array);
        //System.out.println(Arrays.deepToString(test_array));
        printArray(test_array);
        
        System.out.println();
        
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {6, 7, 8, 9, 10};
        
        printArray(Arrays.copyOfRange(arr1,1,arr1.length));
        
        System.out.println(sumOfProduct(arr1, arr2, 4));
        
        System.out.println(decipher(""));
        System.out.println(decipher("Alice"));
        System.out.println(decipher("yjqzic"));
        System.out.println(decipher("yjqzicdamnovvvozyrjstfad"));

        System.out.println();
        printHourglass(1, '*');
        System.out.println();
        printHourglass(3, 'A');
        System.out.println();
        printHourglass(7, '?');
        System.out.println();
        printHourglass(5, 'Q');
    }
    
}
