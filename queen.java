package apcs;

public class Queen {
	
	public static int n_queen(int row, int col, int avail) {
		
		int [][] grid = new int[6][6];
		
		grid[row][col] = 1;
		
		
		for(int i = 1; i <= avail; i++) {
			for(int j = 1; j <= avail; j++) {
				if ((row + i) <= 5) {
					grid[row + i][col] = 1;
					if ((col + i) <= 5) {
						grid[row + i][col + i] = 1;
					}
					if ((col - i) >= 1) {
						grid[row + i][col - i] = 1;
					}
				}
				if ((col + i) <= 5) {
					grid[row][col+ i] = 1;
					if ((row - i) >= 1) {
						grid[row - i][col + i] = 1;
					}
				}
				if ((row - i) >= 1) {
					grid[row - i][col] = 1;
					if ((col - i) >= 1) {
						grid[row - i][col - i] = 1;
					}
					if ((col + i) <= 5) {
						grid[row - i][col + i] = 1;
					}
				}
				if ((col - i) >= 1) {
					grid[row][col- i] = 1;
					if ((row + i) <= 5) {
						grid[row + i][col - i] = 1;
					}
				}
				
			}
		}
		
		int count = 0;
		
		for(int i = 0; i <= 5; i++) {
			for(int j = 0; j <= 5; j++) {
				if(grid[i][j] == 1) {
					count++;
				}
			}
		}
		
		return 25-count;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(n_queen(2, 4, 1));
	}

}
