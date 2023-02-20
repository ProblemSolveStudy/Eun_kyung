시간복잡도 : O(n)
알고리즘 : 그리디


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1931{
    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        int[][] arr = new int[TC][2];
  
        for(int i = 0 ; i < arr.length; i ++){

            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str , " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            
        }

        Arrays.sort(arr, (o1, o2) -> {
           
            if(o1[1] == o2[1]){
                return Integer.compare(o1[0], o2[0]);
            }else{
                return Integer.compare(o1[1], o2[1]);  
            }
                
        
        });

        int cnt = 1;
        int preE = arr[0][1];

        for(int i = 1 ; i < arr.length; i ++){
           
            if(preE <= arr[i][0]){
            
                preE = arr[i][1];
                    
                cnt ++;
                
            }else{
                continue;
            }
        }

        System.out.println(cnt);
       
    }
}
