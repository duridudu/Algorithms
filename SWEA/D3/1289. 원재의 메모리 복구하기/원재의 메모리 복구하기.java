
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			String str = sc.next();
			// 원래 메모리 저장할 배열과, 초기화된 배열 
			int[] orgn = new int[str.length()];
			int[] zeros = new int[orgn.length];
			int cnt =0;
			for (int i=0;i<str.length();i++) {
				orgn[i]=Character.getNumericValue(str.charAt(i));
			} // 원래 메모리 저장 완료 
			
			for (int i=0; i<orgn.length;i++) {
				// 원본과 초기화된 원소가 같으면 넘기고
				if (zeros[i]==(orgn[i])) {
					continue;
				}
				// 다르면 바꿔줘야함
				else {
					change(zeros, i, orgn[i]);
					cnt+=1;
				}
			}
			System.out.printf("#%d %d\n", tc,cnt );
		}//TC
		sc.close();
	}// main

	private static void change(int[] zeros, int idx, int num) {
		// 해당 인덱스부터 끝까지 원본 요소랑 같은 값으로 바꾼다.
		for (int i = idx; i < zeros.length; i++) {
			zeros[i] = num;
		}
	}
}
