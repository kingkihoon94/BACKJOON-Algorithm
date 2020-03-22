import java.io.*;
import java.util.*;

public class SWEA_5987_달리기 {
	static ArrayList<Integer>[] list;
	static long[] memo;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for(int test=1; test<=TC; test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			list = new ArrayList[N];
			memo = new long[1<<N]; //사용하게 될 mask 만큼 길이 설정.
			Arrays.fill(memo, -1); //안쓰는 값으로 초기화해놓기.
			for(int i=0; i<N; i++) {
				list[i] = new ArrayList<Integer>();
			}//인접 리스트 초기화.
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				list[Integer.parseInt(st.nextToken())-1].add(Integer.parseInt(st.nextToken())-1); //길이 N으로 놀기 위한 한걸음.
			}
			sb.append("#").append(test).append(" ").append(dp(0,0)).append("\n");
		}//end TestCase.
		System.out.print(sb);
	}//end main.
	public static long dp(int mask, int cnt) {
		if(mask == (1 << N) - 1) {
			return 1; //다 뽑아서 나열한 경우. 1가지 경우 추가.
		} 
		else if(memo[mask] != -1) { //이미 이전에 값 넣어진경우.
			return memo[mask];
		}
		memo[mask] = 0; //값 넣기 시작.
		for(int i=0; i<N; i++) {
			if((mask & (1 << i)) == 0 && valid(mask, i)) {
				memo[mask] += dp(mask | (1 << i), i);
			}
		}
		return memo[mask];
		
	}//end dp.
	public static boolean valid(int mask, int cnt) {
		for(int node : list[cnt]) {
			if((mask & 1 << node) > 0) { //현재 위치에 들어올 값 보다 늦게 등장해야 하는 값들이 벌써 등장했을 경우 안되는 경우.
				return false;
			}
		}
		return true; //되는 경우.
	}//end valid.
}//end class.
