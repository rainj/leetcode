package algorithms.q0200;

import java.util.LinkedList;
import java.util.Queue;

public class Solution001 implements Solution {

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

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
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(i, j));
		while (queue.size() > 0) {
			Point current = queue.poll();
			int x = current.x - 1;
			int y = current.y;
			if (x >= 0 && grid[x][y] == '1' && map[x][y] != '1') {
				map[x][y] = '1';
				queue.offer(new Point(x, y));
			}

			x = current.x;
			y = current.y + 1;
			if (y < column && grid[x][y] == '1' && map[x][y] != '1') {
				map[x][y] = '1';
				queue.offer(new Point(x, y));
			}

			x = current.x + 1;
			y = current.y;
			if (x < row && grid[x][y] == '1' && map[x][y] != '1') {
				map[x][y] = '1';
				queue.offer(new Point(x, y));
			}

			x = current.x;
			y = current.y - 1;
			if (y >= 0 && grid[x][y] == '1' && map[x][y] != '1') {
				map[x][y] = '1';
				queue.offer(new Point(x, y));
			}
		}
	}

}
