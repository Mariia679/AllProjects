import java.util.Scanner;
public class Ternary {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int a=in.nextInt();
		int b=in.nextInt();
		System.out.println((a>b)?true:false);
		System.out.println((a<b)?true:false);
		System.out.println((a==b)?"A ����� b":(a>b)?"A ������ b":"� ������ b");


	}
}
