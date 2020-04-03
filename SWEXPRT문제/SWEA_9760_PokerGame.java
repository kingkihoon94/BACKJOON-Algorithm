import java.io.*;
import java.util.*;;

public class SWEA_9760_PokerGame {
	static char[] type;
	static char[] num;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
        for (int test = 1; test <= TC; test++) {
        	type = new char[5];
        	num = new char[13];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 5; i++) {
                String tmp_str = st.nextToken();
                switch (tmp_str.charAt(0)){
                case 'S':
                    type[0]++;
                    break;
                case 'D':
                    type[1]++;
                    break;
                case 'H':
                    type[2]++;
                    break;
                case 'C':
                    type[3]++;
                    break;
                }
                switch (tmp_str.charAt(1)){
                case 'A':
                    num[0]++;
                    break;
                case '2':
                	num[1]++;
                	break;
                case '3':
                	num[2]++;
                	break;
                case '4':
                	num[3]++;
                	break;
                case '5':
                	num[4]++;
                	break;
                case '6':
                	num[5]++;
                	break;
                case '7':
                	num[6]++;
                	break;
                case '8':
                	num[7]++;
                	break;
                case '9':
                	num[8]++;
                	break;
                case 'T':
                	num[9]++;
                	break;
                case 'J':
                	num[10]++;
                	break;
                case 'Q':
                    num[11]++;
                	break;
                case 'K':
                	num[12]++;
                	break;
                }
            }//end input.
            String answer = start();
            sb.append("#").append(test).append(" ").append(answer).append("\n");
        }//end testCase.
        System.out.print(sb);
	}//end main.
	public static String start() {
		int pair=0;
		boolean Straight = false;
		boolean Flush = false;
		boolean Triple = false;
		boolean FourCard = false;

        for (int i=0; i<4; i++){ //플러쉬.
            if (type[i] == 5)  Flush = true;
        }
        for (int i=0; i<13; i++){ //포카드, 트리플, 페어.
            if(num[i] == 4) FourCard = true;
            else if(num[i] == 3) Triple = true;
            else if(num[i] ==2) pair++;
        }
        if (pair == 0 && !Triple && !FourCard){ //스트레이트. 가지치기를 좀더 한다. 페어거나 트리플이거나 포카드면 스트레이트 비교안해도된
            int n = 0;
            for (int i = 0; i<9; i++){
                if (num[i] == 1){
                    n=1;
                    for (int j=i+1; j<i+5; j++){
                        if (num[j] == 1){
                            n++;
                        }
                    }
                    if(n == 5) {
                    	Straight = true;
                    	break;
                    }
                }
            }
            if(num[0] == 1){//로얄스트레이트.
                n=0;
                for (int i=9; i<13; i++){
                    if (num[i] == 1){
                        n++;
                    }
                }
                if(n==4) Straight = true; //TJQK 있음
            }
        }
        if (Flush && Straight)  return "Straight Flush";
        if (FourCard) return "Four of a Kind";
        if (Triple && pair==1)    return "Full House";
        if (Flush)    return "Flush";
        if (Straight) return "Straight";
        if (Triple)   return "Three of a kind";
        if (pair == 2)  return "Two pair";
        if (pair == 1)  return "One pair";
        return "High card";
	}//end start.
}//end class.
