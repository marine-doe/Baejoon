import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] map = new int[101][101];
	static int[][] dragon;
	static int result = 0;
	static int x, y, d, generation; // 좌표, 방향, 세대

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dragon = new int[n][4];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				dragon[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			summonDragon(i);
		}
		checkSqr();

		System.out.println(result);
	}

	private static void checkSqr() {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j] == 1 && map[i + 1][j + 1] == 1) {
					result++;
				}
			}
		}
	}

	private static void summonDragon(int i) {
		x = dragon[i][0];
		y = dragon[i][1];
		d = dragon[i][2];
		generation = dragon[i][3];
		map[x][y] = 1;
		dragonCurve(generation);
	}

	private static void dragonCurve(int g) {
		int cnt = (int) Math.pow(2, g);
		List<Integer> list = new ArrayList<>();
		list.add(d);
		for (int i = 0; i < g; i++) {
			int size = list.size();
			for (int j = size - 1; j >= 0; j--) {
				list.add(list.get(j) + 1);
			}
		}
		int idx = 0;
		while (idx < cnt) {
			switch (list.get(idx++) % 4) {
			case 0:
				map[++x][y] = 1;
				break;
			case 1:
				map[x][--y] = 1;
				break;
			case 2:
				map[--x][y] = 1;
				break;
			case 3:
				map[x][++y] = 1;
				break;
			}
		}
	}
}