
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		String[] arr = new String[S.length()];
		for (int i = 0; i < S.length(); i++) {
			String temp = S.substring(i, S.length());
			arr[i] = temp;
		}
		Arrays.sort(arr);
		for (int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}
