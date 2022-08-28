
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int speed = 0;
			int dist = 0;
			int change = 0;
			for (int i = 0; i < N; i++) {
				int cmd = sc.nextInt();
				if (cmd != 0) {
					change = sc.nextInt();
				}
				
				switch (cmd) {
				case 0:
					dist+=speed;
					break;
				case 1:
					speed += change;
					dist += speed;
					break;
				case 2:
					if (speed < change) {
						speed = 0;
					} else {
						speed -= change;
					}
					dist+=speed;
					break;
				}
			} // Ns
			System.out.println("#"+tc+" "+dist);
		} // tc
		sc.close();
	}// main
}
