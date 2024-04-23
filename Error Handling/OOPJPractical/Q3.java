import java.util.concurrent.ExecutionException;

class userNameNotFound extends Exception{
    public userNameNotFound(String message){
        super(message);
    }
}

class passwordNotFound extends Exception{
    public passwordNotFound(String message){
        super(message);
    }
}

public class Q3 {
    static String[] username=new String[10];
    static String[] password=new String[10];
    static String usernameI;
    static String passwordI;
    static boolean usernameFound=false;
    static boolean passwordFound=false;


    public static void main(String[] args){
        usernameI=args[0];
        passwordI=args[1];
        try{
            for(int i=0;i<password.length;i++){
                if(password[i]==passwordI){
                    passwordFound=true;
                    break;
                }
            }
            for(int j=0;j<username.length;j++){
                if(usernameI==username[j]){
                    usernameFound=true;
                    break;
                }
            }
            if(!usernameFound){
                throw new userNameNotFound("Username Not found");
            }
            if(!passwordFound){
                throw new passwordNotFound("Password Not Found");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }    
}
