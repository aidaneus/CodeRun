import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KnightsMove {
    public static void main(String[] args) throws IOException {
        int n, m;
        int[][] matrix;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);

        matrix = new int[n][m];
        matrix[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i + 1 < n && j + 2 < m) {
                    matrix[i + 1][j + 2] += matrix[i][j];
                }
                if (i + 2 < n && j + 1 < m) {
                    matrix[i + 2][j + 1] += matrix[i][j];
                }
            }
        }
        System.out.println(matrix[n - 1][m - 1]);
    }
}
