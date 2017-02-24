import java.util.Arrays;

class sort {
  public static void main(String[] args) {
    
    
    int[] a = {0,5,2,3,0,5,0};
    
    int aCnt = 0;
    int lenA = a.length;
    
    for (int i = 0; i < lenA; i++){
      if (a[i] != 0)
        aCnt = aCnt + 1;
    }
    
    int[] b = new int[aCnt];
    int bCnt = 0;
    int lenB = b.length;
    
    for (int j = 0; j < lenA; j++) {
      if (a[j] != 0) {
        b[bCnt] = a[j];
        bCnt = bCnt + 1;
      }
    }
    //Arrays.sort();
    System.out.println(Arrays.toString(b));    
  }
}