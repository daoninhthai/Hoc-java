import java.util.Arrays;
// import java.util.Scanner;

/* for loop */


public class B2_1 {
    // public static void main(final String[] args) {
    //     /* for(var i = 200 ; i < 501 ; i++){
    //         if(i%9==0){
    //             System.out.println(i);
    //         }
    //     }*/



    //   /*   while loop 


    //     Scanner input = new Scanner(System.in);
    //     System.out.printf("Nhap a :");
    //     int a = input.nextInt();
    //     System.out.printf("Nhap b :");
    //     int b = input.nextInt();
    //     int i = a;
    //     int max = b;
    //     if(a>b){
    //         i=b;
    //         max = a;
    //     }
        
    //     while(i < max){
    //         if(i % 3 == 0){
    //             System.out.println(i);  
    //         }
    //         i++;
    //     }
    //     input.close(); */
        
        
    //     /* fibonaci */
        // Scanner input = new Scanner(System.in);
        // System.out.printf("Nhap n :");
        // int n = input.nextInt();
        // int a = 1 ,b = 2;
        
        // for(int i = 0 ; i <= n ;i++){
        //     if(i==1){
        //         System.out.println(a);
        //     }
        //     if(i==2){
        //         System.out.println(b);
        //     }
        //     if(i>1){
        //         int c = a + b;
        //         a =b;
        //         b=c;
        //         System.out.println(c);
                
        //     }
        // }
        
    //     /* sap xep noi bot */ 
        
            
        
        

            
    // }
    public static void main(String[] args) {
            int[] array = {3, 7, 5, 2, 6, 12, 8, 10, 25, 14};
            int max=0;
            for (int i = 0;i<array.length;i++ ){
                for(int j = 0 ;j < array.length ;j++){
                    if(array[i]>array[j]){
                        max=array[i];
                        array[i]=array[j];
                        array[j]=max;

                    }
                }
            }
           
            System.out.println(Arrays.toString(array));

        }/* completeflat */
}