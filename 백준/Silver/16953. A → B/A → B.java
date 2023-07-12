import java.util.Scanner;

public class Main {
    static int target;
    static int B;
    static int result = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        target = sc.nextInt();
        B = sc.nextInt();

        Calc(B, 1);

        System.out.println(result);
    }

    private static void Calc(int num, int depth) {
        if (num == target){
            if (result == -1){
                result = depth;
            }else {
                result = Math.min(result, depth);
            }
            return;
        }

        if (num < target){
            return;
        }

        if(num % 2 == 0){
            Calc(num / 2, depth + 1);
        }else {
            if((num % 10) == 1){
                Calc(num / 10, depth + 1);
            }
            return;
        }
    }
}