public class Sort_array {
    private int[] int_array;
    private int[][] int_array_2d;
    private int[] freq_array;
    private double[] hist_array;
    private int maxval;
    private int minval;
    private int array_length;
    private int row_length; //limitation: java allows unequal columns
    private int max_index;
    private int min_index;

    public Sort_array(){
        minval = 0;
        maxval = 9;
        this.array_length = 10;
        initialiser();
    }
    
    public Sort_array(int array_length, int min_val, int max_val) {
        // fillup array with random numbers
        minval = min_val;
        maxval = max_val;
        this.array_length = array_length;
        initialiser();
    }
    
    public Sort_array(int rows, int cols, int min_val, int max_val) {
        minval = min_val;
        maxval = max_val;
        array_length = rows;
        row_length = cols;
        initialiser2d();
    }
    
    private void initialiser() {
        int_array = random_fill(array_length,minval,maxval+1);
    }
    
    private void initialiser2d() {
        int_array_2d = new int[array_length][row_length];
        for (int i=0; i<array_length; i++)
            int_array_2d[i] = random_fill(row_length,minval,maxval+i); //error: more than max values are also given
        print_2d_array(int_array_2d);
    }
        
    public void analyser() {
        max_index = maxindex(int_array,int_array.length-1);
        min_index = minindex(int_array,int_array.length-1);
        freq_array = frequency(int_array);
        hist_array = histogram(freq_array);        
    }

    private int[] random_fill(int array_length, int min_val, int max_val) {
        int out_array[] = new int[array_length];
        for (int i = 0; i < array_length; i++) {
            out_array[i] = (int)((max_val-min_val) * Math.random() + min_val);
        }
        return out_array;
    }
    
    private int[] frequency(int[] in_array) {
        int out_array[] = new int[maxval-minval+1];
        
        for (int i = 0; i < in_array.length; i++)
            out_array[in_array[i]-minval]++;
        
        return out_array;
    }
    
    private double[] histogram(int[] in_array) {
        double out_array[] = new double[in_array.length];
        
        for (int i = 0; i < out_array.length; i++)
            out_array[i] = 100.0 * in_array[i] / (double)array_length;
        
        return out_array;
    }
    
    private int minindex(int[] in_array, int last_index) {
        int min_index = 0;
        for (int i = 0; i < last_index+1; i++)
            if (in_array[i] < in_array[min_index])
                min_index = i;
        return min_index;
    }
    
    private int maxindex(int[] in_array,int last_index) {
        int max_index = 0;
        for (int i = 0; i < last_index+1; i++)
            if (in_array[i] > in_array[max_index])
                max_index = i;
        return max_index;
    }
    
    private void array_swap(int[] in_array, int indx1, int indx2) {
        int temp = in_array[indx1];
        in_array[indx1] = in_array[indx2];
        in_array[indx2] = temp;
    }
    
    public void selection_sorter() {
        selection_sort(int_array,int_array.length-1);
    }
    
    private void selection_sort(int[] in_array, int last_index) {
        int max_index = maxindex(in_array,last_index);

        array_swap(in_array,max_index,last_index);
            
        if(last_index > 1)
            selection_sort(in_array,last_index-1);
        else
            return;
    }
    
    private void print_array(int[] in_array) {
        for (int i = 0; i < in_array.length; i++)
            System.out.print(in_array[i] + " ");
        System.out.println("");
    }
    
    private void print_2d_array(int[][] in_array) {
        for (int i = 0; i < in_array.length; i++)
            print_array(in_array[i]);
    }
}
