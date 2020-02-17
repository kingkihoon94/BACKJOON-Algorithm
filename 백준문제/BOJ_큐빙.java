import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_큐빙 {
	static int[][][] cube = new int[6][3][3];
	static int[] temp = new int[3];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int TC = Integer.parseInt(st.nextToken());
		for(int test=1; test<=TC ; test++) {
			for(int i=0; i<6; i++) {
				for(int j=0; j<3; j++) {
					for(int k=0; k<3; k++) {
						cube[i][j][k] = i;
					}
				}
			}//cube initialize. 0: white , 1: green , 2: red , 3: blue , 4: yellow , 5:orange.
			st = new StringTokenizer(br.readLine());
			int inst = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int in=0; in<inst; in++) {
				start(st.nextToken());
			}//명령어 실행하기.
			for(int i=0; i<3; i++) {
				for (int j=0; j<3; j++) {
					switch(cube[0][i][j]) {
					case 0:System.out.print('w');break;
					case 1:System.out.print('g');break;
					case 2:System.out.print('r');break;
					case 3:System.out.print('b');break;
					case 4:System.out.print('y');break;
					case 5:System.out.print('o');break;
					}
				}
				System.out.println("");
			}
		}//end testCase.
	}//end main.
	public static void start(String str) {
		switch(str.charAt(0)) { //무슨 면 돌릴지 정하기.
		case 'U':{
			if(str.charAt(1) == '+') {
				rotate(0,0);
				for(int i=0; i<3; i++) {
					temp[i] = cube[1][0][i];
				} //그린 --> temp.
				for(int i=0; i<3; i++) {
					cube[1][0][i] = cube[2][0][i];
				} //레드 --> 그린
				for(int i=0; i<3; i++) {
					cube[2][0][i] = cube[3][0][i];
				} //블루 --> 레드
				for(int i=0; i<3; i++) {
					cube[3][0][i] = cube[5][2][2-i];
				} //오렌지 --> 블루
				for(int i=0; i<3; i++) {
					cube[5][2][2-i] = temp[i];
				} //temp --> 오렌지
			}
			else {
				rotate(0,1);
				for(int i=0; i<3; i++) {
					temp[i] = cube[1][0][i];
				} //그린 --> temp.
				for(int i=0; i<3; i++) {
					cube[1][0][i] = cube[5][2][2-i];
				} //오렌지 --> 그린
				for(int i=0; i<3; i++) {
					cube[5][2][2-i] = cube[3][0][i];
				} //블루 --> 오렌지
				for(int i=0; i<3; i++) {
					cube[3][0][i] = cube[2][0][i];
				} //레드 --> 블루
				for(int i=0; i<3; i++) {
					cube[2][0][i] = temp[i];
				} //레드 --> temp.
			}
			break;
		}
		case 'L':{
			if(str.charAt(1) == '+') {
				rotate(1,0);
				for(int i=0; i<3; i++) {
					temp[i] = cube[5][i][0];
				} //오렌지 --> temp.
				for(int i=0; i<3; i++) {
					cube[5][i][0] = cube[4][i][0];
				} //옐로우 --> 오렌지
				for(int i=0; i<3; i++) {
					cube[4][i][0] = cube[2][i][0];
				} //레드 --> 옐로우
				for(int i=0; i<3; i++) {
					cube[2][i][0] = cube[0][i][0];
				} //화이트 --> 레드
				for(int i=0; i<3; i++) {
					cube[0][i][0] = temp[i];
				} //temp --> 화이트
			}
			else {
				rotate(1,1);
				for(int i=0; i<3; i++) {
					temp[i] = cube[0][i][0];
				} //화이트 --> temp.
				for(int i=0; i<3; i++) {
					cube[0][i][0] = cube[2][i][0];
				} //레드 --> 화이트
				for(int i=0; i<3; i++) {
					cube[2][i][0] = cube[4][i][0];
				} //옐로우 --> 레드
				for(int i=0; i<3; i++) {
					cube[4][i][0] = cube[5][i][0];
				} //오렌지 --> 옐로우
				for(int i=0; i<3; i++) {
					cube[5][i][0] = temp[i];
				} //temp --> 오렌지
			}
			break;
		}
		case 'F':{
			if(str.charAt(1) == '+') {
				rotate(2,0);
				for(int i=0; i<3; i++) {
					temp[i] = cube[4][0][i];
				} //옐로우 --> temp
				for(int i=0; i<3; i++) {
					cube[4][0][i] = cube[3][2-i][0];
				} //블루 --> 옐로우
				for(int i=0; i<3; i++) {
					cube[3][2-i][0] = cube[0][2][2-i];
				} //화이트 --> 블루
				for(int i=0; i<3; i++) {
					cube[0][2][2-i] = cube[1][i][2];
				} //그린 --> 화이트
				for(int i=0; i<3; i++) {
					cube[1][i][2] = temp[i];
				} //temp --> 그린
			}
			else {
				rotate(2,1);
				for(int i=0; i<3; i++) {
					temp[i] = cube[1][i][2];
				} //그린 --> temp
				for(int i=0; i<3; i++) {
					cube[1][i][2] = cube[0][2][2-i];
				} //화이트 --> 그린
				for(int i=0; i<3; i++) {
					cube[0][2][2-i] = cube[3][2-i][0];
				} //블루 --> 화이트
				for(int i=0; i<3; i++) {
					cube[3][2-i][0] = cube[4][0][i];
				} //옐로우 --> 블루
				for(int i=0; i<3; i++) {
					cube[4][0][i] = temp[i];
				} //temp --> 옐로우
			}
			break;
		}
		case 'R':{
			if(str.charAt(1) == '+') {
				rotate(3,0);
				for(int i=0; i<3; i++) {
					temp[i] = cube[0][i][2];
				} //화이트 --> temp.
				for(int i=0; i<3; i++) {
					cube[0][i][2] = cube[2][i][2];
				} //레드 --> 화이트
				for(int i=0; i<3; i++) {
					cube[2][i][2] = cube[4][i][2];
				} //옐로우 --> 레드
				for(int i=0; i<3; i++) {
					cube[4][i][2] = cube[5][i][2];
				} //오렌지 --> 옐로우
				for(int i=0; i<3; i++) {
					cube[5][i][2] = temp[i];
				} //temp --> 오렌지
			}
			else {
				rotate(3,1);
				for(int i=0; i<3; i++) {
					temp[i] = cube[5][i][2];
				} //오렌지 --> temp.
				for(int i=0; i<3; i++) {
					cube[5][i][2] = cube[4][i][2];
				} //옐로우 --> 오렌지
				for(int i=0; i<3; i++) {
					cube[4][i][2] = cube[2][i][2];
				} //레드 --> 옐로우
				for(int i=0; i<3; i++) {
					cube[2][i][2] = cube[0][i][2];
				} //화이트 --> 레드
				for(int i=0; i<3; i++) {
					cube[0][i][2] = temp[i];
				} //temp --> 화이트
			}
			break;
		}
//		case 'D':{
//			if(str.charAt(1) == '+') {
//				rotate(4,0);
//			}
//			else {
//				rotate(4,1);
//			}
//			break;
//		}
//		case 'B':{
//			if(str.charAt(1) == '+') {
//				rotate(5,0);
//			}
//			else {
//				rotate(5,1);
//			}
//			break;
//		}
		}//end switch.
	}//end start.
	public static void rotate(int num, int direct) {
		if(direct == 1) { // - 방향 (반시계 방향).
			for(int i=0; i<2; i++) {
				temp[i] = cube[num][0][i];
			}
			cube[num][0][0] = cube[num][0][2];
			cube[num][0][1] = cube[num][1][2];
			cube[num][0][2] = cube[num][2][2];
			cube[num][1][2] = cube[num][2][1];
			cube[num][2][2] = cube[num][2][0];
			cube[num][2][1] = cube[num][1][0];
			cube[num][2][0] = temp[0];
			cube[num][1][0] = temp[1];
		}
		else { // + 방향 (시계 방향).
			for(int i=0; i<2; i++) {
				temp[i] = cube[num][0][i];
			}
			cube[num][0][1] = cube[num][1][0];
			cube[num][0][0] = cube[num][2][0];
			cube[num][1][0] = cube[num][2][1];
			cube[num][2][0] = cube[num][2][2];
			cube[num][2][1] = cube[num][1][2];
			cube[num][2][2] = cube[num][0][2];
			cube[num][1][2] = temp[1];
			cube[num][0][2] = temp[0];
		}
	}//end rotate.
}//end class.
