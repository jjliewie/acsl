package acsl;

public class Infix {
	
	public static String prefix(String a) {
		String result = "";
		
		char op [] = {
		'+', '-', '/', '*'
		};
		
		int i = 0;
		int c = 0;
		String place1 = "";
		String place2 = "";
		String k = "";
		String j = "";
		
		while(i < a.length()) {
			if(a.charAt(i) == '*') {
				if (c == 0) {
					k = a.substring(i-1, i);
					j = a.substring(i+1, i+2);
					place1 = "*" + k+j;
					a = a.substring(0, i-1) + "p" + a.substring(i+2);
					i-= 1;
					c += 1;
				}
				else if (c == 1) {
					k = a.substring(i-1, i);
					j = a.substring(i+1, i+2);
					place2 = "*" + k+j;
					a = a.substring(0, i-1) + "h" + a.substring(i+2);
					c += 1;
					i-= 1;
				}
			} 
			i += 1;
		}
		
		int cnt = 1;
		
		String group = "";
		group += a.substring(0, 1);
		while (cnt < a.length()) {
			for(char x : op) {
				if(x == a.charAt(cnt)) {
					group += a.substring(cnt+1, cnt+2);
					result = a.substring(cnt, cnt+1) + result;
					cnt += 1;
				}
			}
			cnt += 1;
			}
		result += group;
		
		int g = 0;
		while(g < result.length()) {
			if (result.charAt(g) == 'p') {
				result = result.replace("p", place1);
			}
			else if (result.charAt(g) == 'h') {
				result = result.replace("h", place2);
			}
			
			g += 1;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(prefix("a*b*b-c"));
	}

}
