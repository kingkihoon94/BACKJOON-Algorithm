import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_ť�� {
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
			}//��ɾ� �����ϱ�.
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
		switch(str.charAt(0)) { //���� �� ������ ���ϱ�.
		case 'U':{
			if(str.charAt(1) == '+') {
				rotate(0,0);
				for(int i=0; i<3; i++) {
					temp[i] = cube[1][0][i];
				} //�׸� --> temp.
				for(int i=0; i<3; i++) {
					cube[1][0][i] = cube[2][0][i];
				} //���� --> �׸�
				for(int i=0; i<3; i++) {
					cube[2][0][i] = cube[3][0][i];
				} //��� --> ����
				for(int i=0; i<3; i++) {
					cube[3][0][i] = cube[5][2][2-i];
				} //������ --> ���
				for(int i=0; i<3; i++) {
					cube[5][2][2-i] = temp[i];
				} //temp --> ������
			}
			else {
				rotate(0,1);
				for(int i=0; i<3; i++) {
					temp[i] = cube[1][0][i];
				} //�׸� --> temp.
				for(int i=0; i<3; i++) {
					cube[1][0][i] = cube[5][2][2-i];
				} //������ --> �׸�
				for(int i=0; i<3; i++) {
					cube[5][2][2-i] = cube[3][0][i];
				} //��� --> ������
				for(int i=0; i<3; i++) {
					cube[3][0][i] = cube[2][0][i];
				} //���� --> ���
				for(int i=0; i<3; i++) {
					cube[2][0][i] = temp[i];
				} //���� --> temp.
			}
			break;
		}
		case 'L':{
			if(str.charAt(1) == '+') {
				rotate(1,0);
				for(int i=0; i<3; i++) {
					temp[i] = cube[5][i][0];
				} //������ --> temp.
				for(int i=0; i<3; i++) {
					cube[5][i][0] = cube[4][i][0];
				} //���ο� --> ������
				for(int i=0; i<3; i++) {
					cube[4][i][0] = cube[2][i][0];
				} //���� --> ���ο�
				for(int i=0; i<3; i++) {
					cube[2][i][0] = cube[0][i][0];
				} //ȭ��Ʈ --> ����
				for(int i=0; i<3; i++) {
					cube[0][i][0] = temp[i];
				} //temp --> ȭ��Ʈ
			}
			else {
				rotate(1,1);
				for(int i=0; i<3; i++) {
					temp[i] = cube[0][i][0];
				} //ȭ��Ʈ --> temp.
				for(int i=0; i<3; i++) {
					cube[0][i][0] = cube[2][i][0];
				} //���� --> ȭ��Ʈ
				for(int i=0; i<3; i++) {
					cube[2][i][0] = cube[4][i][0];
				} //���ο� --> ����
				for(int i=0; i<3; i++) {
					cube[4][i][0] = cube[5][i][0];
				} //������ --> ���ο�
				for(int i=0; i<3; i++) {
					cube[5][i][0] = temp[i];
				} //temp --> ������
			}
			break;
		}
		case 'F':{
			if(str.charAt(1) == '+') {
				rotate(2,0);
				for(int i=0; i<3; i++) {
					temp[i] = cube[4][0][i];
				} //���ο� --> temp
				for(int i=0; i<3; i++) {
					cube[4][0][i] = cube[3][2-i][0];
				} //��� --> ���ο�
				for(int i=0; i<3; i++) {
					cube[3][2-i][0] = cube[0][2][2-i];
				} //ȭ��Ʈ --> ���
				for(int i=0; i<3; i++) {
					cube[0][2][2-i] = cube[1][i][2];
				} //�׸� --> ȭ��Ʈ
				for(int i=0; i<3; i++) {
					cube[1][i][2] = temp[i];
				} //temp --> �׸�
			}
			else {
				rotate(2,1);
				for(int i=0; i<3; i++) {
					temp[i] = cube[1][i][2];
				} //�׸� --> temp
				for(int i=0; i<3; i++) {
					cube[1][i][2] = cube[0][2][2-i];
				} //ȭ��Ʈ --> �׸�
				for(int i=0; i<3; i++) {
					cube[0][2][2-i] = cube[3][2-i][0];
				} //��� --> ȭ��Ʈ
				for(int i=0; i<3; i++) {
					cube[3][2-i][0] = cube[4][0][i];
				} //���ο� --> ���
				for(int i=0; i<3; i++) {
					cube[4][0][i] = temp[i];
				} //temp --> ���ο�
			}
			break;
		}
		case 'R':{
			if(str.charAt(1) == '+') {
				rotate(3,0);
				for(int i=0; i<3; i++) {
					temp[i] = cube[0][i][2];
				} //ȭ��Ʈ --> temp.
				for(int i=0; i<3; i++) {
					cube[0][i][2] = cube[2][i][2];
				} //���� --> ȭ��Ʈ
				for(int i=0; i<3; i++) {
					cube[2][i][2] = cube[4][i][2];
				} //���ο� --> ����
				for(int i=0; i<3; i++) {
					cube[4][i][2] = cube[5][i][2];
				} //������ --> ���ο�
				for(int i=0; i<3; i++) {
					cube[5][i][2] = temp[i];
				} //temp --> ������
			}
			else {
				rotate(3,1);
				for(int i=0; i<3; i++) {
					temp[i] = cube[5][i][2];
				} //������ --> temp.
				for(int i=0; i<3; i++) {
					cube[5][i][2] = cube[4][i][2];
				} //���ο� --> ������
				for(int i=0; i<3; i++) {
					cube[4][i][2] = cube[2][i][2];
				} //���� --> ���ο�
				for(int i=0; i<3; i++) {
					cube[2][i][2] = cube[0][i][2];
				} //ȭ��Ʈ --> ����
				for(int i=0; i<3; i++) {
					cube[0][i][2] = temp[i];
				} //temp --> ȭ��Ʈ
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
		if(direct == 1) { // - ���� (�ݽð� ����).
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
		else { // + ���� (�ð� ����).
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
