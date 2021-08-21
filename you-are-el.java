package acsl;

import java.util.ArrayList;

public class You_are_el {

public static void main(String[] args) {
System.out.println(url("http://www.acsl.org/contests/96/ALLSTAR/shorts.ps, ../everyday/today/"));
}

	public static String url(String el) {
	
	int idx = el.indexOf(",");
	String first = el.substring(0, idx);
	int protocol_idx = first.indexOf("/");
	String protocol = first.substring(0, protocol_idx + 2);
	String host = first.substring(protocol_idx + 2);
	
	System.out.println(host);
	
	ArrayList<String> path = new ArrayList<String>();
	
	String [] arr = host.split("/");
	for (String s : arr)
	{
	path.add(s);
	}
	
	path.remove(0);
	
	System.out.println(path);
	
	int new_idx = host.indexOf('/');
	
	host = host.substring(0, new_idx);
	
	String second = el.substring(idx + 2);
	
	System.out.println("second: "+ second);
	System.out.println("protocol: "+ protocol);
	System.out.println("host: "+ host);
	
	
	int cnt = 0;
	
	boolean w = false;
	
	if((second.charAt(second.length()-1) == '/') && (second.indexOf("http://") == -1) && second.charAt(0) != '.') {
		String last = path.get(path.size()-1);
		path.remove(last);
		path.add(second.substring(0, second.length()-1));
		path.add(last);
		if((second.charAt(0) == '/')) {
			second += "default.htm";
		}
		second = "default.htm";
	}
	
	for (int i = 0; i < second.length()-2; i++) {
	if (second.substring(i, i + 3).equals("../")) {
	cnt++;
	}
	}
	
	System.out.println(cnt);
	System.out.println("second: " + second);
	
	if (second.indexOf("/") == 0) {
	System.out.println("protocol: "+ protocol);
	return protocol + host + second;
	}
	
	while (cnt > 0) {
	w = true;
	path.remove(path.size() - 1);
	cnt--;
	second = second.substring(3);
	}
	
	if(w) {
		String result = "";
		
		for(int i = 0; i < path.size()-1; i++){
			result += "/" + path.get(i); 
		}
		
		System.out.println("second: " + second);
		
		if(second.charAt(second.length()-1) == '/') {
			return protocol + host + result + "/" + second + "default.htm";
		}
		
		return protocol + host + result + "/"+ second;
	}
	
	if (second.indexOf("/") == -1) {
		
		String result = "";
		
		for(int i = 0; i < path.size()-1; i++){
			result += "/" + path.get(i); 
		}
		
	return protocol + host + result + "/" + second;
	}
	
	if (second.indexOf("http://") != -1) {
	if (second.charAt(second.length() - 1) == '/') {
	return second + "default.htm";
	}
	return second;
	}
	
	return "0";
}
}
