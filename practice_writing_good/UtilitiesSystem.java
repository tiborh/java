class UtilitiesSystem{
    public static void main (String[] args){
        foo();
    }
    public static void foo(){
        java.io.File pwd=new java.io.File("user.dir");
        if (pwd.isDirectory()){
            java.io.File [] bar=pwd.listFiles();
            for (int i=0; i<bar.length; i++){
                System.out.println(bar[i].getName());
            }
        }else{
            System.out.println ("Error. The argument is not a directory");
        }
    }
}
