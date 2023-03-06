import java.util.*;
import java.io.*;

class B_2178{

    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0 ; i < N; i ++){
            String str2 = br.readLine();

            for(int j = 0; j < M; j ++){
                arr[i][j] = str2.charAt(j)-'0';
            }
        }

        visited[0][0] = true;
        bfs(0,0);
    
        System.out.println(arr[N-1][M-1]);

    }

    public static void bfs(int a, int b){

        Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {a,b});

		while(!q.isEmpty()) {
            
			int[] now = q.poll();  //??????
			int nowX = now[0];
			int nowY = now[1];
		
			for(int i=0; i<4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				
		                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) //움직일 수 있는 범위 제한 및 체크
                		    continue;
        		        if (visited[nextX][nextY] || arr[nextX][nextY] == 0) // 방문여부와 지나갈 수 있는 길인지 체크
                    		continue;
  
		                q.add(new int[] {nextX, nextY}); //모든 조건을 통과할 경우 q에 이동할 수 있는 지점을 저장
        		        arr[nextX][nextY] = arr[nowX][nowY] + 1; //이전 지점 + 1의 값을 이동한 배열에 저장하여 움직인 거리를 축적한다.
                		visited[nextX][nextY] = true; //방문 체크

			}
		}
    }
}

