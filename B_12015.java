import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class B_12015 {
 
    //메서드를 위해 전역변수로 선언

    static int[] arr;  //정렬되지 않은 배열
    static int[] lis;  //최장증가수열 판별을 위한 배열
    static int length = 1; //메서드 내에서 계속 증가할것임, 배열 원소의 대소비교를 위한 임의의 인덱스값
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());
 
		arr = new int[N];
		lis = new int[N];
 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
 
	
		lis[0] = arr[0]; //비교를 위해서 값이 하나라도 존재해야하기 때문에 arr의 0번쨰 원소를 lis 0번째 인덱스에 대입
	
        LIS(1); //lis[0] 과 arr[1] .... arr[arr.lenght-1] 까지 계속해서 대소 비교를 할 때, 이 역할을 for문을 사용하지 않고 재귀함수 방식으로
                  //실행할것이기 때문에 매개변수로 1을 대입하고 함수를 호출할 때 마다 1씩 순차적으로 증가시키는 방식을 선택
        System.out.println(length);
		
	}

    public static int LIS(int A){

            //A가 어레이 길이와 같아지는 순간 메서드 종료, 그 직전까지는 arr의 'A'번째 원소 -> 즉 인덱스 값을 담은 변수로 사용 예정
            if(A == arr.length)
            {
                return length;
            }

            
	    int key = arr[A];
            
            
	    if (lis[length - 1] < key) //만약 lis원소보다 arr원소가 더 클 경우 '즉 증가 수열일 경우' -> 다음 비교를 위해 length를 증가시키고(이미 값이 지정된 lis 원소 그 다음 인덱스에 대입하기 위해서)
                                       // lis에는 증가 수열임을 표시하기 위해 arr원소(key)를 저장
            {
	        length++;
		lis[length - 1] = key;
	    } 
	    else //작거나 같다면 아예 배제하는 것이 아니라 해당 수가 증가 수열내에서 어느 위치에 있는지를 판별해야한다. 이분탐색을 사용해서 빠른 속도로 해당 원소가 위치할 수 있는 곳 즉 다음 인덱스 원소보다는 작고 이전 인덱스 원소보다는 클 수 있는
                //위치를 파악하여 그 곳에 값을 저장한다.
            {
		int low = 0;
		int high = length;
	        while (low < high) //중간값 찾으려면 평균을 구해야하는데 당연히 최저범위가 최대범위보다 높으면 안되지!
                {
		   int mid = (low + high) / 2; 
					
		   if(lis[mid] < key) //중간값이 arr원소보다 작을경우 즉 오름차순으로 위치할 수 있는 인덱스를 찾았을 경우
                   {
			low = mid + 1; 
                        lis[mid + 1] = key; //lis의 인덱스를 계속 줄이다가 key가 lis 원소보다 커지는 순간(lis[mid]) 증가수열을 이루기 때문에 mid+ 1 한 위치에 arr 원소를 대입
		   }
	           else 
                    {
			high = mid; //만약 arr원소가 여전히 lis 원소보다 작다면 high를 중간값까지 낮춰 범위를 바꿔 재 탐색 한다.
		    }
 
	       }
                
                //정말 혹시라도 헷갈릴수 있는 부분 -> 이분탐색인데 정렬을 내가 안해줬다. 근데 이게 되나? 
                //lis는 한 원소를 기준으로 그 원소보다 큰 수만 저장한 증가수열 즉 오름차순 정렬이 된 배열이므로 이분탐색 사용이 가능하다.
				
			
	   }

         LIS(A+1); // 위 과정이 끝나면 다음 원소의 증가수열 판별을 위해 A (arr 인덱스 넘버)에 1을 더해 다시 호출한다.

         return length;
			
		
    }
}
