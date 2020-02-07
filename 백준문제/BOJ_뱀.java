import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_뱀 {
	
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
			map[dx][dy] = 2; //사과는 2 표시.
		}//사과 그리기.
		int M = sc.nextInt();
		int[][] instruction = new int[M][2];
		for(int i=0; i<M; i++) {
			instruction[i][0] = sc.nextInt();
			char temp = sc.next().charAt(0);
			switch(temp) {
			case 'D' : instruction[i][1] = 1; break; //오른쪽
			case 'L' : instruction[i][1] = -1; break; // 왼쪽
			}
		}//명령어 받기.
		int ptr = 1; //처음 오른쪽
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
			if(map[new_x][new_y] == 1) break; //자기 자신한테 막히는 경우.
			else if(map[new_x][new_y] == 2) {
				q.add(new Pos(new_x,new_y));
				map[new_x][new_y] = 1;
			}//사과 먹을경우.
			else {
				q.add(new Pos(new_x,new_y));
				map[new_x][new_y] = 1;
				Pos temp = q.poll();
				map[temp.x][temp.y] = 0;
			}//사과 안먹을경우.
			x = new_x;
			y = new_y;
			time++;
			if(time == instruction[flag][0]) {
				//System.out.println("방향 전환");
				ptr += instruction[flag][1];
				if(ptr == 4) ptr = 0;
				if(ptr == -1) ptr = 3;
				flag++;
				if(flag == M) flag = 0; //다시 부를일은 없음.
			}
		}//시뮬레이션 끝.
		System.out.println(time+1);
	}//end main.
}
