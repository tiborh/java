public class sort_problem
{
    static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    
    }

    static void sort(int[] array){
        for (int i = 0; i < array.length - 1; i++){
            int index = i;
            for (int k = i + 1; k < array.length; k++){
                if (array[k] < array[index]){
                     index = k;
                }
            }
            swap(array,i,index);
        }
    }
    
    public static void print(int[] sample)
    {
        for (int tmp : sample)
            System.out.print(tmp + ", ");
        System.out.print("\n");
    }
    
    public static void main(String[] args)
    {
        int sample[] = new int[10];
        
        for (int i = 0; i < sample.length; ++i)
            sample[i] = (int)(Math.random()*100);
            
        print(sample);
        
        sort(sample);
        
        print(sample);
    }
}
