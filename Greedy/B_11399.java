import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_11399 {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        int[] arr = new int[TC]; 

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        };
    
        Arrays.sort(arr);
  
        int sum = 0;
        int result = 0;
        for(int i = 0 ; i < arr.length; i ++){
            sum += arr[i];
            result += sum;
        }

        System.out.println(result);
    }
    
}
