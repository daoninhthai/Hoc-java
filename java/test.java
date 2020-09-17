import java.util.Arrays;

class App {
  int[] insert(int[] arr, int value) {
    int length = arr.length;

    int[] result = new int[length + 1];

    for (int i = 0; i < length; i++) {
      result[i] = arr[i];
    }

    result[length] = value;

    return result;
  }

  int[] insert(int[] arr, int value, int index) {
    int length = arr.length;

    if (index < 0 || index > length) {
      System.err.printf("Index phải lớn hơn bằng 0 và nhỏ hơn bằng %d. Nhận vào: %d.\n", length, index);
      return arr;
    }

    int[] result = new int[length + 1];

    for (int i = 0, j = 0; i < length + 1; i++, j++) {
      if (i == index) {
        result[i] = value;
        j--;
        continue;
      }

      result[i] = arr[j];
    }

    return result;
  }

  int[] remove(int[] arr) {
    int length = arr.length - 1;

    if (length < 0) {
      System.err.printf("Mảng nguồn không còn phần tử nào để mà xóa đâu :@");
      return arr;
    }

    int[] result = new int[length];

    for (int i = 0; i < length; i++) {
      result[i] = arr[i];
    }

    return result;
  }

  int[] remove(int[] arr, int index) {
    int length = arr.length - 1;

    if (length < 0) {
      System.err.printf("Mảng nguồn không còn phần tử nào để mà xóa đâu :@\n");
      return arr;
    }

    if (index < 0 || index > length) {
      System.err.printf("Index phải lớn hơn bằng 0 và nhỏ hơn bằng %d. Nhận vào: %d.\n", length, index);
      return arr;
    }

    int[] result = new int[length];

    for (int i = 0, j = 0; i < length; i++, j++) {
      if (j == index) {
        i--;
        continue;
      }

      result[i] = arr[j];
    }

    return result;
  }
}

class Main {
  public static void main(String[] args) {
    int[] arr = { 1, 2, 3,4,5,6,7 };
    App app = new App();

    System.out.println(Arrays.toString(app.insert(arr, 4)));
    System.out.println(Arrays.toString(app.insert(arr, 4, 4)));
    System.out.println(Arrays.toString(app.remove(arr)));
    System.out.println(Arrays.toString(app.remove(arr, 4)));
  }
}