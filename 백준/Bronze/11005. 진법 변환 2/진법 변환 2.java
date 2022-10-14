
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int B = sc.nextInt();
		String ans = "";
		int r;
		while (N > 0) {
			// 숫자를 바꿀 진수로 나눈 나머지를 빈 문자열에 저장해여 
			r = N % B;
			// 나머지가 10보다 크면 알파벳으로 처리해줘야대여 
			if (r >= 10) {
				// ans에 나머지-10+
				ans += (char) (r - 10 + (int) 'A');
			} else {
				ans += (char) (r + (int) '0');
			}
			N /= B;
		}

		for (int i = ans.length() - 1; i >= 0; i--) {
			System.out.print(ans.charAt(i));
		}
//		String change = Long.toString(N, B);
//		String temp = "";
//		if (B > 10) {
//			for (int i = 0; i < change.length(); i++) {
//				int tmp = (int) change.charAt(i);
//				if ((97 <= tmp) && (tmp <= 122)) {
//					temp += (char) (tmp - 32);
//				} else {
//					temp += (char) tmp;
//				}
//			}
//		}
//		change = temp;
//		System.out.println(change);
//		sc.close();
	}
}
