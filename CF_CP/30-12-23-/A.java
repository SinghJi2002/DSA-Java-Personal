import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class A {

    public static void check2023(int[] b ,int k, int n){
        boolean possible = true;
        Set<Integer> removedElements = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int current = b[i];
            if (removedElements.contains(current - 1)) {
                removedElements.add(current);
            }
            else if (removedElements.contains(current + 1)) {
                removedElements.add(current);
            }
            
            else if (removedElements.contains(current)) {
                removedElements.add(current + 1);
            }
                
            else {
                possible = false;
                break;
            }
        }

        if(possible){
            System.out.println("YES");
            for (int i = 0; i < k; i++) {
                System.out.print(removedElements.iterator().next() + " ");
                removedElements.remove(removedElements.iterator().next());
            }
            System.out.println();
        } 
        else{
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int[] b=new int[n];
            for(int j=0;j<n;j++){
                int element=sc.nextInt();
                b[j]=element;
            }
            check2023(b,k,n);
        }
    }
}
