public class Q2 {
    public static void main(String[] args) {
        int[] arr=new int[5];
        try{
            System.out.println(arr[10]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error Found");
        }finally{
            System.out.println("Final block is being executed");
        }
    }
}
