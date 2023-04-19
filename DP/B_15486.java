package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_15486 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] t1 = new int[n+1];
        int[] p1 = new int[n+1];
      

        for(int i = 0 ; i < n ; i ++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            t1[i] = Integer.parseInt(st.nextToken());
            p1[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];
        int max = 0;

        for (int i = 0; i <= n; i++) {
            max = Math.max(max, dp[i]);

            int ni = i + t1[i];
            if (ni <= n) {
                dp[ni] = Math.max(dp[ni], max + p1[i]);
            }

            for (int t : dp) {
                System.out.print(t + " ");
            }
            System.out.println();
        }

        System.out.println(max);

    }
    
}
