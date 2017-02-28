package DzThread;

import java.util.Scanner;

public class RunnableThread implements Runnable {
	Thread thread;

	RunnableThread() {
		thread = new Thread(this,"Current Runnable:");
		thread.start();
	}

	@Override
	public void run() {
		Scanner in = new Scanner(System.in);
		
		try {
			Thread.sleep(1000);
			System.out.println("Enter the number(Runnable(Desc))");
			int count = in.nextInt();
			System.out.print("Current Runnable:");
			for (int i = count; i >= 0; i--) {
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
