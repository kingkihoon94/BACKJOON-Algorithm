import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_Àü±¸ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int color = sc.nextInt();
		ArrayList<Integer> list = new ArrayList();
		for(int i=0; i<length; i++) {
			list.add(sc.nextInt());
		}
		start(list , 0);
	}
	public static void start(ArrayList<Integer> list,  int cnt) {
		ArrayList<Integer> temp_list = new ArrayList();
		for(int i=0; i<list.size()-1; i++) {
			if(list.get(i) != list.get(i+1)){
				temp_list.add(list.get(i));
			}
		}
		temp_list.add(list.get(list.size()-1));
		if(temp_list.size() == 1) {
			System.out.println(cnt);
			return ;
		}
		int min = 100;
		int delete = 0;
		for(int i=0; i<temp_list.size(); i++) {
			int temp_color = temp_list.get(i);
			for(int j=i+1; j<temp_list.size(); j++) {
				if(temp_list.get(j) == temp_color) {
					if(j-i < min) {
						min = j-i;
						delete = (i+j)/2;
					}
				}
			}
		}
		temp_list.remove(delete);
		start(temp_list, cnt+1);
	}
}
