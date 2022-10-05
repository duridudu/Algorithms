
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> level = new HashMap<>();
		int N = sc.nextInt();
		String[] arr = new String[N];
		
		level.put("B", sc.nextInt());
		level.put("S", sc.nextInt());
		level.put("G", sc.nextInt());
		level.put("P", sc.nextInt());
		
		String temp = sc.next();
		for (int i = 0; i < N; i++) {
			arr[i] = temp.substring(i, i + 1);
		}
//		System.out.println(Arrays.toString(arr));
		int res = 0;
		int last = 0;
		for (int i = 0; i < N; i++) {
			String now = arr[i];
			int nowMoney = 0;
			if (now.equals("D")) {
				nowMoney=level.get("P");
				res += nowMoney;
			}
			else {
				nowMoney = level.get(now) - 1 - last;
				res += nowMoney;
				last = nowMoney;				
			}
//			System.out.print(nowMoney+" ");
		}
		System.out.println(res);
	}
}
