import java.io.*;
import java.util.*;

public class BOJ_1786_ã�� {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String a = br.readLine();
		String b = br.readLine();
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] pi = new int[b.length()];
		int j=0;
		for(int i=1; i<b.length(); i++) {
			while(j>0 && b.charAt(i) != b.charAt(j)) j = pi[j-1];
			if(b.charAt(i) == b.charAt(j)) {
				pi[i] = ++j;
			}
		}
		j=0;
		for(int i=0; i<a.length(); i++) {
			while(j>0 && a.charAt(i) != b.charAt(j)) {
				j = pi[j-1];
			}
			if(a.charAt(i) == b.charAt(j)) {
				if(j == b.length()-1) {
					cnt++;
					sb.append(i-j+1).append("\n");//���� �ε������� - j(b-1���̸�ŭ�A��) �ٵ� 1���������� 0���� �ε����� +1.
					j = pi[j];
				}
				else j++;
			}
		}
		System.out.println(cnt);
		System.out.print(sb);
	}//end main.
}//end class.
