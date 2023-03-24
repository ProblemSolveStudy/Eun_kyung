import java.util.*;
import java.io.*;


public class B_1260{


	static int N;
	static int M;
	static int V;
	static int[][] arr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> Q = new LinkedList<>();

	public static void main(String[] args)throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][N + 1];
		visit = new boolean[N + 1];
;		for(int i = 0 ; i < M; i ++){

			String str2 = br.readLine();
			StringTokenizer st2 = new StringTokenizer(str2, " ");

			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());

			arr[a][b] = arr[b][a] = 1;
		}

		DFS(V);
		sb.append("\n");

		visit = new boolean[N + 1];

		BFS(V);
		System.out.println(sb);

	}

	public static void DFS(int start){

		visit[start] = true;
		sb.append(start +  " ");

		for(int i = 1 ; i <= N; i ++){

			if(arr[start][i] == 1 && !visit[i]){
				visit[i] = true;
				DFS(i);
			}
		}
	}

	public static void BFS(int start){

		Q.offer(start);
		visit[start] = true;
		
		while(!Q.isEmpty()){

			int n = Q.poll();
			sb.append(n + " ");

			for(int i = 1; i <= N; i ++){
				if(arr[n][i] == 1 && !visit[i]){
					Q.offer(i);
					visit[i] = true;
				}
			}

		}
	}
}