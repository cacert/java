package strings;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Hackerrank {
    public static void main(String args[] ) throws Exception {
        
        int countSquare = 0;
		int countRect = 0;
		int countInvalid = 0;
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            int i = solve(scanner.nextLine());
            if(i == 0)
                countSquare ++;
            else if (i ==1)
                countRect ++;
            else
                countInvalid++;
        }
        System.out.println(countSquare + " "+countRect + " "+countInvalid );
        scanner.close();
    }
    private static int solve(String line){
        String[] arr = line.split(" ");
		int a = Integer.parseInt(arr[0]);
		int b = Integer.parseInt(arr[1]);
		int c = Integer.parseInt(arr[2]);
		int d = Integer.parseInt(arr[3]);
		if(a < 0 || b < 0||c < 0|| d < 0 ){
			return 2;
		}
		else if(a== b && a==c && a==d ){
			return 0;
		}
		else if (a == c && b == d )
			return 1;
		else 
			return 2;
    }
    
}