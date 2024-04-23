public class Q1 {
    int[] evenArray = new int[50];
    int[] oddArray = new int[50];

    class P1 extends Thread {
        int evenIndex = 0;

        public void run() {
            for (int i = 1; i <= 100; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                    evenArray[evenIndex] = i;
                }
            }
        }
    }

    class P2 extends Thread {
        int oddIndex = 0;

        public void run() {
            for (int i = 1; i < 100; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                    oddArray[oddIndex] = i;
                }
            }
        }
    }

    public static void main(String[] args) {
        P1 t1 = new P1();
        t1.start();
        P2 t2 = new P2();
        t2.start();

        int[] arr=new int[evenArray.length+oddArray.length];
        for(int i=0;i<evenArray.length;i++){
            arr[i]=evenArray[i];
        }
        for(int j=50;i<oddArray.length+evenArray.length;i++){
            arr[j]=oddArray[j];
        }

        for(int k=0;k<arr.length;k++){
            System.out.println(arr[k]);
        }
    }
}
