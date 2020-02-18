import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_소수완제품확률 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int TC = Integer.parseInt(st.nextToken());
		for(int test=1; test<=TC; test++) {
			st = new StringTokenizer(br.readLine());
			double p1 = Double.parseDouble(st.nextToken())/100;
			double p2 = Double.parseDouble(st.nextToken())/100;
			double total_p1 =0;
			double total_p2 =0;
			double inter_p = 0;
			total_p1 += probablity(p1,2);
			total_p1 += probablity(p1,3);
			total_p1 += probablity(p1,5);
			total_p1 += probablity(p1,7);
			total_p1 += probablity(p1,11);
			total_p1 += probablity(p1,13);
			total_p1 += probablity(p1,17);
			
			total_p2 += probablity(p2,2);
			total_p2 += probablity(p2,3);
			total_p2 += probablity(p2,5);
			total_p2 += probablity(p2,7);
			total_p2 += probablity(p2,11);
			total_p2 += probablity(p2,13);
			total_p2 += probablity(p2,17);

			System.out.printf("#%d %.06f" , test, total_p1 + total_p2 - (total_p1 * total_p2));
			System.out.println("");
		}
	}//end main.
	public static double probablity(double p , int cnt) {
		double ans = Math.pow(p, cnt) * Math.pow(1-p, 18-cnt) * comb(18,cnt);
		return ans;
	}
	public static int comb(int n, int r) {
		if(r > 9) r = 18-r;
		int ans =1;
		for(int i=0; i<r; i++) {
			ans *= (18-i);
		}
		for(int i=1; i<=r; i++) {
			ans /= i;
		}
		return ans;
	}
}
