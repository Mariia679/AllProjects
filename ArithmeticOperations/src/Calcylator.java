import java.util.Scanner;
public class Calcylator {
	public static void main(String[] args){
		/*Scanner in=new Scanner(System.in);
		double first=in.nextDouble();
		double second=in.nextDouble();
		System.out.println("�������� �������� = "+(first+second));
		System.out.println("�������� ��������� = "+(first-second));
		System.out.println("�������� ��������� = "+(first*second));
		System.out.println("�������� ������� = "+(first/second));
		System.out.println("�������� ������� �� ������� = "+(first%second));*/
		String s="Ivan 23 MALE :1-Cat-1-Dog-";
		String[]array=s.split("\\:");
		String s1=array[0];
		System.out.println(s1);
		String[] array1=s1.split("\\ ");
		for(int i=0;i<array1.length;i++)
			System.out.println(array1[i]);
		String s2=array[1];
		System.out.println(s2);
		String[] array2=s2.split("-");
		for(int i=0;i<array2.length;i++)
			System.out.println(array2[i]);
		
	}
}
