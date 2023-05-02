import java.util.Scanner;

public class Main {
	static StringBuilder sb;
	static String ts;
	static boolean[] isBroken;
	static int[] buttons;
	static int target, result = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		target = sc.nextInt();

		int broken = sc.nextInt(); // 고장난 버튼 수
		buttons = new int[10];
		isBroken = new boolean[10];
		for (int i = 0; i < 10; i++) {
			buttons[i] = i;
		}

		for (int i = 0; i < broken; i++) {
			int button = sc.nextInt();
			isBroken[button] = true; // 고장난 버튼을 표시하자
		}

		int diff = Math.abs(target - 100);
		result = diff;
		
		if (diff > 2) {
			ts = String.valueOf(target);
			dfs(0, "");
		}
		
		System.out.println(result);
	}

	private static void dfs(int depth, String num) {
		if(depth != 0) {
			int best = Integer.parseInt(num);
			result = Math.min(result, Math.abs(best - target) + num.length());
		}
		
		if(depth == ts.length() + 1) {
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			if(!isBroken[i]) dfs(depth + 1, num + i);
		}
	}
}