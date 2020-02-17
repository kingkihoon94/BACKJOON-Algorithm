import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_SWEA_1244_√÷¥ÎªÛ±›_D3_±Ë±‚»∆ {
    static int max_cnt;
    static int[] number;
    static int price = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int TC = Integer.parseInt(st.nextToken());
        for(int test=1; test<=TC; test++) {
            price  = 0;
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            max_cnt = Integer.parseInt(st.nextToken());
            number = new int[str.length()];
            for(int i=0; i<str.length(); i++) {
                number[i] = str.charAt(i) - '0';
            }
            if(max_cnt >= number.length) {
                for(int i=0; i<number.length-1; i++) {
                    int temp = number[i];
                    int idx = i;
                    for(int j=i+1; j<number.length; j++) {
                        if(temp <= number[j]) {
                            temp = number[j];
                            idx = j;
                        }
                    }
                    number[idx] = number[i];
                    number[i] = temp;
                }
                max_cnt = (max_cnt-number.length-1)%2;
            }
            dfs(0);
            System.out.println("#" + test + " " + price);
        }
    }
    public static void dfs(int cnt) {
        if(cnt == max_cnt) {
            int temp_price = 0;
            for(int i=0; i<number.length; i++) {
                temp_price += number[i] * (int)Math.pow(10, number.length-(i+1));
            }
            if(price < temp_price) price = temp_price;
            return ;
        }
        for(int i=0; i<number.length-1;i++) {
            for(int j=i+1; j<number.length;j++) {
                swap(i,j);
                dfs(cnt+1);
                swap(i,j);
            }
        }
    }//end dfs.
    public static void swap(int i, int j) {
        int temp = number[i];
        number[i] = number[j];
        number[j] = temp;
    }//end swap.
}