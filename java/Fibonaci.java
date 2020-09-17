import java.util.Scanner;

public class Fibonaci {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Nhap n :");
        int n = input.nextInt();
        int a = 1 ,b = 2;
        input.close();
        for(int i = 0 ; i <= n ;i++){
            if(i==1){
                System.out.println(a);
            }
            if(i==2){
                System.out.println(b);
            }
            if(i>1){
                int c = a + b;
                a = b;
                b = c;
                System.out.println(c);
                
            }
        }
    }
}        
    