package Compare;

public class Main {

	public static void main(String[] args) {
		String str1 = "Hell";
		String str2 = "Hello";
		System.out.println(compareTo(str1, str2));
	}

	static int compareTo(String str1, String str2) {
		for (int i = 0; i < str1.length()&&i<str2.length(); i++) {
			if (str1.codePointAt(i) != str2.codePointAt(i))
				return str1.codePointAt(i) - str2.codePointAt(i);
		}
		return str1.length() - str2.length();
	}

}
