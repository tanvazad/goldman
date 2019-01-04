package practise.ds.LinkedList;

import java.util.Scanner;
import java.util.Arrays;

public class ShotRange {
  public static int[] A;
  public static int[] B;
  public static int[] C;
  public static int[] D;

  public static int lowerBoundSearch(int a[], int low, int high, int key) {
    while (low + 1 < high) {
      int mid = (low + high) / 2;
      if (a[mid] < key)
        low = mid;
      else
        high = mid;
    }
    return high;
  }

  public static int upperBoundSearch(int a[], int low, int high, int key) {
    while (low + 1 < high) {
      int mid = (low + high) / 2;
      if (a[mid] <= key)
        low = mid;
      else
        high = mid;
    }
    return high;
  }


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    A = new int[N];
    B = new int[N];
    C = new int[M];
    D = new int[M];
    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
      B[i] = sc.nextInt();
    }
    for (int i = 0; i < M; i++) {
      C[i] = sc.nextInt();
      D[i] = sc.nextInt();
    }
    Arrays.sort(A);
    Arrays.sort(B);
    int str = 0;
    for (int i = 0; i < M; i++) {
      int l = C[i], r = D[i];
      int count1 = lowerBoundSearch(B, -1, N, l);
      int count2 = N - upperBoundSearch(A, -1, N, r);
      int strength = N - (count1 + count2);
      str += strength;
    }

    System.out.println(str);
  }
}
