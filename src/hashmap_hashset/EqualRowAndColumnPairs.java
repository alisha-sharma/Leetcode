package hashmap_hashset;

import java.util.Arrays;
import java.util.HashMap;

public class EqualRowAndColumnPairs {
    public static void main(String[] args) {
        int row = 3;
        int col = 3;
        int[][] grid = new int[row][col];
        grid[0][0] = 3;
        grid[0][1] = 2;
        grid[0][2] = 1;
        grid[1][0] = 1;
        grid[1][1] = 7;
        grid[1][2] = 6;
        grid[2][0] = 2;
        grid[2][1] = 7;
        grid[2][2] = 7;

        System.out.println("Number of equal pairs: " + equalPairs(grid));
        System.out.println("Number of equal pairs: " + equalPairsUsingString(grid));
        System.out.println("Number of equal pairs: " + equalPairsUsingHashCode(grid));
    }

    private static int equalPairsUsingHashCode(int[][] grid) {
        int len = grid.length;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int[] row : grid) {
            int hashCode = getHash(row);
            map.put(hashCode, map.getOrDefault(hashCode, 0) + 1);
        }

        for (int i = 0; i < len; i++) {
            int[] col = new int[len];
            for (int j = 0; j < len; j++) {
                col[j] = grid[j][i];
            }

            int hashCode = getHash(col);
            if (map.containsKey(hashCode)) count++;
        }

        return count;
    }

    private static int getHash(int[] row) {
        int result = 1;
        for (int i = 0; i < row.length; i++) {
            result = result * 100003 + row[i];
        }

        return result;
    }

    public static int equalPairs(int[][] grid) {
        int len = grid.length;
        int count = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                sb.append(grid[i][j]);
                sb.append(".");
            }

            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);

        }

        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                sb.append(grid[j][i]);
                sb.append(".");
            }

            if (map.containsKey(sb.toString())) count += map.get(sb.toString());
        }

        return count;
    }

    public static int equalPairsUsingString(int[][] grid) {
        int len = grid.length;
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;

        for (int[] row : grid) {
            String rowStr = Arrays.toString(row);
            map.put(rowStr, map.getOrDefault(rowStr, 0) + 1);
        }

        for (int i = 0; i < len; i++) {
            int[] col = new int[len];
            for (int j = 0; j < len; j++) {
                col[j] = grid[j][i];
            }
            String colStr = Arrays.toString(col);
            if (map.containsKey(colStr)) count += map.get(colStr);
        }

        return count;
    }

}
