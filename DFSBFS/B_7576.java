import java.io.*;
import java.util.*;

public class B_7576{
	
	static int m;
	static int n;
	static int[][] tomato;
	static int maxVal;

    //상하좌우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		tomato = new int[n][m];

		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        
		
        //토마토 배열을 돌면서 값이 1일 경우 즉 토마토가 익어있는 포지션을 q에 저장
		Queue<int[]> q = new LinkedList<>();
	
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(tomato[i][j] == 1) {
					q.add(new int[] {i,j});
				}
			}
		}
	
        //2차원 배열인 q의 원소를 꺼내서 nowX와 nowY로 분리
		while(!q.isEmpty()) {
			int now[] = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			
            //상하좌우로 좌표를 변경해본다. i가 0일때는 nowX에 -1을, 1일때는 1을, 2일때는 nowY에 -1을 3일때는 1을 각각 더한다.
            //큐는 FIFO임으로 상하좌우에서 움직일 수 있는 곳들을 모두 움직이고 1로 바꿔준후 poll하고 이를 반복. 
            //상하좌우로 움직일 수 있을때마다 +1 절대 아님!! 익은 토마토(즉 1)을 중심으로 상하좌우에 0이 있으면 익은 토마토 +1씩만 한 후 위치 변경
        
			for(int i=0; i<4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				

                //배열의 범위를 벗어날 경우 i ++;
				if(nextX < 0 || nextY < 0 || nextX > n-1 || nextY > m-1)
					continue;
				
                //값이 0이 아닐경우 토마토가 익을 필요 없으니 i ++;
				if(tomato[nextX][nextY] != 0)
					continue;
				
                //위 조건들에 걸리지 않는다면 즉 배열의 범위 안에 있고, 토마토가 아직 익지 않은 포지션이라면 1을 더해 익었다고 표시
				tomato[nextX][nextY] = tomato[nowX][nowY] + 1;

                System.out.println(Arrays.deepToString(tomato));
                //토마토가 익었으니 q에 포지션을 추가
				q.add(new int[] {nextX, nextY});
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(tomato[i][j] == 0) {
                    //토마토 배열을 쭉 돌아보면서 0이 존재하면 익지 않은 토마토가 있는 것이기 때문에 -1을 출력하고 코드를 아예 종료한다.
					System.out.println(-1);
					System.exit(0);
				}
                //아닐 경우엔 배열 안에서 제일 큰 수를 maxVal에 저장 후 -1을 하여 출력
				maxVal = Math.max(maxVal, tomato[i][j]);
			}
		}
		System.out.println(maxVal-1);
	}
	
}
