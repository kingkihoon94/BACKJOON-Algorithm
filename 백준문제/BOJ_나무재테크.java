import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_��������ũ {
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
			return this.age > t1.age ? 1 : -1; //Ÿ���� ���̰� ��������� �켱���� ��������ֱ�.
		}
	}//�켱���� ť�� ����� �غ� ��.
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //�� �� ��
		int M = Integer.parseInt(st.nextToken()); //���� ����
		int K = Integer.parseInt(st.nextToken()); //���.
		int[][] map = new int[N+1][N+1];
		int[] nutrition = new int[N*N];
		int[][] direction = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				nutrition[(i-1)*N+(j-1)] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
			}
		}//�� �׸���.
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
		}//���� ť�� �ֱ�.
		int time = 0;
		while(time != K) {
			while(!q.isEmpty()) {
				Tree t = q.poll();
				if(t.age <= map[t.x][t.y]) { //��� �������.
					map[t.x][t.y] -= t.age; //��� �پ���
					t.age++; //���� �԰�.
					new_q.add(t);
				}
				else {
					t.age /= 2;
					dead_q.add(t);
				}
			}//��.
			while(!dead_q.isEmpty()) {
				Tree t = dead_q.poll();
				map[t.x][t.y] += t.age;
			}//����.
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
			}//����.
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					map[i][j] += nutrition[(i-1)*N+(j-1)];
				}
			}//�ܿ�.
			time++; // 1���� ����.
		}
		int answer = 0;
		while(!q.isEmpty()) {
			q.poll();
			answer++;
		}//����ִ� ���Ȯ��.
		System.out.println(answer);
	}//end main.
}//end class.
