
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			String str = String.valueOf(i);
			int check = 0;
			for (int j = 0; j < str.length(); j++) {
				int num = str.charAt(j) - '0';
				if (num == 3 || num == 6 || num == 9) {
//					System.out.print('-');
					check += 1;
				}
//				if (j==str.length()-1 && i!=N) {
//					System.out.print(" ");
//				}
			}
			if (check == str.length()) {
				for (int k = 0; k < check; k++) {
					System.out.print('-');
				}
			}
			else if (check>=1) {
				System.out.print('-');
			}
			else {
				System.out.print(str);
			}
			System.out.print(" ");
		} // N까지 출력
	}
}
