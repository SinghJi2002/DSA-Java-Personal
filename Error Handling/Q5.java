class checkArgument extends Exception{
    public checkArgument(){
        super("Inadequate Arguments");
    }
} 

public class Q5 {
    public static void main(String[] args) {
        try{
            if(args.length<4){
                throw new checkArgument();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
