package algorithm;

import java.io.*;

public class NEW_BOJ_16637_괄호추가하기 {
	static int[] operand = new int[10]; //최대 숫자 10개.
	static char[] operator = new char[9];
	static int N;
	static int answer = Integer.MIN_VALUE; //answer.
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //입력사이즈 받기.
		String equation = br.readLine();
		for(int i=0; i<N; i++) {
			if(i%2==0) operand[i/2] = equation.charAt(i) -'0';
			else operator[i/2] = equation.charAt(i);
		}//End Input.
		dfs(0,operand[0]); //재귀 시작. 파라미터 : (현재 idx, 현재까지 총합).
		System.out.println(answer);
	}//End Class.
	
	static void dfs(int idx, int sum) {
		if(idx == N/2) {
			answer = answer < sum ? sum : answer;
			return ;
		}//끝나는 경우 처리.
		dfs(idx+1 , calculate(sum, operand[idx+1], operator[idx])); //왼쪽부터 계산하는 경우. 1칸 뛰는것 처리.
		if(idx+1 < N/2) {
			int right_num = calculate(operand[idx+1] , operand[idx+2], operator[idx+1]);
			dfs(idx+2 , calculate(sum,right_num,operator[idx]));
		}//괄호로 인해 오른쪽부터 계산하는 경우. 2칸 뛰는것 처리.
	}//End dfs.
	
	static int calculate(int num1, int num2, char operator) {
		if(operator == '+') return num1 + num2;
		else if(operator == '-') return num1 - num2;
		else return num1 * num2;
	}//End calculate.
	
}//End Class.
