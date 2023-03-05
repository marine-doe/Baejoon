import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int size = 2666800;
		List<Integer> en = new ArrayList<>();
		for (int i = 666; i < size; i++) {
			String temp = String.valueOf(i);
			if(temp.contains("666")) {
				en.add(i);
			}
		}
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt() - 1;
		System.out.println(en.get(n));
	}
}