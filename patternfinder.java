package acsl;

import java.math.BigInteger;
import java.util.Arrays;

public class PatternFinder {
	
	static char [][] slice_array(char [][] grid, int a, int b, int c, int d){
		
		char [][] return_grid = new char[c][d];
		
		for(int i = a; i <a+c; i++) {
			for(int j = b; j<b+d; j++) {
				char element = grid[i][j];
				return_grid[i-a][j-b] = element;
			}
		}
		
		return return_grid;
	}
	
	static String hexToBin(String s) {
		
		String first = Character.toString(s.charAt(0));
		String second = Character.toString(s.charAt(1));
		
		String use1 = new BigInteger(first, 16).toString(2);
		String use2 = new BigInteger(second, 16).toString(2);
		
		while(use1.length() < 4) {
			use1 = "0" + use1;
		}
		while(use2.length() < 4) {
			use2 = "0" + use2;
		}
		return use1+use2;
	}
	
	public static int patternfind(String a, String b) {
		String [] row = a.split(" ");
		int ans = 0;
		
		char [][] grid = new char [8][8];
		
		for(int i = 0; i < row.length; i++) {
			String temp = hexToBin(row[i]);			
			for(int j = 0; j < temp.length(); j++) {
				grid[i][j] = temp.charAt(j);
			}
		}
		
		// grid initialization
		
		String [] section = b.split(" ");
		
		int sub_row = Integer.valueOf(section[0]);
		int sub_col = Integer.valueOf(section[1]);
		
		char [][] sub_grid = new char [sub_row][sub_col];
		
		for(int i = 2; i < sub_row + 2; i++) {
			String binary = section[i];
			for (int j = 0; j < sub_col; j++) {
				sub_grid[i-2][j] = binary.charAt(j);
			}
		}
		
		
		for(int i = 0; i < 8-sub_row; i ++) {
			for(int j = 0; j < 8-sub_col; j++) {
				char [][] try_grid = slice_array(grid, i, j, sub_row, sub_col);
				if(Arrays.deepEquals(sub_grid, try_grid)) {
					ans++;
				}
			}
		}
		
		return ans;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t = patternfind("0C C7 85 D6 46 D7 E6 87", "2 2 00 01");
		
		System.out.println(t);
		

	}

}
