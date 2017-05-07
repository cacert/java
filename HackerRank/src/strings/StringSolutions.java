package strings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.hackerrank.linear.Stack;

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

	public static void main(String[] args) throws Exception {
//		System.err.println(new StringSolutions().countCode("cozfxxcope"));
//		System.err.println(new StringSolutions().compress("ccozfxxcope"));
//		System.err.println(new StringSolutions().checkIfUniqueChars("cozfxpe"));
		StringSolutions.findPalindrome();
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
	
    public static void findPalindrome() throws Exception {
        
        Scanner scanner = new Scanner(new FileInputStream("input14.txt"));
        int lineNum = Integer.parseInt(scanner.nextLine());
        while(lineNum > 0){
            String line = scanner.nextLine();
            findPalindrome(line);
            lineNum --;
        }
        scanner.close();
    }
    
    private static void findPalindrome(String line ){
        int lenght = line.length();
        int j = 0;
        boolean notFound = false;
        int counter = -1;
        for(int i =0 ; i< lenght/2 ;i++,j++){
            if(line.charAt(i) == line.charAt(lenght-1-j))
                continue;
            else{
                if(notFound){
                    System.out.println(-1);
                    return;
                }
                if(line.charAt(i+1)==line.charAt(lenght-1-j)){
                	counter = i;
                    i++;
                    notFound = true;
                }
                else if(line.charAt(i)==line.charAt(lenght-1-j-1)){
                	counter = lenght-1-j;
                    j++;
                    notFound =true;
                }
//                else {//break
//                    System.out.println(counter);
//                    return;
//                }
            }
        }
        System.out.println(counter);
    }
    private static void findPalindromeWithStack(String line ){
    	Stack<Character> stack = new Stack<>();
    	for(int i=0;i<line.length();i++){
    		stack.push(line.charAt(i));
    	}
    	boolean notFound = false;
    	int counter = -1;
    	for(int i=0;i<line.length()/2;i++){
    		char c = stack.pop();
    		if(c != line.charAt(i)){
    			if(notFound){
    				System.out.println(-1);
                    return;
    			}
    			if(stack.peek() == line.charAt(i)){
    				stack.pop();
    				continue;
    			}
    			else if(line.charAt(i+1) == c){
    				i++;
    			}
    		}
    	}
    	System.out.println(counter);
    }
    
}
