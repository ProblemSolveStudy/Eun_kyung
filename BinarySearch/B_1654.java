package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1654{

    public static void main(String[] args)throws IOException{

        // 콘솔에서 입력값을 받아옴
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
    
        // 입력값에서 K와 N을 추출
        StringTokenizer st = new StringTokenizer(str, " ");
        int K = Integer.parseInt(st.nextToken()); // 배열의 크기
        int N = Integer.parseInt(st.nextToken()); // 라인의 개수
    
        // K개의 정수를 입력받아 배열에 저장
        int[] arr = new int[K];
        for(int i = 0 ; i < K ; i ++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        // 배열을 정렬
        Arrays.sort(arr);
        
        // 이분 탐색을 위한 변수 초기화
        long left = 1;
        long right = arr[K-1];
        long answer = 0L;
    
        // 이분 탐색 실행
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            for (int i = 0 ; i < K; i ++) {
                sum += arr[i] / mid;
            }
    
            // 라인을 N개 이상 얻을 수 있는 경우
            if(sum >= N){
                left = mid + 1;
                answer = mid;
            }
            // 라인을 N개 이상 얻을 수 없는 경우
            else {
                right = mid - 1;
            }
        }
        // 결과 출력
        System.out.println(answer);
    }

}

