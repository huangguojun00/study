package leecode.queue;

/**
 * @Author Huang Guojun
 * @Date 2019/5/24
 * @Discription 岛屿的数量2   前一版写错了  看错了题
 */
public class IsLandNumberTwo {
    public static void main(String[] args) {
        char[][] chars = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        int i = numIslands(chars);
        System.out.println(i);
    }

    public static int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    toZero(grid, i, j, rows, cols);
                }
            }
        }
        return res;
    }

    private static void toZero(char[][] grid, int i, int j, int rows, int cols) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return;
        }
        if (grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        toZero(grid, i + 1, j, rows, cols);
        toZero(grid, i - 1, j, rows, cols);
        toZero(grid, i, j + 1, rows, cols);
        toZero(grid, i, j - 1, rows, cols);
    }
}


