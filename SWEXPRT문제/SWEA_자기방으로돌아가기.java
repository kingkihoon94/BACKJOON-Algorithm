import java.util.Scanner;

public class SWEA_자기방으로돌아가기 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 1; t<=test;t++) {
            int n = sc.nextInt();
            int rooms[] = new int[201];
            int max = 0;
            for(int i = 0; i < n; i++) {
                int room1 = sc.nextInt();
                int room2 = sc.nextInt();
                if(room1 > room2) {
                    int temp = room1;
                    room1 = room2;
                    room2 = temp;
                }
                if(room1%2 != 0)room1++;
                if(room2%2 != 0)room2++;
                room1 = room1/2;
                room2 = room2/2;
                for(int move = room1; move<=room2; move++) {
                	rooms[move]++;
                }
            }
            for(int i = 0; i < rooms.length; i++) {
            	max = Math.max(max, rooms[i]);
            }
            System.out.println("#"+t+" "+max);
        }
    }
}
