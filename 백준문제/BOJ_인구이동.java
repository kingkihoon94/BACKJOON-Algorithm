import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_�α��̵� {
	
	static class Pos{
		int x;
		int y;
		int size;
		public Pos(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}
	}//Pos.
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int min = Integer.parseInt(st.nextToken());
		int max = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		int[][] direction = {{-1,0}, {1,0},{0,-1},{0,1}};
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		while(true) {
			boolean[][] visited = new boolean[N][N];
			ArrayList<Pos>[] list = new ArrayList[N*N];
	        for (int i=0; i<N*N; i++) {
	            list[i] = new ArrayList<Pos>();
	        }//ArrayList.
	        int cnt=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j]) { //�湮���� ���� Ȯ��!
						Queue<Pos> q = new LinkedList(); //BFS���� ť.
						q.add(new Pos(i,j,map[i][j])); //ù �� �ֱ�.
						visited[i][j] = true;
						list[cnt].add(new Pos(i,j,map[i][j]));
						while(!q.isEmpty()) {
							Pos p = q.poll();
//							System.out.println("start!! : " + p.x + " " + p.y + " " + p.size);
							for(int k=0; k<4; k++) {
								int new_x = p.x + direction[k][0];
								int new_y = p.y + direction[k][1];
								if(new_x >=0 && new_x < N && new_y >=0 && new_y < N &&!visited[new_x][new_y]
										&& Math.abs(p.size-map[new_x][new_y]) >= min && Math.abs(p.size-map[new_x][new_y]) <= max) {
									visited[new_x][new_y] = true;
									list[cnt].add(new Pos(new_x,new_y,map[new_x][new_y]));
									q.add(new Pos(new_x,new_y,map[new_x][new_y])); //ť�� �߰�.
//									System.out.println("add : " + new_x + " " + new_y + " " + map[new_x][new_y]);
								}//����������.
							}
						}//���� ���ϱ�.
						cnt++;//�ٸ� ����.
					}//end if.
				}
			}//end ����������.
			boolean total_end = true;
			for(int i=0; i<cnt; i++) {
				int sum_size = 0;
				for(int j=0; j<list[i].size(); j++) {
					sum_size += list[i].get(j).size;
				}//������� �ٲ��ֱ�.
				int average = sum_size / list[i].size();
				for(int j=0; j<list[i].size(); j++) {
					if(map[list[i].get(j).x][list[i].get(j).y] != average) {
						total_end = false;
						map[list[i].get(j).x][list[i].get(j).y] = average;
					}
				}//������� �ٲ��ֱ�.
			}//�׷캰�� �ٲ��ֱ�.
			if(total_end) break;
			ans++;
		}
		System.out.println(ans);
	}//end main.
}
