import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class WeightedQuickUnionOptimisedUF extends WeightedQuickUnionUF implements UF
{
    public WeightedQuickUnionOptimisedUF (int N)
    {
        super(N);
    }
        
    public int root(int i)
    {
        while (i != get_id_i(i))
        {
            set_id_i(i,get_id_i(i));
            i = get_id_i(i);
        }
        return i;
    }
        
    public static void main(String[] args)
    {
        int N;
        WeightedQuickUnionUF uf;
        try
        {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		System.out.print("Number of points: ");
    		String input = br.readLine();
    		N = Integer.parseInt(input);
    		System.out.println(N);
    		uf = new WeightedQuickUnionUF(N);
    		System.out.println("Pairs to connect:");
    		while((input=br.readLine())!=null && !input.equals(""))
    		{
    			//System.out.println(input);
    			String[] pair = input.split("\\s+");
    			int p = Integer.parseInt(pair[0]);
    			int q = Integer.parseInt(pair[1]);
    			if (!uf.connected(p, q))
                {
                    uf.union(p, q);
                    System.out.println(p + " " + q);
                }
            }
            uf.print_array();
        }
        catch(IOException io)
        {
                io.printStackTrace();
        }        
    }
}

