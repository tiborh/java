public class arrays {
    private int a[] = new int[4];
    private double b[] = new double[4];
    public void arrays() {}
    public void arrays1() {
        //a[0] = 0; //somehow this one gets initialised
        a[1] = 1;
        a[2] = 2;
        a[3] = 3;
        System.out.println(a[0]);
    }
    public void arrays2() {
        int[] a = {1,2,3,4};
        int[] b = a;
        b[0] = 3;
        b[1] = 2;
        for (int i = 0; i < 4; i++)
            System.out.println(a[i]);
    }
    public void arrays3() {
        int[] a = new int[20];
        if (a[10] == 0)
        System.out.println("zero");
    }
    public void arrays4() {
        int[] a = {4, 3, 2, 1};
        for (int i = 0; i < 4; i++)
            System.out.println("[" + i + "]: " + a[i]);
    }
    public void arrays5() {
        double[] a = {1.5, 2.5, 3.5};
        double avg = 0;
        for (int i = 0; i < a.length; i++)
            avg += a[i];
        avg /= (double)a.length;
        System.out.println(avg);
    }
    public void arrays6() {
        b[0] = 1.5;
        b[1] = 2.5;
        b[2] = 3.2;
        b[3] = 4.1;
    }
    public void badswapper() {
        swap_nums(b[1],b[3]);
    }
    private void swap_nums(double n1, double n2) {
        double temp;
        temp = n1;
        n1 = n2;
        n2 = temp;
    }
    public void array_swapper() {
        array_swap(b, 1, 3);
    }
    private void array_swap(double[] arr, int indx1, int indx2) {
        double temp = arr[indx1];
        arr[indx1] = arr[indx2];
        arr[indx2] = temp;
    }
}
