package strings;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringSolutions {
	public int countCode(String str) {
		if (str == null)
			return 0;
		int i = 0;
		int count = 0;
		while (i >= 0 && i < str.length()) {
			i = str.indexOf("co", i);

			if (i >= 0 && (i + 3) < str.length() && str.charAt(i + 3) == 'e') {
				count++;
				i = i + 4;
			}
			else if (i>=0)
				i = i+2;

		}
		return count;
	}

	public static void main(String[] args) {
		System.err.println(new StringSolutions().countCode("cozfxxcope"));
		System.err.println(new StringSolutions().compress("ccozfxxcope"));
		System.err.println(new StringSolutions().checkIfUniqueChars("cozfxpe"));
	}
	
	public String compress(String input){
		if(input == null || input.equals(""))
			return input;
		int cnt = 1;
		StringBuilder bd = new StringBuilder();
		for(int i = 1 ; i < input.length() ; i++ ){
			if(input.charAt(i)==input.charAt(i-1))
				cnt ++;
			else{
				bd.append(input.charAt(i-1)+""+cnt);
				cnt = 1;
			}
		}
		return bd.toString();
	}
	
	public boolean checkIfUniqueChars(String input){
		if(input == null)
			return true;
		return input.length() == input.chars().distinct().count();
	}
}
