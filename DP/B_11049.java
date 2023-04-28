import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class B_11049 {

    static int N;
    static int[][] arr; // 행렬 크기 정보를 저장하는 배열
    static int[][] dp; // 메모이제이션을 위한 배열
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][2]; // 1부터 N까지의 행렬 크기 정보 저장
        dp = new int[N + 1][N + 1]; // 행렬 곱셈 횟수 저장
        
        // 행렬 크기 정보 입력받기
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        // start 부터 end까지의 최소 곱셈 횟수 계산
        System.out.println(solve(1, N));
    }
    
    public static int solve(int start, int end) {
        // start부터 end까지의 크기가 같은 경우, 곱셈이 필요하지 않음
        if (start == end) return 0;
        
        // 이미 계산한 경우, 저장된 값 리턴
        if (dp[start][end] > 0) return dp[start][end];
        
        dp[start][end] = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            // start ~ i까지와 i+1 ~ end까지의 최소 곱셈 횟수를 더하고, 이번에 곱하는 행렬의 곱셈 횟수를 더함
            int cost = solve(start, i) + solve(i + 1, end) + (arr[start][0] * arr[i][1] * arr[end][1]);
            // 최소 곱셈 횟수 갱신
            dp[start][end] = Math.min(dp[start][end], cost);
        }
        
        return dp[start][end];
    }
}
