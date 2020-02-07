import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_�� {
	
	static class Pos{
		int x;
		int y;
		public Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] map =  new int[N+1][N+1];
		int[][] direction = {{-1,0},{0,1},{1,0},{0,-1}};
		for(int i=0; i<K; i++) {
			int dx = sc.nextInt();
			int dy = sc.nextInt();
			map[dx][dy] = 2; //����� 2 ǥ��.
		}//��� �׸���.
		int M = sc.nextInt();
		int[][] instruction = new int[M][2];
		for(int i=0; i<M; i++) {
			instruction[i][0] = sc.nextInt();
			char temp = sc.next().charAt(0);
			switch(temp) {
			case 'D' : instruction[i][1] = 1; break; //������
			case 'L' : instruction[i][1] = -1; break; // ����
			}
		}//��ɾ� �ޱ�.
		int ptr = 1; //ó�� ������
		int x = 1;
		int y = 1;
		int time = 0;
		int flag = 0;
		Queue<Pos> q = new LinkedList();
		q.add(new Pos(x,y));
		map[x][y] = 1;
		while(true) {
			int new_x = x + direction[ptr][0];
			int new_y = y + direction[ptr][1];
			//System.out.println("new_x : " + new_x + " new_y : " + new_y);
			if(new_x <=0 || new_x > N || new_y <=0 || new_y > N) break;
			if(map[new_x][new_y] == 1) break; //�ڱ� �ڽ����� ������ ���.
			else if(map[new_x][new_y] == 2) {
				q.add(new Pos(new_x,new_y));
				map[new_x][new_y] = 1;
			}//��� �������.
			else {
				q.add(new Pos(new_x,new_y));
				map[new_x][new_y] = 1;
				Pos temp = q.poll();
				map[temp.x][temp.y] = 0;
			}//��� �ȸ������.
			x = new_x;
			y = new_y;
			time++;
			if(time == instruction[flag][0]) {
				//System.out.println("���� ��ȯ");
				ptr += instruction[flag][1];
				if(ptr == 4) ptr = 0;
				if(ptr == -1) ptr = 3;
				flag++;
				if(flag == M) flag = 0; //�ٽ� �θ����� ����.
			}
		}//�ùķ��̼� ��.
		System.out.println(time+1);
	}//end main.
}
