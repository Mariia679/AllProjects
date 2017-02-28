package DzThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		ExecutorService service = Executors.newFixedThreadPool(5);

		MyThread myThread = new MyThread();
		RunnableThread runnableThread = new RunnableThread();
		System.out.println();
		Future<String> future = service.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				try {
					myThread.join();
					runnableThread.thread.join();
				} catch (InterruptedException e) {
				}
				return "Hello";
			}
		});
		System.out.println(future.get());
		service.shutdown();

	}

}