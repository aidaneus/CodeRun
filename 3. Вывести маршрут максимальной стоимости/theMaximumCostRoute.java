import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class theMaximumCostRoute {

    static ArrayList<String> direct(String[][] direction, int i, int j) {
        ArrayList<String> path = new ArrayList<>();

        while (i > 0 || j > 0) {
            path.addFirst(direction[i][j]);
            if (direction[i][j].equals("D")) {
                i--;
            } else {
                j--;
            }
        }
        return path;
    }

    public static void main(String[] args) {
        int n = 0, m = 0;
        int[][] matrix = new int[0][0];

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] line = reader.readLine().split(" ");
            n = Integer.parseInt(line[0]);
            m = Integer.parseInt(line[1]);
            matrix = new int[n][m];

            for (int i = 0; i < n; i++) {
                String[] nums = reader.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(nums[j]);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Ошибка чтения: " + e);
        }

        String[][] direction = new String[n][m];

        for (int i = 1; i < n; i++) {
            matrix[i][0] += matrix[i - 1][0];
            direction[i][0] = "D";
        }

        for (int j = 1; j < m; j++) {
            matrix[0][j] += matrix[0][j - 1];
            direction[0][j] = "R";
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int top = matrix[i - 1][j];
                int left = matrix[i][j - 1];
                if (top > left) {
                    matrix[i][j] += top;
                    direction[i][j] = "D";
                } else {
                    matrix[i][j] += left;
                    direction[i][j] = "R";
                }
            }
        }
        ArrayList<String> path;
        path = direct(direction, n - 1, m - 1);
        System.out.println(matrix[n - 1][m - 1]);
        for (String word : path) {
            System.out.print(word + " ");
        }
    }
}
