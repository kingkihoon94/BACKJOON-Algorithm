import java.io.*;
import java.util.*;

public class SWEA_6782_���ְ������ϴ������ٳ��� {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int test=1; test<=TC; test++) {
			long N = Long.parseLong(br.readLine());
			long answer = 0;
			while(N != 2) {
				double temp = Math.sqrt(N); //�ϴ� ������ ����.
				long target = (long)Math.pow((long)Math.ceil(temp), 2);
				answer += (target - N) + 1;
				N = (long)Math.sqrt(target);
			}
			sb.append("#").append(test).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
	}//end main.
}//end class.
