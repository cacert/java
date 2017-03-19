package strings;

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
	}
}
