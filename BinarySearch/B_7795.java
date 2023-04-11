package BinarySearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class B_7795 {
    static int A; // N 배열의 크기
    static int B; // M 배열의 크기
    static int[] N; // A 배열
    static int[] M; // B 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) { // 테스트 케이스 T 만큼 반복
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            A = Integer.parseInt(st.nextToken()); // N 배열의 크기 입력
            B = Integer.parseInt(st.nextToken()); // M 배열의 크기 입력

            N = new int[A]; // N 배열 초기화
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < A; j++) {
                N[j] = Integer.parseInt(st2.nextToken()); // N 배열에 요소 입력
            }

            M = new int[B]; // M 배열 초기화
            StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < B; j++) {
                M[j] = Integer.parseInt(st3.nextToken()); // M 배열에 요소 입력
            }

            Arrays.sort(N); // N 배열 오름차순 정렬
            Arrays.sort(M); // M 배열 오름차순 정렬

            int count = 0; // N[j]보다 작은 수의 개수를 누적할 변수 초기화
            for (int j = 0; j < A; j++) { // N 배열의 모든 요소에 대해 반복
                int index = binarySearch(N[j]); // N[j] 보다 작은 수 중 가장 큰 수의 인덱스 찾기
                if (index != -1) { // 만약 찾았다면
                    count += index + 1; // 작은 수의 개수를 누적
                }
            }

            System.out.println(count); // 결과 출력
        }
    }


    public static int binarySearch(int C) { // 이분 탐색 함수
        int left = 0; // 검색 범위의 왼쪽 끝
        int right = B - 1; // 검색 범위의 오른쪽 끝
        int index = -1; // C보다 작은 수 중 가장 큰 수의 인덱스

        while (left <= right) { // 검색 범위가 남아있을 때까지 반복
            int mid = (left + right) / 2; // 중간 인덱스 계산
            if (M[mid] < C) { // 중간 값이 C보다 작은 경우
                index = mid; // index 갱신
                left = mid + 1; // 범위를 오른쪽으로 좁힘
            } else { // 중간 값이 C보다 크거나 같은 경우
                right = mid - 1; // 범위를 왼쪽으로 좁힘
        }
    }

    return index;
    }
}
