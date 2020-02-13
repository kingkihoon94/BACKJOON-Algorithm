import java.util.Scanner;

public class SWEA_상호의배틀필드 {
	
	static class Tank{
		int x;
		int y;
		char direction;
		public Tank() {
			
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int test=1; test<=TC; test++) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			char map[][] = new char[row][col];
			Tank tank = new Tank();
			String temp_str;
			for(int i=0; i<row; i++) {
				temp_str = sc.next();
				for(int j=0; j<col; j++) {
					map[i][j] = temp_str.charAt(j);
					if(map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v' ) {
						tank.x = i;
						tank.y = j;
						tank.direction = map[i][j];
					}
				}
			}//end map.
			int inst = sc.nextInt(); //명령어 갯수.
			temp_str = sc.next();
			for(int i=0; i<inst; i++) {
				char now = temp_str.charAt(i);
				switch(now) {
				case 'U' : {
					tank.direction = '^';
					map[tank.x][tank.y] = tank.direction;
					if(tank.x-1 >=0 && map[tank.x-1][tank.y] == '.') {
						map[tank.x][tank.y] = '.';
						map[tank.x-1][tank.y] = tank.direction;
						tank.x--;
					}
					break;
				}
				case 'D' : {
					tank.direction = 'v';
					map[tank.x][tank.y] = tank.direction;
					if(tank.x+1 <row && map[tank.x+1][tank.y] == '.') {
						map[tank.x][tank.y] = '.';
						map[tank.x+1][tank.y] = tank.direction;
						tank.x++;
					}
					break;
				}
				case 'L' : {
					tank.direction = '<';
					map[tank.x][tank.y] = tank.direction;
					if(tank.y-1 >=0 && map[tank.x][tank.y-1] == '.') {
						map[tank.x][tank.y] = '.';
						map[tank.x][tank.y-1] = tank.direction;
						tank.y--;
					}
					break;
				}
				case 'R' : {
					tank.direction = '>';
					map[tank.x][tank.y] = tank.direction;
					if(tank.y+1 <col && map[tank.x][tank.y+1] == '.') {
						map[tank.x][tank.y] = '.';
						map[tank.x][tank.y+1] = tank.direction;
						tank.y++;
					}
					break;
				}
				case 'S' : {
					switch(tank.direction) {
					case '^': {
						int temp_x = tank.x-1;
						while(temp_x >= 0) {
							if(map[temp_x][tank.y] == '*') {
								map[temp_x][tank.y] = '.'; 
								break;
							}
							else if(map[temp_x][tank.y] == '#') break;
							temp_x--;
						}
						break;
					}
					case 'v': {
						int temp_x = tank.x+1;
						while(temp_x < row) {
							if(map[temp_x][tank.y] == '*') {
								map[temp_x][tank.y] = '.'; 
								break;
							}
							else if(map[temp_x][tank.y] == '#') break;
							temp_x++;
						}
						break;
					}
					case '<': {
						int temp_y = tank.y-1;
						while(temp_y >= 0) {
							if(map[tank.x][temp_y] == '*') {
								map[tank.x][temp_y] = '.';
								break;
							}
							else if(map[tank.x][temp_y] == '#') break;
							temp_y--;
						}
						break;
					}
					case '>': {
						int temp_y = tank.y+1;
						while(temp_y < col) {
							if(map[tank.x][temp_y] == '*') {
								map[tank.x][temp_y] = '.';
								break;
							}
							else if(map[tank.x][temp_y] == '#') break;
							temp_y++;
						}
						break;
					}
					}
					break;
				}
				}//명령어대로 움직이기.
			}//명령어 만큼 움직이기.
			System.out.print("#" + test + " "); //테스트 몇번인지 출력.
			for(int i=0; i<row; i++) {
				for(int j=0; j<col; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println("");
			}//명령어 다끝나고 맵 출력.
		}//end testCase.
	}//end main.
}//end class.
