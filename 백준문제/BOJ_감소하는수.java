import java.io.*;
import java.util.*;

public class BOJ_감소하는수 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int cnt = 9;
		Queue<Long> q = new LinkedList();
		for(Long i= 1L; i<=9L; i++) {
			q.add(i);
		}//처음 값 넣어주기.
		if(N <= 9) {
			System.out.println(N);
			return ;
		}
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0; i<size; i++) {
				Long now = q.poll();
				int top = (int)(now%10);
				Long next = now * 10;
				for(int j=0; j<top; j++) {
					cnt++;
					q.add(next+j);
					if(cnt == N) {
						System.out.println(next+j);
						return ;
					}
				}
			}
		}//end while.
		System.out.println(-1);
	}//end main.
}//end class.
