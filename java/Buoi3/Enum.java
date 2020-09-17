package Buoi3;

public enum Enum {
    SPRING(1),
    SUMMER(2),
    AUTUMN(3),
    WINTER(4);
   
    private final int value;
  
    private Enum(int value) {
      this.value = value;
    }
  
    public int getValue() {
      return value;
    }
  
}
