import java.util.Scanner;

public class BOJ_인터프리터 {
	static int[] arr = new int[100001];
	static char[] code = new char[4097];
	static char[] input = new char[4097];
	static int[] pair = new int[4097];
	static int[] stack = new int[4097];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int testcase = 0; testcase < TC ; testcase++) {
			int arr_length = sc.nextInt();
			int code_length = sc.nextInt();
			int input_length = sc.nextInt();
			int flag = -1;
			for(int i=0; i<arr_length; i++) {
				arr[i] = 0;
			}//테스트 케이스별 초기화.
			String temp_str = sc.next();
			for(int i=0; i<code_length; i++) {
				code[i] = temp_str.charAt(i);
				if(temp_str.charAt(i) == '[') stack[++flag] = i;
				else if(temp_str.charAt(i) == ']') {
					int left = stack[flag--];
					pair[i] = left;
					pair[left] = i;
				}
				else pair[i] = -1;
			}//테스트 케이스별 초기화.
			temp_str = sc.next();
			for(int i=0; i<input_length; i++) {
				input[i] = temp_str.charAt(i);
			}//테스트 케이스별 초기화.
			//////이제 시작해야지.//////
			int pointer = 0;
			int code_idx = 0;
			int input_idx = 0;
			int time = 0; //50만번 돌릴거야.
			boolean end = false;
			int loop_end = 0;
			while(time < 50000000) {
				if(code[code_idx] == '-') {
					arr[pointer]--;
					if(arr[pointer]<0) arr[pointer] = 255;
					code_idx++;
				}
				else if(code[code_idx] == '+') {
					arr[pointer]++;
					if(arr[pointer]>255) arr[pointer] = 0;
					code_idx++;
				}
				else if(code[code_idx] == '<') {
					pointer--;
					if(pointer<0) pointer = arr_length -1;
					code_idx++;
				}
				else if(code[code_idx] == '>') {
					pointer++;
					if(pointer>arr_length-1) pointer = 0;
					code_idx++;
				}
				else if(code[code_idx] == '[') {
					if(arr[pointer] ==0) {
						code_idx = pair[code_idx];
					}
					else code_idx++;
				}
				else if(code[code_idx] == ']') {
					if(arr[pointer] != 0) {
                        if(loop_end < code_idx) loop_end = code_idx;
                        code_idx = pair[code_idx];
                    }else code_idx++;
				}
				else if(code[code_idx] == '.') {
					//System.out.println(arr[pointer]);
					code_idx++;
				}
				else {
					if(input_idx == input_length) {
						arr[pointer] = 255;
					}
					else arr[pointer] = input[input_idx++];
					code_idx++;
				}
				if(code_idx == code_length) {
					end = true;
					break;
				}
				time++;
			}//end while.
			if(end) System.out.println("Terminates");
			else System.out.println("Loops " + pair[loop_end] + " " + loop_end);
		}//end testCase.
	}//end main.
}
