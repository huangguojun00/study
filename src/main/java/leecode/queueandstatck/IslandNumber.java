package leecode.queueandstatck;

/**
 * @Author Huang Guojun
 * @Date 2019/5/23
 * @Discription 岛屿的数量
 */
public class IslandNumber {
    public static void main(String[] args) {
        char[][] chars = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        int i = numIslands(chars);
        System.out.println(i);
    }


    public static int numIslands(char[][] grid) {
        int row = grid.length;
        int cols;
        int res = 0;
        int east = 0;
        int west = 0;
        int south = 0;
        int north = 0;
        int numericValue;
        for (int i = 0; i < grid.length; i++) {
            char[] chars = grid[i];
            cols = chars.length;
            for (int j = 0; j < chars.length; j++) {
                char aChar = chars[j];
                numericValue = Character.getNumericValue(aChar);
                if (i - 1 >= 0) {
                    east = Character.getNumericValue(grid[i - 1][j]);
                }
                if (i + 1 < row) {
                    west = Character.getNumericValue(grid[i + 1][j]);
                }
                if (j - 1 >= 0) {
                    north = Character.getNumericValue(grid[i][j - 1]);
                }
                if (j + 1 < cols) {
                    south = Character.getNumericValue(grid[i][j + 1]);
                }
                if (numericValue + east + west + south + north == 1 && numericValue == 1) {
                    System.out.println(String.format("i%d j%d", i, j));
                    res++;
                }
            }

        }
        return res;
    }
}
