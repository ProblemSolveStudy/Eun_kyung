import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2873 {

    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[R*C];



        String right = "R";
        String left = "L";
        String up = "U";
        String down = "D";


        int cnt = 1;
        for(int i = 0; i < R; i ++ ){
            String str2 =  br.readLine();
            StringTokenizer st2 = new StringTokenizer(str2, " ");
       
            
        }
        if((R % 2 != 0 && C % 2 != 0) || (R % 2 == 0 && C % 2 != 0)){
        
            while(true){

                
                if(cnt == C){
                    System.out.print(down.repeat(R-1));
                    break;
                    
                }
                else if(cnt % 2 != 0){
                    System.out.print(down.repeat(R-1));
                    System.out.print(right);
                    cnt ++;
                }else if(cnt % 2 == 0){
                    System.out.print(up.repeat(R-1));
                    System.out.print(right);
                    cnt ++;
                }           

            }
            
          
        }
        else if(R % 2 != 0 && C % 2 == 0){
            while(true){

                if(cnt > R){
                    break;
                }
                if(cnt == R){
                    System.out.print(right.repeat(C-1));
                    cnt ++;
                }
                else if(cnt % 2 != 0){
                    System.out.print(right.repeat(C-1));
                    System.out.print(down);
                    cnt ++;
                }else if(cnt % 2 == 0){
                    System.out.print(left.repeat(C-1));
                    System.out.print(down);
                    cnt ++;
                }           

            }
            
          
        }
        else if(R % 2 == 0 && C % 2 == 0){

           
            
          
        }
        System.out.println(Arrays.toString(arr));
      
    }
    
}
