
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// M(109)까지는 그대로 가능, N부터는 13 더해줘야함.
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String S = sc.nextLine();
		for (int i = 0; i < S.length(); i++) {
			char temp = S.charAt(i);
			if ((temp >= 97 && temp < 110) || (temp >= 65 && temp < 78)) {
				sb.append((char) (temp + 13));
			} else if ((temp >= 110 && temp <= 122) || (temp >= 78 && temp <= 90)) {
				sb.append((char) (temp - 13));
			} else {
				sb.append(temp);
			}
		}
		System.out.println(sb.toString());
	}
}
