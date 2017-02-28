package DzThread;

import java.util.Scanner;

public class MyThread extends Thread {

	public MyThread() {
		start();
	}

	public MyThread(Runnable target, String name) {
		start();

	}

	@Override
	public void run() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number(Thread(Asc))");
		int count = in.nextInt();
		try {
			Thread.sleep(1000);
			System.out.print("Current Thread:");
			for (int i = 0; i <= count; i++) {
				System.out.print(fib(i) + " ");
			}
			System.out.println();
		} catch (InterruptedException e) {
		}

	}

	int fib(int x) {
		if (x < 2)
			return 1;
		else
			return fib(x - 1) + fib(x - 2);
	}
}
