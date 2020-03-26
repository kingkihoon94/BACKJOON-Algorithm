import java.io.*;
import java.util.*;

public class BOJ_1939_중량제한 {
	static class Pos{
		int end;
		long weight;
		public Pos(int end, long weight) {
			this.end = end;
			this.weight = weight;
		}
	}//class Pos.
	static long[] answer;
	static ArrayList<Pos>[] list;
	static boolean[] visited;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		answer = new long[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<Pos>();
		}
		visited = new boolean[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			long weight = Long.parseLong(st.nextToken());
			list[x].add(new Pos(y,weight));
			list[y].add(new Pos(x,weight));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken()); //end input.
		for(int i=0; i<list[start].size(); i++) {
			answer[list[start].get(i).end] = list[start].get(i).weight;
		}//초기화.
		visited[start] = true;
		while(true) {
			long temp_max = 0;
			int max_idx = 0;
			for(int i=1; i<=N; i++) {
				if(!visited[i] && temp_max < answer[i]) {
					max_idx = i;
					temp_max = answer[i];
				}
			}
			if(max_idx == end) break;
			visited[max_idx] = true;
			for(int i=0; i<list[max_idx].size(); i++) {
				int temp_end = list[max_idx].get(i).end;
				long temp_weight = list[max_idx].get(i).weight;
				answer[temp_end] = Math.max(answer[temp_end], Math.min(temp_max, temp_weight));
			}
		}
		System.out.println(answer[end]);
	}//end main.
}//end class.
