import java.io.*;
import java.util.*;

public class SWEA_5987_�޸��� {
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
			memo = new long[1<<N]; //����ϰ� �� mask ��ŭ ���� ����.
			Arrays.fill(memo, -1); //�Ⱦ��� ������ �ʱ�ȭ�س���.
			for(int i=0; i<N; i++) {
				list[i] = new ArrayList<Integer>();
			}//���� ����Ʈ �ʱ�ȭ.
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				list[Integer.parseInt(st.nextToken())-1].add(Integer.parseInt(st.nextToken())-1); //���� N���� ��� ���� �Ѱ���.
			}
			sb.append("#").append(test).append(" ").append(dp(0,0)).append("\n");
		}//end TestCase.
		System.out.print(sb);
	}//end main.
	public static long dp(int mask, int cnt) {
		if(mask == (1 << N) - 1) {
			return 1; //�� �̾Ƽ� ������ ���. 1���� ��� �߰�.
		} 
		else if(memo[mask] != -1) { //�̹� ������ �� �־������.
			return memo[mask];
		}
		memo[mask] = 0; //�� �ֱ� ����.
		for(int i=0; i<N; i++) {
			if((mask & (1 << i)) == 0 && valid(mask, i)) {
				memo[mask] += dp(mask | (1 << i), i);
			}
		}
		return memo[mask];
		
	}//end dp.
	public static boolean valid(int mask, int cnt) {
		for(int node : list[cnt]) {
			if((mask & 1 << node) > 0) { //���� ��ġ�� ���� �� ���� �ʰ� �����ؾ� �ϴ� ������ ���� �������� ��� �ȵǴ� ���.
				return false;
			}
		}
		return true; //�Ǵ� ���.
	}//end valid.
}//end class.
