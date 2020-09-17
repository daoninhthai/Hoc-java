package Buoi3;

public class B3 {
   


      public static void main(String args[]) {
        int[] arrOfInt = {1, 2, 3, 4, 5};
    
        int[] newArray = addToArray(arrOfInt, 6);
    
        for(int i=0; i<newArray.length; i++) {
          System.out.print(newArray[i] + " ");
        }
        System.out.println();
    
      }
    
      public static int[] addToArray(int[] arrInput, int addValue) {
        int[] resultArray = new int[arrInput.length + 1];
        for(int i=0; i < arrInput.length; i++) {
          resultArray[i] = arrInput[i];
        }
        resultArray[resultArray.length - 1] = addValue;
        return resultArray;
      }
    
    }







//     public static void function_void_no_param(){

// }
// public static void function_void(int a){

// }
// public static void function_int(int a){
//     return a+1;
// }


// }
