
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static String notGu = "CEFGHIJKLMNSTUVWXYZ";
	static String Gu = "ADOPQR";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String str1 = sc.next();
			String str2 = sc.next();
			String ans = "";
			// 제일 처음에, 두 문자열 길이가 같으면 diff 출력하고 종료 
			if (str1.length() != str2.length()) {
				ans = "DIFF";
//				System.out.printf("#%d %s\n",tc, ans);
//				break;
			} 
			else {
				
				// 문자들의 유형을 저장할 문자열 배열 두 개 
				String arr1[] = new String[str1.length()];
				String arr2[] = new String[str2.length()];
				
				for (int i = 0; i < str1.length(); i++) {
					// 각 배열의 각 문자들이 구멍 있는 그룹, 없는 그룹, b 중 어디에 속하는지 파악 후 저장 
					String one = String.valueOf(str1.charAt(i));
					if (notGu.contains(one)) {
						arr1[i] = "X";
					} else if (Gu.contains(one)) {
						arr1[i] = "O";
					} else {
						arr1[i] = "B";
					}
				} // str1 체크
				
				for (int i = 0; i < str2.length(); i++) {
					// 각 배열의 각 문자들이 구멍 있는 그룹, 없는 그룹, b 중 어디에 속하는지 파악 후 저장 
					String two = String.valueOf(str2.charAt(i));
					if (notGu.contains(two)) {
						arr2[i] = "X";
					} else if (Gu.contains(two)) {
						arr2[i] = "O";
					} else {
						arr2[i] = "B";
					}
				} // str2 체크
				for (int i = 0; i < arr1.length; i++) {
					// 다른 유형이면 ans 변수를 DIFF으로 저장 후 바로 종료 , 같으면 SAME 으로 저장 
					if (arr1[i] != arr2[i]) {
						ans="DIFF";
						break;
					}
					else {
						ans="SAME";
					}
				}// arr1과 arr2 비교 
			}
			System.out.printf("#%d %s\n",tc, ans);
		}//tc
		sc.close();
	}//main
}
