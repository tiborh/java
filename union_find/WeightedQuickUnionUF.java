import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class WeightedQuickUnionUF extends QuickUnionUF implements UF
{
    private int[] sz;
    public WeightedQuickUnionUF(int N)
    {
        super(N);
        sz = new int[N];
    }
    
    public void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);
        if (i == j)
            return;
            
        if (sz[i] < sz[j])
        { 
            set_id_i(i,j); 
            sz[j] += sz[i];
        } else
        { 
            set_id_i(j,i);
            sz[i] += sz[j];
        }
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
