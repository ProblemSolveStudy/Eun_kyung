package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2805 {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
      
        int[] arr = new int[N];
        String str2 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(str2, " ");

        int right = 0; //max

        for(int i = 0 ; i < N; i ++){
            arr[i] = Integer.parseInt(st2.nextToken());
            if(right < arr[i]){
                right = arr[i];
            }
        }

        int left = 0;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;
            for (int value :arr) {
                if (value > mid) {
                    sum += value - mid;
                }
            }

            if (sum >= M) {
                answer = mid;
                left = mid + 1;
            }
 
            else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
