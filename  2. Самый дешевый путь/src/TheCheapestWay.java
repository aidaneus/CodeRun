import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

class TheCheapestWay {
    public static void main(String [] args) {
        int n = 0, m = 0;
        int [][] matrix = new int[0][0];

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String [] line = reader.readLine().split(" ");
            if (line.length > 2) {
                System.out.println("Введено больше 2 чисел");
                return;
            }
            n = Integer.parseInt(line[0]);
            m = Integer.parseInt(line[1]);

            matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String [] nums = reader.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(nums[j]);
                }
            }
            System.out.println(Arrays.deepToString(matrix));
        } catch (IOException e) {
            System.err.println("Ошибка чтения: " + e);
        }

        for (int i = 1; i < n; i++) {
            matrix[i][0] += matrix[i - 1][0];
        }

        for (int j = 1; j < m; j++) {
            matrix[0][j] += matrix[0][j - 1];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1;j < m; j++) {
                matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i][j - 1]);
            }
        }
        System.out.println(matrix[n - 1][m - 1]);
    }
}
