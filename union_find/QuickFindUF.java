import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class QuickFindUF implements UF
{
    private int[] id;
    private int N;

    public QuickFindUF(int N)
    {
        if (N <= 1)
        {
            System.err.println("At least two elements are needed for uniion.");
            System.exit(1);
        }
        this.N = N;
        id = new int[N];
        reset();
    }

    private void reset()
    {
        for (int i = 0; i < N; i++)
            id[i] = i;
    }
    
    public void resetAll()
    {
        reset();
    }
    
    public void reset(int i)
    {
        id[i] = i;
    }
    
    public int get_id_i(int i)
    {
        return id[i];
    }
    
    public void set_id_i(int i, int val)
    {
        id[i] = val;
    }
    
    public boolean connected(int p, int q)
    { 
        return id[p] == id[q];
    }

    public void union(int p, int q)
    {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++)
            if (id[i] == pid)
                id[i] = qid;
    }
    
    public void print_array()
    {
        for(int an_item : id)
            System.out.print(an_item + " ");
        System.out.println();
    }

    public int find(int p)
    {
        for (int i = 0; i < id.length; i++)
            if (id[i] == p)
            {
                return i; 
            }
        return -1;
    }
    
    public int count()
    {
        return N;
    }
    
    public static void main(String[] args)
    {
        int N;
        QuickFindUF uf;
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Number of points: ");
            String input = br.readLine();
            N = Integer.parseInt(input);
            System.out.println(N);
            uf = new QuickFindUF(N);
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