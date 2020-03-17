import java.io.*;
import java.util.*;

public class SWEA_3378_��Ÿ�ϸ����鿩���� {
	static int[][] master;
	static int[][] answer;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for(int test=1; test<=TC; test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //������ �� ����.
			M = Integer.parseInt(st.nextToken()); //���� �� ����.
			master = new int[N+1][4]; //0:...���� , 1: �Ұ�ȣ , 2: �߰�ȣ , 3: ���ȣ.
			answer = new int[M+1][4];
			for(int i=0; i<N; i++) {
				String temp = br.readLine();
				int temp_idx = 0;
				while(temp.charAt(temp_idx) == '.'){
					temp_idx++;
				}
				master[i][0] = temp_idx;
				for(int j=temp_idx; j<temp.length(); j++) {
					if(temp.charAt(j) == '(') master[i][1]++;
					else if(temp.charAt(j) == ')') master[i][1]--;
					else if(temp.charAt(j) == '{') master[i][2]++;
					else if(temp.charAt(j) == '}') master[i][2]--;
					else if(temp.charAt(j) == '[') master[i][3]++;
					else if(temp.charAt(j) == ']') master[i][3]--;
				}//��ȣ ����.
				for(int j=1; j<4; j++) {
					master[i+1][j] = master[i][j];
				}//������ �־��ֱ�.
			}//������ �Է� ��.
			for(int i=0; i<M; i++) {
				String temp = br.readLine();
				for(int j=0; j<temp.length(); j++) {
					if(temp.charAt(j) == '(') answer[i][1]++;
					else if(temp.charAt(j) == ')') answer[i][1]--;
					else if(temp.charAt(j) == '{') answer[i][2]++;
					else if(temp.charAt(j) == '}') answer[i][2]--;
					else if(temp.charAt(j) == '[') answer[i][3]++;
					else if(temp.charAt(j) == ']') answer[i][3]--;
				}
				for(int j=1; j<4; j++) {
					answer[i+1][j] = answer[i][j];
				}//������ �־��ֱ�.
			}//�� �Է� ��.
			
			for(int i=1; i<M; i++) {
				answer[i][0] = -2; //�Ⱦ��� ������ �ʱ�ȭ. 0�̶�� ���� ��ȿ�� ���̱� �����̴�.
			}
			
			for(int r=1; r<=20; r++) {
				for(int c=1; c<=20; c++) {
					for(int s=1; s<=20; s++) {
						if(check(r,c,s)) {
							calculate(r,c,s);
						}
					}
				}
			}//�ߺ� �����Դϴ�.
			
			sb.append("#").append(test).append(" ");
			for(int i=0; i<M; i++) {
				sb.append(answer[i][0]).append(" ");
			}
			sb.append("\n"); //���� ���.
		}//end TestCase.
		System.out.print(sb);
	}//end main.
	public static boolean check(int r, int c, int s) {
		for(int i=1; i<N; i++) {
			if(master[i][0] != r*master[i-1][1] + c*master[i-1][2] + s*master[i-1][3])
				return false;
		}
		return true;
	}//end check r c s.
	public static void calculate(int r, int c, int s) {
		for(int i=0; i<M-1; i++) {
			if(answer[i+1][0] != r*answer[i][1] +  c*answer[i][2] + s*answer[i][3] && answer[i+1][0] != -2) {
				answer[i+1][0] = -1;
			}
			else answer[i+1][0] = r*answer[i][1] +  c*answer[i][2] + s*answer[i][3];
		}
	}//end calculate.
}//end class.
