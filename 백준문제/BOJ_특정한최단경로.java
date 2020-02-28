import java.io.*;
import java.util.*;

public class BOJ_특정한최단경로 {
	
	static class Pos implements Comparable<Pos>{
		int end;
		int weight;
		public Pos(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		public int compareTo(Pos p) {
			return this.weight > p.weight? 1 : -1;
		}
	}//class Pos.
	
	static int answer = Integer.MAX_VALUE;
	static boolean exception = false;
	static ArrayList<Pos>[] list;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1]; 
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Pos(end, weight));
			list[end].add(new Pos(start,weight));
		}
		st = new StringTokenizer(br.readLine());
		int check1 = Integer.parseInt(st.nextToken());
		int check2 = Integer.parseInt(st.nextToken());
		
		int sum1 = go(1,check1) + go(check1, check2) + go(check2, N);
		int sum2 = go(1,check2) + go(check2, check1) + go(check1, N);
		if(answer > sum1) answer = sum1;
		if(answer > sum2) answer = sum2;
		if(exception) System.out.println(-1);
		else System.out.println(answer);
		return ;
	}//end main.
	public static int go(int start, int end) {
		int sum = -1;
		int[] dijkstra = new int[N+1];
		for(int i=1; i<=N; i++) {
			dijkstra[i] = Integer.MAX_VALUE;
		}
		dijkstra[start] = 0;
		PriorityQueue<Pos> q = new PriorityQueue<>();
		q.add(new Pos(start,0));
		while(!q.isEmpty()) {
			Pos now = q.poll();
			if(now.end == end) {
				sum = dijkstra[now.end];
				break;
			}
			for(int i=0; i<list[now.end].size(); i++) {
				Pos next = list[now.end].get(i);
				if(dijkstra[next.end] > now.weight+next.weight) {
					dijkstra[next.end] = now.weight+next.weight;
					q.add(new Pos(next.end, dijkstra[next.end]));
				}
			}
		}//end while.
		if(sum == -1) exception = true;
		return sum;
	}//end go.
}//end class.
