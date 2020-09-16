package algorithm;

import java.io.*;
import java.util.*;

public class NEW_BOJ_14501_Επ»η {
	static int[] cnt_list;
	static int[] price_list;
	static int N;
	static int max_price = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cnt_list = new int[N];
		price_list = new int[N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			cnt_list[i] = Integer.parseInt(st.nextToken());
			price_list[i] = Integer.parseInt(st.nextToken());
		}//end input.
		start(0,0);
		System.out.println(max_price);
	}//end main.
	public static void start(int cnt, int price) {
		if(cnt == N) {
			max_price = max_price < price ? price : max_price;
			return;
		}
		int next = cnt + cnt_list[cnt];
		if(next > N) start(cnt+1, price);
		else {
			start(next,price+price_list[cnt]);
			start(cnt+1,price);
		}
	}//end start.
}//end class.
