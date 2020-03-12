import java.io.*;
import java.util.*;

public class SWEA_7701_¿°¶ó´ë¿ÕÀÇÀÌ¸§Á¤·Ä {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int test=1; test<=TC; test++) {
			int N = Integer.parseInt(br.readLine());
			HashSet<String> hash = new HashSet<>();
			for(int i=0; i<N; i++) {
				hash.add(br.readLine());
			}
			String[] list = Arrays.copyOf(hash.toArray(), hash.size(), String[].class);
			Arrays.sort(list, new Comparator<String>() {
				@Override
				public int compare(String s1, String s2) {
					if(s1.length() == s2.length()) {
						return s1.compareTo(s2);
					}
					return s1.length() - s2.length();
				}
			});
			sb.append("#").append(test).append("\n");
			
			for(String s: list) {
				sb.append(s).append("\n");
			}
		}//end testCase.
		System.out.print(sb);
	}//end main.
}//end class.