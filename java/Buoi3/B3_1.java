package Buoi3;
//mang nhieu chieu
public class B3_1 {
    public static void main(String[] args) {
    //     int [][] arrOfInt = new int[6][10];
    // for(int i =0;i<arrOfInt.length;i++){
    //     for(int j=0;j<arrOfInt[i].length;j++){       
    //        System.out.print(arrOfInt[i][j]+" ");
            
    //     }
    //     System.out.println();
    // }
    
    
    
    
    
    //     int [][] arrOfInt = {{1,2,1},{3,4,3},{5,6,5},{0,7,5}};
    //     for(int i =0;i<arrOfInt.length;i++){
    //     for(int j=0;j<arrOfInt[i].length;j++){       
    //        System.out.print(arrOfInt[i][j]+" ");
            
    //     }
    //     System.out.println();
    // }
    
    
    
    
    // int [][] arrOfInt = new int[8][];
    // for(int i =0;i<arrOfInt.length;i++){
    //     arrOfInt[i] = new int[i + 1];
    //     for(int j=0;j<arrOfInt[i].length;j++){       
    //        arrOfInt[i][j] = 10*(i+1);
    //         System.out.print(arrOfInt[i][j] +" ");       
    //     }
    //     System.out.println();
    // }
    // }
    



    String s="techmaster";
    String s2="center";
    String concatStr =s.concat(" ").concat(s2);
    System.out.println(concatStr);
    String s3 = "My class in Techmaster";
    String[] arrstrStrings = s3.split(" ");
    for(String elemStr:arrstrStrings){
        System.out.println(elemStr);
    }
    System.out.print(s.compareTo(s2));




    }
}