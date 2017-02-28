
public class Logical {
	public static void main(String[] args){
		boolean b1=true;
		boolean b2=false;
		b2=!b2;
		System.out.println(b2);
		b1=!b2;
		System.out.println(b1);
		b1=b1&&b2;
		System.out.println(b1);
		b1=b1||b2;
		System.out.println(b1);
		b1=b1^b2;
		System.out.println(b1);
		b1=b1^b2;
		System.out.println(b1);
	}
}
