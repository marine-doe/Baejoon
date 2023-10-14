import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class active {
	int sec;
	String behave;
}

public class Main {
	static Queue<Integer> xq = new LinkedList<>();
	static Queue<Integer> yq = new LinkedList<>();
	static int[][] map;
	static active[] act;
	static int n, l, result = 0, idx = 0;
	static char status;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		map[0][0] = 2; // 뱀은 2
		xq.offer(0);
		yq.offer(0);
		status = 'r';
		int k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			map[x][y] = 1; // 사과는 1
		}
		l = sc.nextInt();
		act = new active[l];
		for (int i = 0; i < l; i++) {
			active active = new active();
			active.sec = sc.nextInt();
			active.behave = sc.next();
			act[i] = active;
		}

		move(0, 1, 1); // 오른쪽 보면서 start

		System.out.println(result);
	}

	private static void move(int x, int y, int cnt) {
		if (x < 0 || y < 0 || x >= n || y >= n || map[x][y] == 2) {
			result = cnt;
			return;
		}
		xq.offer(x);
		yq.offer(y);
		if (map[x][y] == 1) {
			map[x][y] = 2;
		} else { // 0 일 때
			map[x][y] = 2;
			map[xq.poll()][yq.poll()] = 0;
		}
		if (idx < l && act[idx].sec == cnt) {
			if (act[idx].behave.equals("D")) {
				switch (status) {
				case 'r':
					status = 'd';
					break;
				case 'u':
					status = 'r';
					break;
				case 'l':
					status = 'u';
					break;
				case 'd':
					status = 'l';
					break;
				}
			} else {
				switch (status) {
				case 'r':
					status = 'u';
					break;
				case 'u':
					status = 'l';
					break;
				case 'l':
					status = 'd';
					break;
				case 'd':
					status = 'r';
					break;
				}
			}
			idx++;
		}
		switch (status) {
		case 'r':
			move(x, y + 1, cnt + 1);
			break;
		case 'u':
			move(x - 1, y, cnt + 1);
			break;
		case 'l':
			move(x, y - 1, cnt + 1);
			break;
		case 'd':
			move(x + 1, y, cnt + 1);
			break;
		}
	}
}