import java.io.*;
import java.util.*;

public class BOJ_�ּڰ����ִ� {
	
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
			}//2���� Ʈ��.
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
		}//vertex�� �ٲ� ���� �� ���� ������ ���� �������ִ� ���� �ǹ���.
		
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
				//���� ó��.
				if(r%2 == 1) r/=2;
				else {
					if(answer > tree_min[r]) answer = tree_min[r];
					r = (r / 2) - 1;
				}
				//������ ó��.
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
				//���� ó��.
				if(r%2 == 1) r/=2;
				else {
					if(answer < tree_max[r]) answer = tree_max[r];
					r = (r / 2) - 1;
				}
				//������ ó��.
			}
			return answer;
		}//end get_max.
	}//end Tree.
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //���� ����.
		int M = Integer.parseInt(st.nextToken()); //��ɾ� ����.
		Tree t = new Tree(N);
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			t.update(i, Long.parseLong(br.readLine()));
		}//Ʈ�� �����.
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			sb.append(t.get_min(left,right)).append(" ").append(t.get_max(left,right)).append("\n");
		}//��ɾ� ����.
		System.out.print(sb);
	}//end main.
}//end class.
