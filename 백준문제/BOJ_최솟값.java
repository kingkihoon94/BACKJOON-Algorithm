import java.io.*;
import java.util.*;

public class BOJ_최솟값 {
	
	static class Tree{
		long[] tree;
		int h = 1;
		public Tree(int n) {
			while(h<n) {
				h*=2;
			}
			tree = new long[h*2];
			for(int i=1; i<h*2; i++) {
				tree[i] = Long.MAX_VALUE;
			}
		}//Constructor.
		void update(int idx, long value) {
			int leaf = idx+h-1;
			tree[leaf] = value;
			leaf /= 2;
			while(leaf>=1) {
				tree[leaf] = tree[leaf*2] < tree[leaf*2 + 1] ? tree[leaf*2] : tree[leaf*2+1];
				leaf /= 2;
			}
		}//update.(작은 값 넣어놓기.)
		
		long get_min(int l, int r) {
			int left = l + h -1;
			int right = r + h -1;
			long answer = Long.MAX_VALUE;
			while(left<=right) {
				if(left%2==1) {
					answer = answer < tree[left] ? answer : tree[left];
					left = left/2 + 1;
				}
				else {
					left /= 2;
				}
				if(right%2==0) {
					answer = answer < tree[right] ? answer : tree[right];
					right = right/2 -1;
				}
				else {
					right /= 2;
				}
			}
			return answer;
		}
	}//class Tree.
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Tree t = new Tree(N);
		for(int i=1; i<=N; i++) {
			t.update(i, Long.parseLong(br.readLine()));
		}
		StringBuilder sb = new StringBuilder();
		for(int j=0; j<M; j++) {
			st = new StringTokenizer(br.readLine());
			sb.append(t.get_min(Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken()))).append("\n");
		}
		System.out.print(sb);
	}//end main.
}//end class.
