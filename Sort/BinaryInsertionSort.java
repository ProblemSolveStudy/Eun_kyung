package Sort;

import java.util.Arrays;

public class BinaryInsertionSort{

    static int[] arr = {5, 2, 3, 1, 4};

    public static void main(String[] args) {

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int index = binarySearch(key, 0, i - 1);
            for (int j = i; j > index; j--) {
                arr[j] = arr[j - 1];
            }
            arr[index] = key;
            System.out.println(Arrays.toString(arr));
        }
       
    }

    public static int binarySearch(int key, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.println(mid);
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}

// always O(n log n)