import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[3];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        System.out.println(nums[1]);
    }
}