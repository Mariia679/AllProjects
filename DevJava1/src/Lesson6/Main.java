package Lesson6;

public class Main {

	public static void main(String[] args) {
		String s="Hello";
		String s1="Hello";
		String s2= new String("hello");
//		System.out.println(s==s1);
//		System.out.println(s==s2);
//		System.out.println(s.charAt(0));
//		System.out.println(s.chars().sum());
		System.out.println(s.codePointAt(0));
//		System.out.println(s.codePointBefore(1));
//		System.out.println(s.codePointCount(0, 5));
//		System.out.println(s.compareTo(s2));
//		//System.out.println(s.concat(s2));
//		System.out.println(s.equals(s2));
//		System.out.println(s.equalsIgnoreCase(s2));
//		System.out.println(s.contains("llo"));
//		StringBuffer cs=new StringBuffer("Hello");
//		System.out.println(s.contentEquals(cs));
//		System.out.println(s.endsWith("lo"));
//		System.out.println(s.indexOf("l"));
//		System.out.println(s.indexOf("l", 3));
//		System.out.println(" ".trim().isEmpty());
//		System.out.println(s.length());
//		System.out.println(s.matches("^[A-Za-z]+$"));
//		System.out.println(s.replace("ll", "fdgf"));
//		System.out.println("dsgddg fc fthy fthytfuyh".replaceAll("\\w+", "1234"));
//		String[] ar="sdfdsf sdfddsf sdfsdf sdfsdf sdf sdf".split("[\\ \\. \\' \\,]");
//		for (int i = 0; i < ar.length; i++) {
//			System.out.println(ar[i]);
//		}
//		System.out.println(delete("Hello I am herro","ll"));
//		//Hllo I am hro
		
	}
	static String delete(String str,String deleted){
		while(str.contains(deleted)){
			int a=str.indexOf(deleted);
			String ar=str.substring(0,a);
			String ar1=str.substring(a+deleted.length());
			str=ar+ar1;
			
		}
		return str;
	}

}
