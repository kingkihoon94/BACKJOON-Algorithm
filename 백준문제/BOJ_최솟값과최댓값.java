import java.io.*;
import java.util.*;

public class BOJ_최솟값과최댓값 {
	
	static class Tree{
		long[] tree_min;
		long[] tree_max;
		int h=1;
		public Tree(int leaf) {
			while(h<leaf) {
				h*=2;
			}
			tree_min = new long[h*2];
			tree_max = new long[h*2];
			for (int i = 1; i < 2*h; i++) {
				tree_min[i] = Long.MAX_VALUE;
				tree_max[i] = Long.MIN_VALUE;
			}//2개의 트리.
		}//Tree Constructor.
		
		void update(int idx, long value) {
			int now = idx+h-1;
			tree_max[now] = value;
			tree_min[now] = value;
	        now /= 2;
	        while (now >= 1) {
	            tree_max[now] = tree_max[now * 2] > tree_max[now * 2 + 1] ? tree_max[now * 2] : tree_max[now * 2 +1];
	            tree_min[now] = tree_min[now * 2] < tree_min[now * 2 + 1] ? tree_min[now * 2] : tree_min[now * 2 +1];
	            now /= 2;
	        }
		}//vertex가 바뀜에 따른 그 상위 노드들의 값을 변경해주는 것을 의미함.
		
		long get_min(int left, int right) {
			long answer = Integer.MAX_VALUE;
			int l = left + h - 1;
			int r = right + h - 1;
			while(l<=r) {
				if(l%2 == 0) l/=2;
				else {
					if(answer > tree_min[l]) answer = tree_min[l];
					l = (l / 2) + 1;
				}
				//왼쪽 처리.
				if(r%2 == 1) r/=2;
				else {
					if(answer > tree_min[r]) answer = tree_min[r];
					r = (r / 2) - 1;
				}
				//오른쪽 처리.
			}
			return answer;
		}//end get_min.
		long get_max(int left, int right) {
			long answer = Integer.MIN_VALUE;
			int l = left + h - 1;
			int r = right + h - 1;
			while(l<=r) {
				if(l%2 == 0) l/=2;
				else {
					if(answer < tree_max[l]) answer = tree_max[l];
					l = (l / 2) + 1;
				}
				//왼쪽 처리.
				if(r%2 == 1) r/=2;
				else {
					if(answer < tree_max[r]) answer = tree_max[r];
					r = (r / 2) - 1;
				}
				//오른쪽 처리.
			}
			return answer;
		}//end get_max.
	}//end Tree.
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //리프 갯수.
		int M = Integer.parseInt(st.nextToken()); //명령어 갯수.
		Tree t = new Tree(N);
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			t.update(i, Long.parseLong(br.readLine()));
		}//트리 만들기.
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			sb.append(t.get_min(left,right)).append(" ").append(t.get_max(left,right)).append("\n");
		}//명령어 수행.
		System.out.print(sb);
	}//end main.
}//end class.
