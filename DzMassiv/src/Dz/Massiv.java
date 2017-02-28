package Dz;

public class Massiv {

	public static void main(String[] args) {
		int[] array = new int[10];
		// 1
		// fill(array);
		// printrow(array);
		// printcol(array);
		// 2
		int[] array1 = new int[50];
		// fill1(array1);
		// printrow(array1);
		// printrevers(array1);
		// 3
		int[] array2 = new int[15];
		// fill2(array2, 0, 9);
		// printrow(array2);
		// System.out.println("Even number= "+even(array2));
		// 4
		int[] array3 = new int[8];
		// fill2(array3, 1, 10);
		// printrow(array3);
		// odd(array3);
		// System.out.println("Replecing the odd zero");
		// printrow(array3);
		// 5
		int[] array4 = new int[5];
		int[] array5 = new int[5];
		// fill2(array4, 0, 5);
		// fill2(array5, 0, 5);
		// printrow(array4);
		// printrow(array5);
		// int a=average(array4);
		// int b=average(array5);
		// System.out.println("First "+a);
		// System.out.println("Second "+b);
		// compare(a,b);
		// 6
		int[] array6 = new int[4];
		// fill2(array6,10,99);
		// printrow(array6);
		// inspection(array6);
		// 7
		int[] fib1 = new int[20];
		// fillfib(fib1);
		// printrow(fib1);
		// 8
		int[] array7 = new int[12];
		// fill2(array7,-15,15);
		// printrow(array7);
		// System.out.println("Index max element is " +max(array7));
		//9
		int[] array8=new int[10];
		int[] array9=new int[10];
		double[] array10=new double[10];
		// fill2(array8,1,9);
		// fill2(array9,1,9);
		// printrow(array8);
		// printrow(array9);
		// filldouble(array10,array8,array9);
		// printdouble(array10);
		//10
		int[] array11=new int[11];
		fill2(array11,-1,1);
		printrow(array11);
		moreOften(array11);
	}

	static int random(int min, int max) {
		return (int) Math.round(Math.random() * (max - min) + min);
	}
	

	// 1
	static void fill(int[] array) {
		for (int i = 0; i < array.length; i++)
			array[i] = (i + 1) * 2;
	}

	static void printrow(int[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}

	static void printcol(int[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.println(array[i]);
	}

	// 2
	static void fill1(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = (i + 1) * 2 - 1;
		}
	}

	static void printrevers(int[] array) {
		for (int i = array.length - 1; i >= 0; i--)
			System.out.print(array[i] + " ");
		System.out.println();
	}

	// 3
	static void fill2(int[] array, int min, int max) {
		for (int i = 0; i < array.length; i++)
			array[i] = random(min, max);
	}

	static int even(int[] array) {
		int j = 0;
		for (int i = 0; i < array.length; i++)
			if (array[i] % 2 == 0)
				j++;
		return j;
	}

	// 4
	static void odd(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 1)
				array[i] = 0;
		}
	}

	// 5
	static int average(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum / array.length;
	}

	static void compare(int a, int b) {
		if (a > b)
			System.out.println("Average of first array greater than second");
		else if (a == b)
			System.out.println("They are equal");
		else
			System.out.println("Average of second array greater than first");
	}

	// 6
	static void inspection(int[] array) {
		int a = 0;
		int b = 0;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				System.out.println("Not strictly increasing sequence ");
				break;
			}
		}
	}

	// 7
	static int fib(int x) {
		if (x < 2)
			return 1;
		else
			return fib(x - 1) + fib(x - 2);
	}

	static void fillfib(int[] array) {
		for (int i = 0; i < array.length; i++)
			array[i] = fib(i);
	}

	// 8
	static int max(int[] array) {
		int max = -15;
		int j = 0;
		for (int i = 0; i < array.length; i++) {
			if (max <= array[i]) {
				max = array[i];
				j = i;
			}
		}
		System.out.println("Max element of the array is " + max);
		return j;
	}
	//9
	static void filldouble(double[] array,int[] array1,int[] array2){
		for (int i = 0; i < array2.length; i++) {
			array[i]=(double)array1[i]/(double)array2[i];
		}
	}
	static void printdouble(double[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}
	//10
	static void moreOften(int[] array){
		int a=0;
		int b=0;
		int c=0;
		for (int i = 0; i < array.length; i++) {
			if(array[i]==0)a++;
			if(array[i]==-1)b++;
			if(array[i]==1)c++;
		}
		System.out.println("0="+a);
		System.out.println("-1="+b);
		System.out.println("1="+c);
		if(a>b&&a>c)System.out.println("Most common is 0");
		else if(b>a&&b>c)System.out.println("Most common is -1");
		else if(c>a&&c>b)System.out.println("Most common is 1");
	}
}
