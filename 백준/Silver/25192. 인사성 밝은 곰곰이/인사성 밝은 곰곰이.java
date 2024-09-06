import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Set<String> set = new HashSet<>();
        int result = 0;

        for (int i = 0; i < n; i++) {
            int size = set.size();
            String line = sc.next();
            if(line.equals("ENTER")){
                set = new HashSet<>();
            }else{
                set.add(line);
                if(set.size() == size){
                    continue;
                }else{
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
