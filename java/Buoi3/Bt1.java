package Buoi3;



public class Bt1 {
    public static void main(String args[]) {
        int[] arrOfInt = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Thêm :");
        int[] newArray = addToArray(arrOfInt, 6);
        for(int i=0; i<newArray.length; i++) {
          System.out.print(newArray[i] + " " );
        }


        System.out.println("\nXóa :");
        int[] rmArray =removeFromArray(arrOfInt,5);{
          for(int i=0; i<rmArray.length; i++) {
            System.out.print(rmArray[i] + " ");
          }
        }

        System.out.println("\nSửa :");
        int[] rpArray =replaceFromArray(arrOfInt,4,1);{
          for(int i=0; i<rpArray.length; i++) {
            System.out.print(rpArray[i] + " ");
          }
        }
        
        
        System.out.println();
    
      }
    //thêm
      public static int[] addToArray(int[] arr, int addValue) {
        int[] result = new int[arr.length + 1];
        for(int i=0; i < arr.length; i++) {
          result[i] = arr[i];
        }
        result[result.length - 1] = addValue;
        return result;
      }
      
      
      //xóa
      public static int[] removeFromArray(int[] arr, int value) {
        int length = arr.length - 1;
    
    
        if (value < 0 || value> length) {
          System.err.printf("Phải lớn hơn bằng 0 và nhỏ hơn bằng %d. Nhận vào: %d.\n", length, value);
          return arr;
        }
    
        int[] result = new int[length];
    
        for (int i = 0, j = 0; i < length; i++, j++) {
          if (j == value) {
            i--;
            continue;
          }
          
          result[i] = arr[j];
        }
    
        return result;
      }

      //sửa
      public static int[] replaceFromArray(int[] arr, int value,int rvalue) {
        int length = arr.length;
    
    
        if (value < 0 || value> length) {
          System.err.printf("Phải lớn hơn bằng 0 và nhỏ hơn bằng %d. Nhận vào: %d.\n", length, value);
          return arr;
        }
    
        int[] result = new int[length];
    
       for(int i=0;i<arr.length;i++){
           if(i==value){
              result[i]=rvalue;
              
              continue;
           }
           result[i] = arr[i];
       }
    
        return result;
      }    
    
    }
       

    