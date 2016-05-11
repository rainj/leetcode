package algorithms.q0200;

public class Solution002 implements Solution {

	@Override
	public int numIslands(char[][] grid) {
		if (null == grid || 0 == grid.length || grid[0].length == 0) {
			return 0;
		}

		int row = grid.length;
		int column = grid[0].length;
		int result = 0;
		char[][] map = new char[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (grid[i][j] == '1' && map[i][j] != '1') {
					expandIsLand(grid, map, i, j, row, column);
					result++;
				}
			}
		}
		return result;
	}

	private void expandIsLand(char[][] grid, char[][] map, int i, int j, int row, int column) {
		if (i < 0 || j < 0 || i >= row || j >= column)
			return;
		if (grid[i][j] == '1' && map[i][j] != '1') {
			map[i][j] = '1';
			expandIsLand(grid, map, i - 1, j, row, column);
			expandIsLand(grid, map, i, j + 1, row, column);
			expandIsLand(grid, map, i + 1, j, row, column);
			expandIsLand(grid, map, i, j - 1, row, column);
		}
	}

}
