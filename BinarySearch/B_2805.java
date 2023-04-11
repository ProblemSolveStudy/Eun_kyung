package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2805 {

    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int N = Integer.parseInt(st.nextToken()); // 나무의 수
        int M = Integer.parseInt(st.nextToken()); // 가져가려는 나무의 길이
      
        int[] arr = new int[N]; // 나무의 길이를 저장할 배열
        String str2 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(str2, " ");

        int right = 0; // 초기화
        for(int i = 0 ; i < N; i ++){
            arr[i] = Integer.parseInt(st2.nextToken()); // 나무의 길이를 배열에 저장
            if(right < arr[i]){ // 최대값 구하기
                right = arr[i];
            }
        }

        int left = 0; // 초기화
        int answer = 0; // 정답을 저장할 변수

        while (left <= right) {
            int mid = (left + right) / 2; // 중간값 구하기
            long sum = 0; // 가져갈 나무의 길이의 합

            // 이분탐색을 위한 조건문
            for (int value :arr) {
                if (value > mid) {
                    sum += value - mid;
                }
            }

            if (sum >= M) { // 조건에 부합하면
                answer = mid; // 정답 저장
                left = mid + 1; // mid 값 증가
            }
            else { // 조건에 부합하지 않으면
                right = mid - 1; // mid 값 감소
            }
        }

        System.out.println(answer);
    }
}