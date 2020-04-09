import java.io.*;
import java.util.*;


public class BOJ_1197_최소스패닝트리 {
	static class Pos implements Comparable<Pos>{
		int x;
		int y;
		int cnt;
		public Pos(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		public int compareTo(Pos p) {
			return this.cnt > p.cnt ? 1 : -1; //타겟이 더작을경우 우선순위 높게잡아주기.
		}
	}
	static int[] parent;
	static int V;
	static int E;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		parent = new int[V+1];
		for(int i=1; i<=V; i++) {
			parent[i] = i;
		}
		PriorityQueue<Pos> q = new PriorityQueue<Pos>();
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			q.add(new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		int answer = 0;
		int cnt = 0;
		while(true) {
			Pos p = q.poll();
			//System.out.println(p.x + "," + p.y + " , " + p.cnt);
			if(find(p.x) != find(p.y)) {
				answer += p.cnt;
				union(p.x , p.y);
				cnt++;
			}
			if(cnt == V-1) break;
		}
		System.out.println(answer);
	}//end main.
	public static void union(int x, int y) {
		x = find(x);
	    y = find(y);
	    if(x != y) parent[y] = x;
	}
	
	public static int find(int x) {
		if(parent[x] == x) return x;
	    return parent[x] = find(parent[x]);
	}
}//end class.
