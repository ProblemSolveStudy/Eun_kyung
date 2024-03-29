package Sort;

import java.util.Arrays;

public class InsertionSort{
    public static void main(String[] args) {
        int[] arr = { 5, 2, 4, 1, 3 };
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
            System.out.println(Arrays.toString(arr));
        }
    }
}


// worst O(n^2), best O(n) 

