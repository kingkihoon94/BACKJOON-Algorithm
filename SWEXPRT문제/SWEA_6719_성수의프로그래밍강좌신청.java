import java.io.*;
import java.util.*;

public class SWEA_6719_성수의프로그래밍강좌신청 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for(int test=1; test<=TC; test++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] num_list = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				num_list[i] = Integer.parseInt(st.nextToken());
			}//end input.
			Arrays.sort(num_list); //정렬한다.
			double A = 0L;
			for(int i=N-K; i<N; i++) {
				A=(A+num_list[i])/2; //쓸데없는거 뺴고 2로 나누면서 작은거부터 더한다.
			}
			sb.append("#").append(test).append(" ").append(A).append("\n");
		}//end TestCase.
		System.out.print(sb);
	}//end main.
}//end class.
