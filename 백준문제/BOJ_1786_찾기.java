import java.io.*;
import java.util.*;

public class BOJ_1786_찾기 {
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
					sb.append(i-j+1).append("\n");//현재 인덱스에서 - j(b-1길이만큼뺸거) 근데 1번쨰문제는 0번쨰 인덱스라서 +1.
					j = pi[j];
				}
				else j++;
			}
		}
		System.out.println(cnt);
		System.out.print(sb);
	}//end main.
}//end class.
