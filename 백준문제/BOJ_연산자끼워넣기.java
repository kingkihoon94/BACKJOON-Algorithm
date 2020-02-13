import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_¿¬»êÀÚ³¢¿ö³Ö±â {
	
	static int[] oper_cnt = new int[4];
	static int[] num_list;
	static int[] oper_list;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		num_list = new int[N];
		oper_list =  new int[N-1];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num_list[i] =Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			oper_cnt[i] =Integer.parseInt(st.nextToken());
		}
		//end input.
		dfs(0);
		System.out.println(max);
		System.out.println(min);
	}//end main.
	
	public static void dfs(int cnt) {
		if(cnt == N-1) {
			int temp = calculate();
			if(temp < min) min = temp;
			if(temp > max) max = temp;
			return ;
		}
		
		for(int i=0; i<4; i++) {
			if(oper_cnt[i] != 0) {
				oper_cnt[i]--;
				oper_list[cnt] = i;
				dfs(cnt+1);
				oper_cnt[i]++;
				oper_list[cnt] = 0;
			}
		}
		
	}//end dfs.
	public static int calculate() {
		int sum = num_list[0];
		for(int i=0; i<N-1; i++) {
			switch(oper_list[i]) {
			case 0: sum += num_list[i+1];break;//µ¡¼ÀÀÇ °æ¿ì.
			case 1: sum -= num_list[i+1];break;//»¬¼ÀÀÇ °æ¿ì.
			case 2: sum *= num_list[i+1];break;//°ö¼ÀÀÇ °æ¿ì.
			case 3: sum /= num_list[i+1]; break;//³ª´°¼ÀÀÇ °æ¿ì.
			}//end switch.
		}//end for.
		return sum;
	}//end calculate.
}//end class.
