import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//그림으로 규칙 찾음 특별한 알고리즘이 필요없었음

public class B_1783 {

    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(N == 1){
            System.out.println(1);
        }else if(N == 2){
            System.out.println((M+1) / 2);
        }else if(N >= 3){
            if(M < 7) {
                System.out.println(Math.min(M, 4));
				
			}else{
                System.out.println(M-2);
			}
        }
    }   
}
