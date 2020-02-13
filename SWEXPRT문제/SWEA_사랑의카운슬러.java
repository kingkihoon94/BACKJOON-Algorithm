import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SWEA_사랑의카운슬러 {
    static int[][] warms;
    static boolean[] check;
    static int N;
    static long min;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int TC = Integer.parseInt(st.nextToken());
        for(int test=1; test<=TC; test++) {
            min = -1;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            warms =  new int[N][2];
            check = new boolean[N];
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                warms[i][0] = Integer.parseInt(st.nextToken());
                warms[i][1] = Integer.parseInt(st.nextToken());
            }//end input.
            dfs(0,0);
            System.out.println("#" + test + " " + min);
        }//end testCase.
    }//end main.
    public static void dfs(int idx, int cnt) {
        if(cnt == N/2) {
            int move_x =0;
            int move_y =0;
            int x=0;
            int y=0;
            for(int i=0; i<N; i++) {
                if(check[i]) {
                    move_x += warms[i][0];
                    move_y += warms[i][1];
                }
                else {
                    x += warms[i][0];
                    y += warms[i][1];
                }
            }//합 다 구하기.
            long temp = calculate(move_x - x , move_y - y);
            if(min == -1) min = temp;
            else if(min != -1 && temp < min) min = temp;
            return ;
        }
        if(idx == N) return ;
        for(int i=idx; i<N; i++) {
            check[i] = true;
            dfs(i+1, cnt+1);
            check[i] = false;
        }
        return ;
    }//end dfs.
    public static long calculate(long x, long y) {
        return x*x + y*y;
    }
}//end class.