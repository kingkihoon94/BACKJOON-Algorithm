import java.io.*;
import java.util.*;

public class BOJ_구간합구하기 {
	
	static class Tree{
		long[] tree;
		int h = 1;
		public Tree(int n) {
			while(h < n) h*=2;
			tree = new long[h*2];
			for (int i = 1; i < 2*h; i++) {
				tree[i] = 0l;
			}
		}//Tree Constructor.
		
		public void update(int idx, long value) {
			int now = idx + h - 1;
	        tree[now] = value;
	        now /= 2;
	        while (now >= 1) {
	            tree[now] = tree[now * 2] + tree[now * 2 + 1];
	            now /= 2;
	        }
		}//vertex가 바뀜에 따른 그 상위 노드들의 값을 변경해주는 것을 의미함.
		
		public long Sum(int Left, int Right) {
			int l = Left  + h - 1;
	        int r = Right + h - 1;
	        long sum = 0;
	        while (l <= r) {
	            if (l % 2 == 0)
	                l /= 2;
	            else {
	                sum += tree[l];
	                l = (l / 2) + 1;
	            }
	            if (r % 2 == 1)
	                r /= 2;
	            else {
	                sum += tree[r];
	                r = (r / 2) - 1;
	            }
	        }
	        return sum;
	    }//구간별 합 구하기.
		
	}//Tree 구현.
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int inst = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		Tree t = new Tree(N); //트리 생성.
		for(int i=1; i<=N; i++) { //인덱스 시작 : 1. 그래야 트리 잘 넣어짐.
			t.update(i, Long.parseLong(br.readLine()));
		}//leaf들 저장.
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<inst; i++) {
			st = new StringTokenizer(br.readLine());
			switch(Integer.parseInt(st.nextToken())){
			case 1:
				t.update(Integer.parseInt(st.nextToken()), Long.parseLong(st.nextToken()));
				break;
			case 2:
				sb.append(t.Sum(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
				break;
			}
		}//명령어 수행.
		System.out.println(sb);
	}//end main.
	
}//end class.
