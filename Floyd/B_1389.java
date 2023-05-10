package Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1389 {

    static int N;
    static int M;
    static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(arr[i], 100000000); // 노드간의 거리가 얼마나 클지 모르기때문에 무한대로 초기화
            arr[i][i] = 0; // 같은 노드 간에는 거리가 없기 때문에 0으로 초기화
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1; // 간선 정보
        }

        System.out.println(Arrays.deepToString(arr));

        // 플로이드-와샬 알고리즘
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        int minDistance = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int distanceSum = 0;
            for (int j = 1; j <= N; j++) {
                distanceSum += arr[i][j];
            }
            if (minDistance > distanceSum) {
                minDistance = distanceSum;
                answer = i;
            }
        }

        System.out.println(answer);
    }
}
