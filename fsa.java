package acsl;

import java.util.ArrayList;

public class Fsa {
	
	public static String reg_ex(String a, String b) {
		
		
		
		String result = "";
		ArrayList<String> using = new ArrayList<String>();
		
		if(a.contains("?")) {
			int idx = a.indexOf('?') - 1;
			String use = a.replace("?", "");
			using.add(use);
			if(use.length() >= idx + 2) {
				using.add(use.substring(0, idx) + use.substring(idx + 1));
			}
			else {
				using.add(use.substring(0, idx));
			}
			
		}
		
		else {
			using.add(a);
		}
		
		for(int i = 0; i < using.size(); i++) {
			if(using.get(i).contains("*")) {
				int idx = using.get(i).indexOf('*') -1;
				String use = using.get(i).replace("*", "");
				String prev_char = Character.toString(use.charAt(idx));
				String doub = use.substring(0, idx + 1) + prev_char;
				String tripe = use.substring(0, idx + 1) + prev_char + prev_char;
				
				if(use.length() >= idx + 2) {
					doub += use.substring(idx + 1);
					tripe += use.substring(idx + 1);
				}
				
				using.set(i, use.substring(0, idx) + use.substring(idx + 1));
				using.add(use);
				using.add(doub);
				using.add(tripe);
			}
		}
		
		for(int i = 0; i < using.size(); i++) {
			if(using.get(i).contains("+")) {
				int idx = using.get(i).indexOf('+') -1;
				String use = using.get(i).replace("+", "");
				String prev_char = Character.toString(use.charAt(idx));
				String doub = use.substring(0, idx + 1) + prev_char;
				String tripe = use.substring(0, idx + 1) + prev_char + prev_char;
				
				if(use.length() >= idx + 2) {
					doub += use.substring(idx + 1);
					tripe += use.substring(idx + 1);
				}
				
				using.set(i, use);
				using.add(doub);
				using.add(tripe);
			}
		}
		
//		for(String i : using) {
//			if(i.contains("*")) {
//				int idx = i.indexOf('*') -1;
//				using.add("hello");
//				String use = a.replace("*", "");
//				using.add(use);
//				String doub = Character.toString(a.charAt(idx)) + Character.toString(a.charAt(idx));
//				String tripe = doub + Character.toString(a.charAt(idx));
//				using.add(use.replace(Character.toString(a.charAt(idx)), doub));
//				using.add(use.replace(Character.toString(a.charAt(idx)), tripe));
//			}
//			if(i.contains("+")) {
//				int idx = i.indexOf('+') -1;
//				String use = a.substring(0, idx + 1) + a.substring(idx+2);
//				using.add(use);
//				using.add(a.substring(0, idx + 1) + a.substring(idx+2));
//				using.add(a.substring(0, idx + 1) + Character.toString(a.charAt(idx)) + a.substring(idx+2));
//				using.add(a.substring(0, idx + 1) + Character.toString(a.charAt(idx)) + Character.toString(a.charAt(idx)) + a.substring(idx+2));
//			}
//		}
		
//		if(a.contains("+")) {
//			for(String i : using) {
//				int idx = i.indexOf('+') -1;
//				String use = a.substring(0, idx + 1) + a.substring(idx+2);
//				using.add(use);
//				using.add(a.substring(0, idx + 1) + a.substring(idx+2));
//				using.add(a.substring(0, idx + 1) + Character.toString(a.charAt(idx)) + a.substring(idx+2));
//				using.add(a.substring(0, idx + 1) + Character.toString(a.charAt(idx)) + Character.toString(a.charAt(idx)) + a.substring(idx+2));
//			}
//		}
		
		
		
		for(String i : using) {
			if(b.contains(i)) {
				result += i + " ";
			}
				
//			}
		}
		
		return result;
	
	}

	public static void main(String[] args) {
		System.out.println(reg_ex("xy?", "#, x, y, z, xy, xyz, xxyz, xyyz, yzz, xxxyzz"));
	}

}
