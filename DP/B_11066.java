

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11066 {

    static int[] arr; // 입력받은 파일 크기 배열
    static int[][] dp; // dp 테이블
    static int[] sum; // 파일 크기 누적 합 배열
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            arr = new int[K];
            for (int j = 0; j < K; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            dp = new int[K][K]; // 초기 dp 테이블 생성
            sum = new int[K + 1]; // 초기 파일 크기 누적 합 배열 생성
            for (int j = 1; j <= K; j++) {
                sum[j] = sum[j - 1] + arr[j - 1]; // 파일 크기 누적 합 계산
            }
            System.out.println(mergeFiles(0, K - 1)); // 답 출력
        }
    }

    // 파일 합치기 함수
    public static int mergeFiles(int start, int end) {

        // base case: start와 end가 같을 때 파일이 하나일 경우 0 반환
        if (start == end) {
            return 0;
        }

        // 이미 계산한 값이라면 바로 반환
        if (dp[start][end] != 0) {
            return dp[start][end];
        }

        int result = Integer.MAX_VALUE;

        // 파일을 나누는 지점을 i로 설정하여 각 경우에 대해 최솟값을 계산
        for (int i = start; i < end; i++) {
            // dp[start][i]: start부터 i까지 파일을 합치는 최소 비용
            // dp[i + 1][end]: i + 1부터 end까지 파일을 합치는 최소 비용
            // sum[end + 1] - sum[start]: start부터 end까지 파일 크기 누적합
            result = Math.min(result, mergeFiles(start, i) + mergeFiles(i + 1, end) + sum[end + 1] - sum[start]);
            // 처음에 i는 0이 되어 mergeFiles(0, 0)과 mergeFiles(1, 3)을 호출합니다.
            // mergeFiles(0, 0)은 base case를 만족하므로 0을 반환합니다. mergeFiles(1, 3)은 더 작은 단위의 파일들로 분할하여 최소비용을 계산합니다.
            // 이제 i가 1이 되어 mergeFiles(0, 1)과 mergeFiles(2, 3)을 호출합니다.
            // mergeFiles(0, 1)은 더 작은 단위의 파일들로 분할하여 최소비용을 계산합니다. mergeFiles(2, 3)은 base case를 만족하므로 0을 반환합니다.
            // 마지막으로 i가 2가 되어 mergeFiles(0, 2)과 mergeFiles(3, 3)을 호출합니다.
            // mergeFiles(0, 2)은 더 작은 단위의 파일들로 분할하여 최소비용을 계산합니다. mergeFiles(3, 3)은 base case를 만족하므로 0을 반환합니다.
            // 이렇게 계산된 최소비용들을 더한 후, sum 배열에서 파일 크기 누적합을 구하여 뺀 값을 result에 저장합니다. 이 값이 최종적인 최소비용이 됩니다.
            // 마지막으로, 이 계산된 최소비용을 dp 테이블에 저장하고, result 값을 반환합니다.
            // 이렇게 계속해서 파일을 분할하여 최소비용을 계산하다 보면, 결국 전체 파일을 하나로 합치는 최소비용을 계산할 수 있습니다.



        }

        // 계산된 값 저장
        dp[start][end] = result;

        // 최소 비용 반환
        return result;
    }
}



// 이 알고리즘의 시간 복잡도는 O(N^3)입니다.
// mergeFiles 함수는 인자로 주어진 범위에 대해 for문을 한 번 순회하며, 해당 범위 내 모든 구간에 대해 재귀적으로 호출합니다. 
// 이 과정에서 구간의 크기 N에 대해 총 N번의 호출이 발생합니다.
// 따라서 mergeFiles 함수는 O(N^2)의 시간 복잡도를 가집니다.
// sum 배열의 누적합 계산은 배열의 길이인 N에 비례하는 O(N)의 시간이 소요됩니다.
// 이에 따라 전체 알고리즘의 시간 복잡도는 O(N^3)이 됩니다.