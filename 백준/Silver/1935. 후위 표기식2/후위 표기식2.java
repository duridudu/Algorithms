
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack <Double> st = new Stack<>();
		int N = sc.nextInt();
		String S = sc.next();
//		ArrayList<Character> arrlst = new ArrayList<>();
		double [] arr = new double [N];
		
		for (int i = 0; i < N; i++) {
			arr[i] =  sc.nextInt();
		}
		
		for (int i=0;i<S.length();i++) {
			if (Character.isAlphabetic(S.charAt(i))) {
				// 바로 인덱스 활용 가능 !!!!!!!!!!!!! 
				st.push(arr[S.charAt(i)-'A']);
			}else {
				if (st.size()!=1) {
					Double second = st.pop();
					Double first = st.pop();
					if (S.charAt(i) =='+') {
						st.push(first+second);
					}
					else if(S.charAt(i)=='-') {
						st.push(first-second);
					}
					else if(S.charAt(i)=='*') {
						st.push( first*second);
					}
					else {
						st.push(first/second);
					}
				}
			}
		}
		System.out.println(String.format("%.2f", st.peek()));
		
	}
}
