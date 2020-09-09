import java.util.Scanner;


public class Loan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Nhập vào số tiền gốc (vd: P = 100000$): ");
        float P = input.nextFloat();
        System.out.printf("Nhập vào lãi xuất :(vd: r = 0.005 ): ");
        float r = input.nextFloat();
        System.out.printf("Nhập vào số kỳ trả nợ (vd: n = 180): ");
        float n = input.nextFloat();
        System.out.println("M = " + P*(r*Math.pow((1+r),n))/(Math.pow((1+r),n)-1) + "$");
    }
}