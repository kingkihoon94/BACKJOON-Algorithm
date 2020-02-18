import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_나무재테크 {
	static class Tree implements Comparable<Tree>{
		int x;
		int y;
		int age;
		public Tree() {
		}
		public Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}
		public int compareTo(Tree t1) {
			return this.age > t1.age ? 1 : -1; //타겟의 나이가 더작을경우 우선순위 높게잡아주기.
		}
	}//우선순위 큐를 사용할 준비 끝.
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //행 및 열
		int M = Integer.parseInt(st.nextToken()); //나무 정보
		int K = Integer.parseInt(st.nextToken()); //몇년.
		int[][] map = new int[N+1][N+1];
		int[] nutrition = new int[N*N];
		int[][] direction = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				nutrition[(i-1)*N+(j-1)] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
			}
		}//맵 그리기.
		PriorityQueue<Tree> q = new PriorityQueue<>();
		Queue<Tree> dead_q = new LinkedList<>();
		Queue<Tree> new_q = new LinkedList<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			Tree t = new Tree();
			t.x = Integer.parseInt(st.nextToken());
			t.y = Integer.parseInt(st.nextToken());
			t.age = Integer.parseInt(st.nextToken());
			q.add(t);
		}//나무 큐에 넣기.
		int time = 0;
		while(time != K) {
			while(!q.isEmpty()) {
				Tree t = q.poll();
				if(t.age <= map[t.x][t.y]) { //양분 먹을경우.
					map[t.x][t.y] -= t.age; //양분 줄어들고
					t.age++; //나이 먹고.
					new_q.add(t);
				}
				else {
					t.age /= 2;
					dead_q.add(t);
				}
			}//봄.
			while(!dead_q.isEmpty()) {
				Tree t = dead_q.poll();
				map[t.x][t.y] += t.age;
			}//여름.
			while(!new_q.isEmpty()) {
				Tree t = new_q.poll();
				if(t.age % 5 == 0) {
					for(int k=0; k<8; k++) {
						int new_x = t.x + direction[k][0];
						int new_y = t.y + direction[k][1];
						if(new_x >= 1 && new_x <= N && new_y >= 1 && new_y <= N) {
							q.add(new Tree(new_x,new_y,1));
						}
					}
				}
				q.add(t);
			}//가을.
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					map[i][j] += nutrition[(i-1)*N+(j-1)];
				}
			}//겨울.
			time++; // 1년이 지남.
		}
		int answer = 0;
		while(!q.isEmpty()) {
			q.poll();
			answer++;
		}//살아있는 얘들확인.
		System.out.println(answer);
	}//end main.
}//end class.
