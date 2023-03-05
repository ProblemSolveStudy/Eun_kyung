// import java.io.*;
// import java.util.*;

// public class B_2178 {
	
// 	static int[][] map;
// 	static int n;
// 	static int m;
// 	static boolean[][] visited;
// 	static int[] dx = { -1, 1, 0, 0 }; //x방향배열-상하
//  static int[] dy = { 0, 0, -1, 1 }; //y방향배열-좌우

// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		StringTokenizer st = new StringTokenizer(br.readLine());
// 		n = Integer.parseInt(st.nextToken());
// 		m = Integer.parseInt(st.nextToken());
		
// 		map = new int[n][m];
// 		for(int i=0; i<n; i++) {
// 			String s = br.readLine();
// 			for(int j=0; j<m; j++) {
// 				map[i][j] = s.charAt(j) - '0';
// 			}
// 		}
		
// 		visited = new boolean[n][m];
// 		visited[0][0] = true;
// 		bfs(0, 0);
// 		System.out.println(map[n-1][m-1]);
// 	}

// 	public static void bfs(int x, int y) {
// 		Queue<int[]> q = new LinkedList<>();
// 		q.add(new int[] {x,y});

// 		while(!q.isEmpty()) {
// 			int now[] = q.poll();
// 			int nowX = now[0];
// 			int nowY = now[1];
// 			System.out.println(Arrays.toString(now));
// 			for(int i=0; i<4; i++) {
// 				int nextX = nowX + dx[i];
// 				int nextY = nowY + dy[i];
//                 System.out.println("nextX :"+nextX);
//                 System.out.println("nextY :"+nextY);
				
// 		                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
//                 		    continue;
//         		        if (visited[nextX][nextY] || map[nextX][nextY] == 0)
//                     		continue;
                    
// 		                q.add(new int[] {nextX, nextY});
//         		        map[nextX][nextY] = map[nowX][nowY] + 1;
//                 		visited[nextX][nextY] = true;
//                         System.out.println("visitied : "+visited[nextX][nextY]);
//                         System.out.println(map[nextX][nextY]);
// 			}
// 		}
// 	}
// }


import java.util.*;
import java.io.*;

class B_2178{

    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;
    static int cnt = 0;
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
            
			int now[] = q.poll();
			int nowX = now[0];
			int nowY = now[1];
		
			for(int i=0; i<4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				
		                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                		    continue;
        		        if (visited[nextX][nextY] || arr[nextX][nextY] == 0)
                    		continue;
  
		                q.add(new int[] {nextX, nextY});
        		        arr[nextX][nextY] = arr[nowX][nowY] + 1;
                		visited[nextX][nextY] = true;

			}
		}
    }
}