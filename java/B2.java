import java.util.Scanner;

public class B2 {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.printf("Nhap a : ");

        float a = input.nextFloat();
        System.out.printf("Nhap b : ");
        float b = input.nextFloat();
        System.out.printf("Nhap c : ");
        float c = input.nextFloat();
        float x = (b+c)/a;

        input.close();
        if(a==0){
            System.out.printf("vo so nghiem");
        }
        else{
            System.out.printf("nghiem x = :"+ x);
        }

    }
}