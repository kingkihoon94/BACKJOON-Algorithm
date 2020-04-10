import java.io.*;

public class BOJ_16916_부분문자열 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		int answer = 0;
		int[] pi = new int[b.length()];
		int j=0;
		for(int i=1; i<b.length(); i++) {
			while(j>0 && b.charAt(i) != b.charAt(j)) j = pi[j-1];
			if(b.charAt(i) == b.charAt(j)) pi[i] = ++j;
		}
		j=0;
ex:		for(int i=0; i<a.length(); i++) {
			while(j>0 && a.charAt(i) != b.charAt(j)) j = pi[j-1];
			if(a.charAt(i) == b.charAt(j)) {
				if(j==b.length()-1) {
					answer = 1;
					break ex;
				}
				else j++;
			}
		}
		System.out.println(answer);
	}//end main.
}//end class.
