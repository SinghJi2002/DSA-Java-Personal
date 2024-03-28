public class Q1{
    public static void main(String[] args) {
        int[] arr=new int[4];
        try{
            System.out.println(arr[9]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error found");
        }
    }
}