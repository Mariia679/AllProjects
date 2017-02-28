
public class Casting {
	public static void main(String[] args){
		int i=8;
		double d=8.66;
		char c='f';
		boolean b=true;
		i=(char)c;
		System.out.println(i);
		d=(int)d;
		System.out.println(d);
		c=(char)i;
		System.out.println(c);
	}
}
